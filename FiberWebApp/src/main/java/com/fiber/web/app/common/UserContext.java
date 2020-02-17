package com.fiber.web.app.common;

import com.fiber.web.app.dto.UserDto;

public class UserContext {

	private long userId = 0;

	private String firstname = "root";

	private String lastName = "root";

	private String loginId = "root@gmail.com";

	private String gender = "root";

	private long roleId = 0;

	private String roleName = "root";

	private long imageId = 0;

	private UserDto userDto = null;

	public UserContext() {

	}

	public UserContext(UserDto dto) {

		this.setUserDto(dto);
		this.userId = dto.getId();
		this.firstname = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.loginId = dto.getLoginId();
		this.gender = dto.getGender();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
		this.imageId = dto.getImageId();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

}
