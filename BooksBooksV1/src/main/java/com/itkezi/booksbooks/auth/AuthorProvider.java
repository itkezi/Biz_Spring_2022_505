package com.itkezi.booksbooks.auth;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itkezi.booksbooks.model.AuthorityVO;
import com.itkezi.booksbooks.model.UserVO;
import com.itkezi.booksbooks.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationProvider")
public class AuthorProvider  implements AuthenticationProvider{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserVO userVO = userDao.findById(username);
		log.debug("로그인 한 사용자 {}", userVO);
		
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " 이 없습");
		}
		
		String encPassword = userVO.getPassword();
		
		if(  !passwordEncoder.matches(password, encPassword)  ) {
			throw new BadCredentialsException("비밀번호 오류!!");
		}
		
		List<AuthorityVO> authList = userDao.select_auths(username);
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		for(AuthorityVO vo : authList) {
			grantList.add(new SimpleGrantedAuthority(vo.getAuthority()));
		}
		
		return new UsernamePasswordAuthenticationToken(
				userVO, null,grantList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}