package com.fiber.web.app.dao;

import java.util.List;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.RoleDto;

public interface RoleDaoInt {
	

	public long nextPk();

	public long addRole(RoleDto dto, UserContext context);

	public long updateRole(RoleDto dto, UserContext context);

	public long deleteRole(long id, UserContext context);

	public RoleDto findByPk(long id, UserContext context);

	public RoleDto findByRoleName(String roleName, UserContext context);

	public List<RoleDto> search(RoleDto dto, int pageNo, int pageSize, UserContext context);

	public List<RoleDto> serach(RoleDto dto, UserContext context);

	public List<RoleDto> list();

	public List<RoleDto> list(int pageNo, int pageSize);

}
