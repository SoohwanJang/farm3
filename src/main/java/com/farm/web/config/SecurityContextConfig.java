package com.farm.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {
   
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
 
	      http
	         .authorizeRequests()
	            .antMatchers("/admin/**").hasRole("ADMIN")  //해당 url에 해당 역할자만 들어와야함.
	            //admin/ 모든 하위 경로에 ADMIN이라는 역할을 갖고있는애한테 인증을 허가한다.
	            .antMatchers("/seller/**").hasAnyRole("SELLER", "ADMIN") 
	            .antMatchers("/member/basket/**").authenticated()
	            .antMatchers("/member/orderitem/**").authenticated()
	            .antMatchers("/member/index").authenticated()
	            .and() 
	            .formLogin() //우리가 만든 로그인 페이지로 넘기기
	               .loginPage("/member/login") //GET URL (URL에 보이는 로그인 경로)
	               .loginProcessingUrl("/member/login") //POST URL
	               .defaultSuccessUrl("/index") //로그인이 성공하면 index로 넘김
	               //.successHandler(successHandler) //로그인 성공하면, 되는 로직 괄호안은 넘길 url쓰면됨
	               //.failureHandler(authenticationFailureHandler) //로그인 실패하면, 되는 로직 괄호안은 넘길 url쓰면됨
	               //.successHandler(new NewlectureAuthenticationSuccessHandler())
	               .and()
	            .logout() //로그아웃 설정
	               .logoutUrl("/member/logout") //로그아웃 경로 (URL에 보이는 로그아웃 경로)
	               .logoutSuccessUrl("/index")   // 로그아웃 되면 넘어갈 경로
	               .invalidateHttpSession(true)//사용자 로그아웃시 세션 초기화
	               .and()
	            .csrf() //csrf무효화 시키는 방법
	               .disable();
   }
   
   @Bean
   public UserDetailsService userDetailsService() {
	   UserDetailsService service = new MyUserDetailsService();
	   return service;
   }
 
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  
      auth
      	 .userDetailsService(userDetailsService())
         .passwordEncoder(new BCryptPasswordEncoder());
      
   }
   
}