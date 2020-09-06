package com.kh.second.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.second.board.model.service.BoardService;
import com.kh.second.board.model.vo.Board;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	private String savePath(HttpServletRequest request) {
		String savePath = request.getSession().getServletContext().getRealPath("resources/bupfiles");
		return savePath;
	}
	
	@RequestMapping("blist.do")
	public ModelAndView boardListView(HttpServletRequest request, ModelAndView mv) {
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;
		
		int listCount = boardService.selectGetListCount();
		
		ArrayList<Board> list = boardService.selectList(currentPage, limit);
		
		int maxPage = (int)((double)listCount / limit + 0.9);
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage +limit - 1;
		if(maxPage < endPage)
			endPage = maxPage;
		
		if(list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("currentPage", currentPage);
			mv.addObject("listCount", listCount);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startPage", startPage);
			mv.addObject("endPage", endPage);
			mv.setViewName("board/boardListView");
		}else {
			mv.addObject("message", "게시글 목록 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	@RequestMapping("btop3.do")
	@ResponseBody
	public String boardTop3(HttpServletResponse response) {
		ArrayList<Board> list = boardService.selectTop3();
		JSONObject sendObject = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		try {
			if(list.size() > 0) {
				for(Board b : list) {
					JSONObject job = new JSONObject();
					job.put("bnum", b.getBoard_num());
					job.put("btitle", URLEncoder.encode(b.getBoard_title(), "utf-8"));
					job.put("rcount", b.getBoard_readcount());

					jarr.add(job);
				}
				sendObject.put("list", jarr);
			}
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			return sendObject.toString();
		}
	}
	
	@RequestMapping("bdetail.do")
	public ModelAndView moveBoardDetail(@RequestParam("bnum") int no, HttpServletRequest request, ModelAndView mv) {
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		Board board = boardService.selectBoard(no);
		
		int result = boardService.updateAddReadCount(no);
		
		if(board != null && result > 0) {
			mv.addObject("currentPage", currentPage);
			mv.addObject("board", board);
			mv.setViewName("board/boardDetailView");
		}else {
			mv.addObject("message", "공지사항 상세 뷰 불러오기 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	@RequestMapping("replyform.do")
	public ModelAndView moveReplyForm(@RequestParam("bnum") String no, @RequestParam("page") int page, ModelAndView mv) {
		mv.addObject("page", page);
		mv.addObject("bnum", no);
		mv.setViewName("board/boardReplyForm");
		return mv;
	}
	
	@RequestMapping("writeForm.do")
	public String moveWriteForm() {
		return "board/boardWriteForm";
	}
	
	@RequestMapping("bdelete.do")
	public String boardDelete(Board board, Model model, HttpServletRequest request) {
		
		board.setBoard_num(Integer.parseInt(request.getParameter("bnum")));
		board.setBoard_level(Integer.parseInt(request.getParameter("level")));
		
		int result = boardService.deleteBoard(board);
		
		if(result > 0) {
			if(request.getParameter("rfileName") != null) {
				String savePath = request.getSession().getServletContext().getRealPath("resources/bupfiles");
				new File(savePath + "\\" + request.getParameter("rfileName")).delete();
			}
			return "redirect:blist.do";
		}else {
			model.addAttribute("message", "게시물 삭제 실패!");
			return "common/error";
		}
	}
	
	@RequestMapping("bfdown.do")
	public ModelAndView boardFileDown(HttpServletRequest request, @RequestParam() String ofile, @RequestParam() String rfile) {
		String savePath = request.getSession().getServletContext().getRealPath("resources/bupfiles");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("savePath", savePath);
		map.put("ofileName", ofile);
		map.put("rfileName", rfile);
		
		return new ModelAndView("nbfileDown", "map", map);
	}
	
	@RequestMapping(value="binsert.do", method=RequestMethod.POST)
	public String boardOriginInsert(@RequestParam(name="ofile", required=false) MultipartFile file, HttpServletRequest request, Board board) {
		
		String savePath = savePath(request);
		
		String ofileName = file.getOriginalFilename();
		board.setBoard_original_filename(ofileName);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rfileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));
		rfileName += "." + ofileName.substring(ofileName.lastIndexOf(".") + 1);
		board.setBoard_rename_filename(rfileName);
		
		try {
			file.transferTo(new File(savePath + "\\" + rfileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = boardService.insertOriginBoard(board);
		
		if(result > 0) {
			return "redirect:blist.do";
		}else {
			request.setAttribute("message", "게시글 등록 실패!");
			return "common/error";
		}
	}
	
	@RequestMapping("bupview.do")
	public String moveBoardUpdate(HttpServletRequest request, Model model) {
		Board board = boardService.selectBoard(Integer.parseInt(request.getParameter("bnum")));
		model.addAttribute("board", board);
		model.addAttribute(request.getParameter("page"));
		return "board/boardUpdateView";
	}

	@RequestMapping(value = "boriginup.do", method = RequestMethod.POST)
	public String updateBoardOrigin(Board board, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile upfile) {
		String originalFileName = board.getBoard_original_filename();
		String renameFileName = board.getBoard_rename_filename();
		String deleteFlag = request.getParameter("deleteFlag");
		String savePath = savePath(request);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String newOriginalFileName = upfile != null ? upfile.getOriginalFilename() : null;
		String newRenameFileName = null;

		if (newOriginalFileName != null && !originalFileName.equals(newOriginalFileName)) {
			newRenameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()));
			newRenameFileName += "." + newOriginalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			try {
				upfile.transferTo(new File(savePath + "\\" + newRenameFileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			if (renameFileName != null) {
				new File(savePath + "\\" + renameFileName).delete();
			}
			board.setBoard_original_filename(newOriginalFileName);
			board.setBoard_rename_filename(newRenameFileName);
		} else if (!originalFileName.isEmpty() && deleteFlag != null && deleteFlag.equals("yes")) {
			board.setBoard_original_filename(null);
			board.setBoard_rename_filename(null);
			new File(savePath + "\\" + renameFileName).delete();
		} else if (!originalFileName.isEmpty() && (newOriginalFileName == null || originalFileName.equals(newOriginalFileName) &&
				new File(savePath+ "\\" + renameFileName).length() == new File(savePath + "\\" + newRenameFileName).length())) {
			board.setBoard_original_filename(originalFileName);
			board.setBoard_rename_filename(renameFileName);
		}
		logger.info(newOriginalFileName);

		if (boardService.updateOrigin(board) > 0) {
			return "redirect:blist.do";
		} else {
			return "common/error";
		}
	}

	
}
