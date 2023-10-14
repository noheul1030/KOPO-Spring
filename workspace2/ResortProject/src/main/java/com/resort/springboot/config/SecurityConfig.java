package com.resort.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
		// 페이지 권한에 대한 구현
		// 현재 services url에 대한 접근 권한은 ADMIN만 가능
//            	.requestMatchers(new AntPathRequestMatcher("/services/**")).hasAuthority("ROLE_ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/services/**")).hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
				.requestMatchers(new AntPathRequestMatcher("/noticeBoard_delete")).hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/noticeBoard_update")).hasAnyAuthority("ROLE_ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/reservationView/**"))
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER").requestMatchers(new AntPathRequestMatcher("/**"))
				.permitAll()).csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
				.headers((headers) -> headers.addHeaderWriter(
						new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
				.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/"))
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/").invalidateHttpSession(true).clearAuthentication(true)
						.deleteCookies("JSESSIONID"));
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}