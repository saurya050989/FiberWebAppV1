package com.fiber.web.app.service;

import java.util.List;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.UserDto;

public interface UserServiceInt {

	public long addUser(UserDto dto, UserContext context);

	public long updateUser(UserDto dto, UserContext context);

	public long deleteUser(long id, UserContext context);

	public UserDto findUserByPk(long id, UserContext context);

	public UserDto findUserByLogin(String loginId, UserContext context);

	public List<UserDto> searchUser(UserDto dto, int pageNo, int pageSize, UserContext context);

	public List<UserDto> serachUser(UserDto dto, UserContext context);

	public List<UserDto> listUser();

	public List<UserDto> listUser(int pageNo, int pageSize);

	public UserDto authentiacteUser(String loginId, String Password);
	
	public long forgetPassword(String loginId, UserContext context);
	
	public void changePassword(long id, String newPassword,String oldPassword);
	
	public long registerUser(UserDto dto);
}
