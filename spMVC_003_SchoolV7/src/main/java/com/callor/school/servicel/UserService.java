package com.callor.school.servicel;

import com.callor.school.model.UserVO;

public interface UserService {

	public UserVO login(UserVO userVO);
	public UserVO join(UserVO userVO);
	
}
