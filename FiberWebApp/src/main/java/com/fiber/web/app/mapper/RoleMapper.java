package com.fiber.web.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fiber.web.app.dto.RoleDto;

public class RoleMapper implements RowMapper<RoleDto> {

	@Override
	public RoleDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		RoleDto roleDto=new RoleDto();
		roleDto.setId(rs.getLong(1));
		roleDto.setName(rs.getString(2));
		roleDto.setDescription(rs.getString(3));
		roleDto.setCanRead(rs.getString(4));
		roleDto.setCanWrite(rs.getString(5));
		roleDto.setCanUpdate(rs.getString(6));
		roleDto.setCanDelete(rs.getString(7));
		roleDto.setStatus(rs.getString(8));
		roleDto.setCreatedBy(rs.getString(9));
		roleDto.setModifiedBy(rs.getString(10));
		roleDto.setCreatedDateTime(rs.getTimestamp(11));
		roleDto.setModifiedDateTime(rs.getTimestamp(12));
		return roleDto;
	}

}
