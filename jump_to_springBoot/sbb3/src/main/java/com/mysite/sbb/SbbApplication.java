package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 시작을 담당하는 파일에 꼭 필요한 애너테이션
/*
 * <프로젝트명> + Application.java : 시작을 담당하는 파일
 */
public class SbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}

}
