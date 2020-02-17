package com.fiber.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.RoleDto;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleServiceInt {

	@Override
	public long addRole(RoleDto dto, UserContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateRole(RoleDto dto, UserContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteRole(long id, UserContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleDto findByPk(long id, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDto findByRoleName(String roleName, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> search(RoleDto dto, int pageNo, int pageSize, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> serach(RoleDto dto, UserContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
