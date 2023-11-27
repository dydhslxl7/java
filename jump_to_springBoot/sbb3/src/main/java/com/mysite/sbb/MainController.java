package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sbb")
    @ResponseBody // 생략하면 아래 문자열 이름의 템플릿을 찾는다.
    public String index() {
    	return "안녕하세요 sbb에 오신것을 환영합니다.";
    }
    
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}