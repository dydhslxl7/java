package com.kh.second.notice.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.second.notice.model.service.NoticeService;
import com.kh.second.notice.model.vo.Notice;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("nlist.do")
	public ModelAndView moveNoticeList(ModelAndView mv) {
		ArrayList<Notice> list = noticeService.selectList();

		if(list.size() > 0) {
			mv.addObject("list", list);
			mv.setViewName("notice/noticeListView");
		}else {
			mv.addObject("message", "공지사항 목록 페이지 이동 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}

	@RequestMapping("ndetail.do")
	public ModelAndView moveNoticeDetail(@RequestParam("noticeno") String no, ModelAndView mv) {
		Notice notice = noticeService.selectOne(Integer.parseInt(no));

		if(notice != null) {
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeDetailView");
		}else {
			mv.addObject("message", "공지사항 상세 뷰 불러오기 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}

	//	@RequestMapping("nfdown.do")
	//	public void noticeFileDown() {
	//		
	//	}

	@RequestMapping("adnlist.do")
	public ModelAndView moveAdminNoticeList(ModelAndView mv) {
		ArrayList<Notice> list = noticeService.selectList();

		if(list.size() > 0) {
			mv.addObject("list", list);
			mv.setViewName("notice/noticeAdminListView");
		}else {
			mv.addObject("message", "공지사항 목록 페이지 이동 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}

	@RequestMapping("andetail.do")
	public ModelAndView moveAdminNoticeDetail(@RequestParam("noticeno") String no, ModelAndView mv) {
		Notice notice = noticeService.selectOne(Integer.parseInt(no));

		if(notice != null) {
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeAdminDetailView");
		}else {
			mv.addObject("message", "공지사항 상세 뷰 불러오기 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}

	@RequestMapping("nwrite.do")
	public String moveWriteForm() {
		return "notice/noticeWriteForm";
	}
	
	@RequestMapping(value="ninsert.do", method=RequestMethod.POST)
	public String insertNotice(Notice notice, HttpServletRequest request, @RequestParam(name="ofile", required=false) MultipartFile file) {
		logger.info("ninsertad.do run...\n notice : " + notice + "file : " + file.getOriginalFilename());
		String original_filepath = file.getOriginalFilename();
		notice.setOriginal_filepath(original_filepath);
		
		//업로드할 파일의 용량 제한 : servlet-context.xml 에서 multipartResolver가 관리중

		//저장 폴더에 같은 이름의 파일이 있을 경우를 대비해서 "년월일시분초.확장자"형식으로 저장하기
		if(original_filepath != null || !original_filepath.equals(" ")) {   //첨부파일이 있을 경우
			//파일 저장 경로 지정하기
			String savePath = request.getSession().getServletContext().getRealPath("resources/nupfiles");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rename_filepath = sdf.format(new java.sql.Date(System.currentTimeMillis())); //현재시간
			rename_filepath += "." + original_filepath.substring(original_filepath.lastIndexOf(".") + 1); //확장자명

			try {
				file.transferTo(new File(savePath + "\\" + rename_filepath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			notice.setRename_filepath(rename_filepath);
		} 

		if(noticeService.insertNotice(notice) > 0) {
			return "redirect:/adnlist.do";
		} else {
			request.setAttribute("messate", "새 공지사항 등록 처리 실패");
			return "common/error";
		}
	}

	@RequestMapping("ndel.do")
	public String noticeDelete(@RequestParam("noticeno") String no, Model model) {
		if(noticeService.deleteNotice(Integer.parseInt(no)) > 0) {


			return "redirect:adnlist.do";
		}else {
			model.addAttribute("message", "공지사항 삭제 실패!");
			return "common/error";
		}
	}

	@RequestMapping("npmove.do")
	public ModelAndView moveNoticeUpdateViewPage(@RequestParam("noticeno") String no, ModelAndView mv) {
		Notice notice = noticeService.selectOne(Integer.parseInt(no));
		if(notice != null) {
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeUpdateView");
		}else {
			mv.addObject("message", "공지사항 상세 뷰 불러오기 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	@RequestMapping(value="nupdate.do", method=RequestMethod.POST)
	public String updateNotice(Notice notice, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile upfile) {
		String originalFileName = notice.getOriginal_filepath();
		String renameFileName = notice.getRename_filepath();
		String deleteFlag = request.getParameter("deleteFlag");
		String savePath = request.getSession().getServletContext().getRealPath("resources/nupfiles");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String newOriginalFileName = upfile != null ? upfile.getOriginalFilename() : null;
		String newRenameFileName = null;


		if (newOriginalFileName != null) {
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
			notice.setOriginal_filepath(newOriginalFileName);
			notice.setRename_filepath(newRenameFileName);
		} else if (!originalFileName.isEmpty() && deleteFlag != null && deleteFlag.equals("yes")) {
			notice.setOriginal_filepath(null);
			notice.setRename_filepath(null);
			new File(savePath + "\\" + renameFileName).delete();
		} else if (!originalFileName.isEmpty() && (newOriginalFileName == null || originalFileName.equals(newOriginalFileName) &&
				new File(savePath+ "\\" + renameFileName).length() == new File(savePath + "\\" + newRenameFileName).length())) {
			notice.setOriginal_filepath(originalFileName);
			notice.setRename_filepath(renameFileName);
		}
		logger.info(newOriginalFileName);

		if (noticeService.updateNotice(notice) > 0) {
			return "redirect:adnlist.do";
		} else {
			return "common/error";
		}
	}

	@RequestMapping("ntop3.do")
	@ResponseBody
	public String noticeTop3(HttpServletResponse response) {
		ArrayList<Notice> list = noticeService.selectNewTop3();
		JSONObject sendObject = new JSONObject();
		JSONArray jarr = new JSONArray();

		try {
			if(list.size() > 0) {

				for(Notice n : list) {
					JSONObject job = new JSONObject();
					job.put("no", n.getNoticeno());
					job.put("title", URLEncoder.encode(n.getNoticetitle(), "utf-8"));
					job.put("date", n.getNoticedate().toString());

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

}
