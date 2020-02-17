package com.fiber.web.app.dao;

import java.util.List;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.UserDto;

public interface UserDaoInt {

	public long nextPk();

	public long add(UserDto dto, UserContext context);

	public long update(UserDto dto, UserContext context);

	public long delete(long id, UserContext context);

	public UserDto findByPk(long id, UserContext context);

	public UserDto findByLogin(String loginId, UserContext context);

	public List<UserDto> search(UserDto dto, int pageNo, int pageSize, UserContext context);

	public List<UserDto> serach(UserDto dto, UserContext context);

	public List<UserDto> list();

	public List<UserDto> list(int pageNo, int pageSize);

	public UserDto authentiacte(String loginId, String Password);

}
