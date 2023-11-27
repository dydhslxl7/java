package com.kh.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//스프링에서 작성되는 컨트롤러 클래스 안의 메소드 헤드 위에는 반드시 아래의 어노테이션을 작성해야 함
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String main(Model model) {
		//스프링이 제공하는 Model 클래스 : request + response 객체임
		//request.setAttribute("이름", 객체);
		model.addAttribute("test", "컨트롤러의 값 저장 테스트 문자열 객체");
		
		return "main"; //디스패쳐 서블릿의 뷰 리졸버로 파일명을 리턴함
	}
	
}
