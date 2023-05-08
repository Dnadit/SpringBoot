package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.DispatcherType;

/*
* Spring Security 환경 설정을 구성하기 위한 클래스.
* 웹 서비스가 로드 될 때 Spring Container에 의해 관리가 되는 클래스이며,
* 사용자에 대한 인증과 인가에 대한 구성을 Bean 매서드로 주입한다.
* */

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http
				.authorizeHttpRequests(request -> request
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(login -> login
						.loginPage("/login")
//						.loginProcessingUrl("/api/login") // submit받을 url
						.usernameParameter("id")
						.passwordParameter("password")
						.defaultSuccessUrl("/getBoardList", true)
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout") // 로그아웃 처리 url
						.logoutSuccessUrl("/")
				);

		return http.build();
	}

}
