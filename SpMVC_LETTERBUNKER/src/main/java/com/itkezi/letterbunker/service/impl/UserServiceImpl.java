package com.itkezi.letterbunker.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itkezi.letterbunker.model.AuthorityVO;
import com.itkezi.letterbunker.model.UserVO;
import com.itkezi.letterbunker.persistance.UserDao;
import com.itkezi.letterbunker.service.UserService;

@Service("userServiceV1")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@Override
	public void create_user_table() {
		
	}

	@Override
	public void create_auth_table() {
		
	}

	@Override
	public List<AuthorityVO> select_auths(String username) {
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return null;
	}

	@Transactional
	@Override
	public int insert(UserVO vo) {
		
		List<UserVO> userList = userDao.selectAll();
		List<AuthorityVO> authList = new ArrayList<>();
		
		// 최초에 가입하는 회원
		if(userList == null || userList.size() < 1) {
			authList.add(AuthorityVO.builder()
							.username(vo.getUsername())
							.authority("ROLE_ADMIN")
							.build()
					);
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build()
			);
			vo.setEnabled(true);
		} else {
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build()
			);
			vo.setEnabled(false);
		}
		
		String encPassword = passEncoder.encode(vo.getPassword());
		vo.setPassword(encPassword);
		
		int ret = userDao.role_insert(authList);
		ret += userDao.insert(vo);
		return ret;
		
	}

	@Override
	public int update(UserVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int role_insert(List<AuthorityVO> auths) {
		return 0;
	}

}