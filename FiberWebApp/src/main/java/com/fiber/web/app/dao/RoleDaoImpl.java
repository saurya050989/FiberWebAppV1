package com.fiber.web.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.fiber.web.app.common.UserContext;
import com.fiber.web.app.dto.RoleDto;
import com.fiber.web.app.mapper.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDaoInt {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long nextPk() {
		StringBuffer nextPk_sql = new StringBuffer("select count(*) from ROLE_DTO");
		int pk = jdbcTemplate.queryForObject(nextPk_sql.toString(), Integer.class);
		return pk + 1;
	}

	@Override
	public long addRole(RoleDto dto, UserContext context) {

		StringBuffer addRoleQuery = new StringBuffer("insert into ROLE_DTO values (?,?,?,?,?,?,?,?,?,?,?,?)");

		// mthod 1 to insert data
		/*
		 * return jdbcTemplate.update(addRoleQuery.toString(), new Object[] {
		 * dto.getId(), dto.getName(), dto.getDescription(), dto.getCanRead(),
		 * dto.getCanWrite(), dto.getCanUpdate(), dto.getCanDelete(), dto.getStatus(),
		 * dto.getCreatedBy(), dto.getModifiedBy(), dto.getCreatedDateTime(),
		 * dto.getModifiedDateTime() });
		 */

		// method 2 to insert data

		return jdbcTemplate.update(addRoleQuery.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, nextPk());
				ps.setString(2, dto.getName());
				ps.setString(3, dto.getDescription());
				ps.setString(4, dto.getCanRead());
				ps.setString(5, dto.getCanWrite());
				ps.setString(6, dto.getCanUpdate());
				ps.setString(7, dto.getCanDelete());
				ps.setString(8, dto.getStatus());
				ps.setString(9, dto.getCreatedBy());
				ps.setString(10, dto.getModifiedBy());
				ps.setTimestamp(11, dto.getCreatedDateTime());
				ps.setTimestamp(12, dto.getModifiedDateTime());
			}
		});

	}

	@Override
	public long updateRole(RoleDto dto, UserContext context) {

		StringBuffer upadateSql = new StringBuffer(
				"update ROLE_DTO set NAME=?, DESCRIPTION=?, CAN_READ=?, CAN_WRITE=?, CAN_UPDATE=?, CAN_DELETE=?, STATUS=?, CREATED_BY=?, MODIFIED_BY=?, CREATED_DATE_TIME=?, MODIFIED_DATE_TIME=? where ID=?");
		/*
		 * 
		 * return jdbcTemplate.update(upadateSql.toString(), new Object[] {
		 * dto.getName(), dto.getDescription(), dto.getCanRead(), dto.getCanWrite(),
		 * dto.getCanUpdate(), dto.getCanDelete(), dto.getStatus(), dto.getCreatedBy(),
		 * dto.getModifiedBy(), dto.getCreatedDateTime(), dto.getModifiedDateTime(),
		 * dto.getId() });
		 */
		return jdbcTemplate.update(upadateSql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getDescription());
				ps.setString(3, dto.getCanRead());
				ps.setString(4, dto.getCanWrite());
				ps.setString(5, dto.getCanUpdate());
				ps.setString(6, dto.getCanDelete());
				ps.setString(7, dto.getStatus());
				ps.setString(8, dto.getCreatedBy());
				ps.setString(9, dto.getModifiedBy());
				ps.setTimestamp(10, dto.getCreatedDateTime());
				ps.setTimestamp(11, dto.getModifiedDateTime());
				ps.setLong(12, dto.getId());
			}
		});
	}

	@Override
	public long deleteRole(long id, UserContext context) {
		StringBuffer deleteSql = new StringBuffer("delete from ROLE_DTO where ID=?");

		// method 1 to delete record

		// return jdbcTemplate.update(deleteSql.toString(), new Object[] {id});

		// method 2 to delete record

		return jdbcTemplate.update(deleteSql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	@Override
	public RoleDto findByPk(long id, UserContext context) {

		StringBuffer pkSql = new StringBuffer("select * from ROLE_DTO where ID=?");

		// method 1 to fetch single record from database using row mapper
		/*
		 * RoleDto roleDto=jdbcTemplate.queryForObject(pkSql.toString(), new Object[]
		 * {id}, new RoleMapper()); return roleDto;
		 */

		// method 2 to fetch single record from data base using bean property row mapper

		RoleDto roleDto = jdbcTemplate.queryForObject(pkSql.toString(), new Object[] { id },
				new BeanPropertyRowMapper<>(RoleDto.class));
		return roleDto;
	}

	@Override
	public RoleDto findByRoleName(String roleName, UserContext context) {

		StringBuffer findRoleSql = new StringBuffer("select * from ROLE_DTO where NAME=?");

		// method 1 to fetch one record
		/*
		 * RoleDto roleDto=jdbcTemplate.queryForObject(findRoleSql.toString(), new
		 * Object[] {roleName}, new RoleMapper()); return roleDto;
		 */

		// method 2 to fetch one object from database

		RoleDto roleDto = jdbcTemplate.queryForObject(findRoleSql.toString(), new Object[] { roleName },
				new BeanPropertyRowMapper<>(RoleDto.class));
		return roleDto;
	}

	@Override
	public List<RoleDto> search(RoleDto dto, int pageNo, int pageSize, UserContext context) {

		StringBuffer searchSql = new StringBuffer("select * from ROLE_DTO where 1=1");

		if (dto.getId() > 0) {
			searchSql.append(" AND ID =" + dto.getId());
		}
		if (dto.getName() != null && dto.getName().length() > 0) {
			searchSql.append(" AND NAME like '" + dto.getName() + "%'");
		}

		// pagination
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			searchSql.append(" LIMIT" +pageNo+","+ pageSize);
		}
		List<RoleDto> roleList = jdbcTemplate.query(searchSql.toString(), new Object[] { dto.getId(), dto.getName() },
				new RoleMapper());
		return roleList;
	}

	@Override
	public List<RoleDto> serach(RoleDto dto, UserContext context) {
		return search(dto, 0, 0, context);
	}

	@Override
	public List<RoleDto> list() {
		return list(0, 0);
	}

	@Override
	public List<RoleDto> list(int pageNo, int pageSize) {
		
		StringBuffer listSql = new StringBuffer("select * from ROLE_DTO");
		
		if(pageSize>0)
		{
			pageNo = (pageNo - 1) * pageSize;
			listSql.append(" LIMIT" + pageNo + "," + pageSize);	
		}
		List<RoleDto> roleList=jdbcTemplate.query(listSql.toString(), new RoleMapper());
		return roleList;

	}

}
