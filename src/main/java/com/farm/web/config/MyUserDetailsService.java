package com.farm.web.config;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farm.web.dao.MemberDao;
import com.farm.web.entity.Member;


public class MyUserDetailsService implements UserDetailsService {

   @Autowired
   private MemberDao memberDao;
   
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      // TODO Auto-generated method stub
      
      MyUserDetails userDetails = null;
      Member member = memberDao.getByUid(username);

	 // Member 데이터(**), 인증과 권한 정보
	 userDetails = new MyUserDetails(member);
      
      return userDetails;
   }
   
   

}