package com.kh.second.board.model.service;

import java.util.ArrayList;

import com.kh.second.board.model.vo.Board;

public interface BoardService {
	ArrayList<Board> selectTop3();
	int selectGetListCount();
	ArrayList<Board> selectList(int currentPage, int limit);
	int insertOriginBoard(Board board);
	int updateAddReadCount(int boardNum);
	Board selectBoard(int boardNum);
	int updateReplySeq(Board reply);
	int insertReply(Board reply);
	int deleteBoard(Board board);
	int updateReply(Board reply);
	int updateOrigin(Board board);
}