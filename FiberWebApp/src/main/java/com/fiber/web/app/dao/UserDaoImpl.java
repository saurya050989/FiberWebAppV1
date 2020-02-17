package com.fiber.web.app.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.UserDto;
import com.fiber.web.app.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDaoInt {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long nextPk() {
		StringBuffer nextPk_sql = new StringBuffer("select count(*) from USER_DTO");
		int pk = jdbcTemplate.queryForObject(nextPk_sql.toString(), Integer.class);
		return pk + 1;
	}

	@Override
	public long add(UserDto dto, UserContext context) {

		StringBuffer insert_sql = new StringBuffer(
				"insert into user_dto values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		return jdbcTemplate.update(insert_sql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, nextPk());
				ps.setString(2, dto.getFirstName());
				ps.setString(3, dto.getLastName());
				ps.setString(4, dto.getLoginId());
				ps.setString(5, dto.getPassword());
				ps.setString(6, dto.getGender());
				ps.setString(7, dto.getMobileNo());
				ps.setString(8, dto.getAlternateMobileNo());
				ps.setDate(9, new Date(dto.getDob().getDate()));
				ps.setString(10, dto.getRoleName());
				ps.setLong(11, dto.getRoleId());
				ps.setString(12, dto.getStatus());
				ps.setLong(13, dto.getImageId());
				ps.setTimestamp(14, dto.getLastLogin());
				ps.setLong(15, dto.getUnsucessfulLoginAttempt());
				ps.setDate(16, new Date(dto.getValidFromDate().getDate()));
				ps.setDate(17, new Date(dto.getValidToDate().getDate()));
				ps.setTime(18, dto.getAccessTimeFrom());
				ps.setTime(19, dto.getAccessTimeTo());
				ps.setString(20, dto.getCreatedBy());
				ps.setString(21, dto.getModifiedBy());
				ps.setTimestamp(22, dto.getCreatedDateTime());
				ps.setTimestamp(23, dto.getModifiedDateTime());
			}
		});
	}

	@Override
	public long update(UserDto dto, UserContext context) {
		StringBuffer update_sql = new StringBuffer(
				"update user_dto set FIRST_NAME=?, LAST_NAME=?, LOGIN_ID=?, PASSWORD=?, GENDER=?, MOBILE_NO=?, ALTERNATE_MOBILE_NO=?, DOB=?, ROLE_NAME=?, ROLE_ID=?, STATUS=?, IMAGE_ID=?, LAST_LOGIN=?, UNSUCCESSFUL_LOGIN_ATTEMPT=?, VALID_FROM_DATE=?, VALID_TO_DATE=?, ACCESS_TIME_FROM=?, ACCESS_TIME_TO=?, CREATED_BY=?, MODIFIED_BY=?, CREATED_DATE_TIME=?, MODIFIED_DATE_TIME=? where ID=?");
		return jdbcTemplate.update(update_sql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getFirstName());
				ps.setString(2, dto.getLastName());
				ps.setString(3, dto.getLoginId());
				ps.setString(4, dto.getPassword());
				ps.setString(5, dto.getGender());
				ps.setString(6, dto.getMobileNo());
				ps.setString(7, dto.getAlternateMobileNo());
				ps.setDate(8, new Date(dto.getDob().getDate()));
				ps.setString(9, dto.getRoleName());
				ps.setLong(10, dto.getRoleId());
				ps.setString(11, dto.getStatus());
				ps.setLong(12, dto.getImageId());
				ps.setTimestamp(13, dto.getLastLogin());
				ps.setLong(14, dto.getUnsucessfulLoginAttempt());
				ps.setDate(15, new Date(dto.getValidFromDate().getDate()));
				ps.setDate(16, new Date(dto.getValidToDate().getDate()));
				ps.setTime(17, dto.getAccessTimeFrom());
				ps.setTime(18, dto.getAccessTimeTo());
				ps.setString(19, dto.getCreatedBy());
				ps.setString(20, dto.getModifiedBy());
				ps.setTimestamp(21, dto.getCreatedDateTime());
				ps.setTimestamp(22, dto.getModifiedDateTime());
				ps.setLong(23, dto.getId());
			}
		});
	}

	@Override
	public long delete(long id, UserContext context) {

		StringBuffer delete_sql = new StringBuffer("delete from user_dto where ID=?");

		return jdbcTemplate.update(delete_sql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	@Override
	public UserDto findByPk(long id, UserContext context) {
		StringBuffer select_record_by_id = new StringBuffer("select * from user_dto where ID=?");

		// method 1to fetch single row(one object) from database using row mapper

		/*
		 * UserDto userDto = jdbcTemplate.queryForObject(select_record_by_id.toString(),
		 * new Object[] { id }, new UserMapper()); return userDto;
		 */

		// method 2 to fetch single row(one object) from database using bean property
		// row mapper

		UserDto existUserDto = jdbcTemplate.queryForObject(select_record_by_id.toString(), new Object[] { id },
				new BeanPropertyRowMapper<>(UserDto.class));
		return existUserDto;
	}

	@Override
	public UserDto findByLogin(String loginId, UserContext context) {

		StringBuffer select_by_login_id = new StringBuffer("select * from user_dto where LOGIN_ID=?");

		// method one to fetch data by login id using row mapper

		/*
		 * UserDto queryUserDto =
		 * jdbcTemplate.queryForObject(select_by_login_id.toString(), new Object[] {
		 * loginId }, new UserMapper()); return queryUserDto;
		 */

		// method two to fetch data by login id using bean property row mapper

		UserDto queryUserDto = jdbcTemplate.queryForObject(select_by_login_id.toString(), new Object[] { loginId },
				new BeanPropertyRowMapper<>(UserDto.class));
		return queryUserDto;
	}

	@Override
	public List<UserDto> serach(UserDto dto, UserContext context) {
		return search(dto, 0, 0, context);
	}

	@Override
	public List<UserDto> search(UserDto dto, int pageNo, int pageSize, UserContext context) {
		StringBuffer pagination_sql = new StringBuffer("select * from user_dto where 1=1");

		if (dto.getId() > 0) {
			pagination_sql.append(" ID =" + dto.getId());
		}
		if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
			pagination_sql.append(" and fisrt_name like'" + dto.getFirstName() + "%'");
		}
		if (dto.getLastName() != null && dto.getFirstName().length() > 0) {
			pagination_sql.append(" and last_name like'" + dto.getLastName() + "%'");
		}
		if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {
			pagination_sql.append(" and login_id like'" + dto.getLoginId() + "%'");
		}

		if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
			pagination_sql.append(" and mobile_no like'" + dto.getMobileNo() + "%'");
		}
		if (dto.getDob() != null) {
			pagination_sql.append(" and dob = " + dto.getDob());
		}

		// pagination

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			pagination_sql.append(" Limit " + pageNo + "," + pageSize);
		}

		List<UserDto> userList = jdbcTemplate.query(pagination_sql.toString(), new UserMapper());
		return userList;
	}

	@Override
	public List<UserDto> list() {
		return list(0, 0);
	}

	@Override
	public List<UserDto> list(int pageNo, int pageSize) {

		StringBuffer list_sql = new StringBuffer("select * from user_dto ");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			list_sql.append(" Limit " + pageNo + "," + pageSize);
		}
		List<UserDto> userList = jdbcTemplate.query(list_sql.toString(), new UserMapper());
		return userList;
	}

	@Override
	public UserDto authentiacte(String loginId, String password) {

		StringBuffer authentiacte_Sql = new StringBuffer("select * from USER_DTO where LOGIN_ID=? and PASSWORD=?");

		// first method to fetch one row from database using BEAN PROPERTY ROW MAPPER
		/*
		 * UserDto authentiacteDto =
		 * jdbcTemplate.queryForObject(authentiacte_Sql.toString(), new Object[] {
		 * loginId, Password }, new BeanPropertyRowMapper<>(UserDto.class)); return
		 * authentiacteDto;
		 */

		// second method to fetch one row from database using ROW MAPPER

		UserDto authentiacteDto = jdbcTemplate.queryForObject(authentiacte_Sql.toString(),
				new Object[] { loginId, password }, new UserMapper());
		return authentiacteDto;
	}

}
