package com.kh.second.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.second.board.model.vo.Board;
import com.kh.second.board.model.vo.BoardPage;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public BoardDao() {}

	public ArrayList<Board> selectTop3() {
		List<Board> list = session.selectList("boardMapper.selectTop3");
		return (ArrayList<Board>)list;
	}

	public int selectGetListCount() {
		return session.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		//전달된 값을 이용해서 출력할 시작행과 끝행을 계산함
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		//2개의 값을 한 객체에 저장함
		BoardPage bpage = new BoardPage(startRow, endRow);

		List<Board> list = session.selectList("boardMapper.selectList", bpage);
		return (ArrayList<Board>)list;
	}

	public int insertOriginBoard(Board board) {
		return session.insert("boardMapper.insertOriginBoard", board);
	}

	public int updateAddReadCount(int boardNum) {
		return session.update("boardMapper.addReadCount", boardNum);
	}

	public Board selectBoard(int boardNum) {
		return session.selectOne("boardMapper.selectBoard", boardNum);
	}

	public int updateReplySeq(Board reply) {
		int result = 0;
		if(reply.getBoard_level() == 1)
			result = session.update("boardMapper.updateReplySeq1", reply);
		if(reply.getBoard_level() == 2)
			result = session.update("boardMapper.updateReplySeq2", reply);
		return result;
	}
	
	public int insertReply(Board reply) {
		int result = 0;
		if(reply.getBoard_level() == 1) {
			result = session.insert("boardMapper.insertReply1", reply);
		}
		if(reply.getBoard_level() == 2) {
			result = session.insert("boardMapper.insertReply2", reply);
		}
		return result;
	}

	public int deleteBoard(Board board) {
		return session.delete("boardMapper.deleteBoard", board);
	}

	public int updateReply(Board reply) {
		return session.update("boardMapper.updateReply", reply);
	}

	public int updateOrigin(Board board) {
		return session.update("boardMapper.updateOrigin", board);
	}
}