package com.fiber.web.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fiber.web.app.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setId(rs.getInt(1));
		userDto.setFirstName(rs.getString(2));
		userDto.setLastName(rs.getString(3));
		userDto.setLoginId(rs.getString(4));
		userDto.setPassword(rs.getString(5));
		userDto.setGender(rs.getString(6));
		userDto.setMobileNo(rs.getString(7));
		userDto.setAlternateMobileNo(rs.getString(8));
		userDto.setDob(rs.getDate(9));
		userDto.setRoleName(rs.getString(10));
		userDto.setRoleId(rs.getLong(11));
		userDto.setStatus(rs.getString(12));
		userDto.setImageId(rs.getLong(13));
		userDto.setLastLogin(rs.getTimestamp(14));
		userDto.setUnsucessfulLoginAttempt(rs.getLong(15));
		userDto.setValidFromDate(rs.getDate(16));
		userDto.setValidToDate(rs.getDate(17));
		userDto.setAccessTimeFrom(rs.getTime(18));
		userDto.setAccessTimeTo(rs.getTime(19));
        return userDto;
	}

}
