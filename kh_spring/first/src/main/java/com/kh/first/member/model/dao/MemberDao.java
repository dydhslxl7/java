package com.kh.first.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.SearchDate;

public class MemberDao {
	public MemberDao() {}
	
	public Member loginCheck(SqlSession session, Member member) {
		return session.selectOne("memberMapper.loginCheck", member);
	}

	public int insertMember(SqlSession session, Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	public Member selectMember(SqlSession session, String userid) {
		return session.selectOne("memberMapper.selectMember", userid);
	}

	public int deleteMember(SqlSession session, String userid) {
		return session.delete("memberMapper.deleteMember", userid);
	}
	
	public int updateMember(SqlSession session, Member member) {
		return session.update("memberMapper.updateMember", member);
	}

	public ArrayList<Member> selectList(SqlSession session) {
		List<Member> list = session.selectList("memberMapper.selectList");
		return (ArrayList<Member>)list;
	}

	public int updateLoginOK(SqlSession session, Member member) {
		return session.update("memberMapper.updateLoginOK", member);
	}

	public ArrayList<Member> selectSearchUserid(SqlSession session, String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchUserid", keyword);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchGender(SqlSession session, String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchGender", keyword);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchAge(SqlSession session, int keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchAge", keyword);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchEnrollDate(SqlSession session, SearchDate date) {
		List<Member> list = session.selectList("memberMapper.selectSearchEnrollDate", date);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchLoginOk(SqlSession session, String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchLoginOk", keyword);
		return (ArrayList<Member>)list;
	}

	public int selectCheckId(SqlSession session, String userid) {
		return session.selectOne("memberMapper.selectCheckId", userid);
	}

}

