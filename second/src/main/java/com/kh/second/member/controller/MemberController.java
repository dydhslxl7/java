package com.kh.second.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.second.member.model.vo.Member;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginMethod(Member member, Model model) {
//		String userid = request.getParameter("userid");
//		String userpwd = request.getParameter("userpwd");
//		Member member = new Member();
//		member.setUserid(userid);
//		member.setUserpwd(userpwd);
		
		logger.info("login.do : "+member.getUserid()+", "+member.getUserpwd());
		
		return "common/main";
	}
}
