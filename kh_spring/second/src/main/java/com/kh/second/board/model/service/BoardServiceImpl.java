package com.kh.second.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.second.board.model.dao.BoardDao;
import com.kh.second.board.model.vo.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<Board> selectTop3() {
		return boardDao.selectTop3();
	}
	
	@Override
	public int selectGetListCount() {
		return boardDao.selectGetListCount();
	}
	
	@Override
	public ArrayList<Board> selectList(int currentPage, int limit) {
		return boardDao.selectList(currentPage, limit);
	}
	
	@Override
	public int insertOriginBoard(Board board) {
		return boardDao.insertOriginBoard(board);
	}
	
	@Override
	public int updateAddReadCount(int boardNum) {
		return boardDao.updateAddReadCount(boardNum);
	}
	
	@Override
	public Board selectBoard(int boardNum) {
		return boardDao.selectBoard(boardNum);
	}
	
	@Override
	public int updateReplySeq(Board reply) {
		return boardDao.updateReplySeq(reply);
	}
	
	@Override
	public int insertReply(Board reply) {
		return boardDao.insertReply(reply);
	}
	
	@Override
	public int deleteBoard(Board board) {
		return boardDao.deleteBoard(board);
	}
	
	@Override
	public int updateReply(Board reply) {
		return boardDao.updateReply(reply);
	}
	
	@Override
	public int updateOrigin(Board board) {
		return boardDao.updateOrigin(board);
	}
	
}
