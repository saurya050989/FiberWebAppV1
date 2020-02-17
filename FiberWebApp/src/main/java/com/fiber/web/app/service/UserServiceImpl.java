package com.fiber.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dao.UserDaoInt;
import com.fiber.web.app.dto.UserDto;

@Service(value = "userService")
public class UserServiceImpl implements UserServiceInt {
	
	@Autowired
	private UserDaoInt userDaoInt;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long addUser(UserDto dto, UserContext context) {
		return userDaoInt.add(dto, context);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long updateUser(UserDto dto, UserContext context) {
    return 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long deleteUser(long id, UserContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDto findUserByPk(long id, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findUserByLogin(String loginId, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> searchUser(UserDto dto, int pageNo, int pageSize, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> serachUser(UserDto dto, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> listUser(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto authentiacteUser(String loginId, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long forgetPassword(String loginId, UserContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changePassword(long id, String newPassword, String oldPassword) {
		
	}

	@Override
	public long registerUser(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
