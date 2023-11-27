package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 해당 클래스가 컨트롤러의 기능을 수행한다는 의미
public class HelloController {
    @GetMapping("/hello") // Get 방식의 URL 요청 / Post 방식의 URL 요청은 PostMapping 사용
    @ResponseBody // 응답 결과가 문자열 그 자체임을 나타냄
    public String hello() {
    	return "Hello Spring Boot Board";
    }
}