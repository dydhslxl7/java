package com.kh.second.member.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.second.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService	{

	@Override
	public Member loginCheck(Member member) {
		return null;
	}
	
	@Override
	public int insertMember(Member member) {
		int result = 0;
		return result;
	}
	
	@Override
	public int updateMember(Member member) {
		int result = 0;
		return result;
	}
	
	@Override
	public int deleteMember(String userid) {
		int result = 0;
		return result;
	}
	
	@Override
	public ArrayList<Member> selectList() {
		return null;
	}
	
}
