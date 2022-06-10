package com.callor.naver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
	/*
	 * /spMVC_003_SchoolV7/src/main/webapp/WEB-INF/spring/appServlet/security-context.xml
	 * 를 class를 이용하여 만든 것
	 */
	
	/*
	 * *-context.xml 파일 대신에 Java class를 사용하여 bean 설정하기
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(4);
		return encoder;
	}

}
