package com.fiber.web.app.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.fiber.web.app.common.BaseDto;

public class UserDto extends BaseDto {

	private static final String ACTIVATE = "activate";
	private static final String DEACTIVATE = "deactivate";
	private static final String LOCKED = "lock";

	private String firstName;

	private String lastName;

	private String loginId;

	private String password;

	private String gender;

	private String mobileNo;

	private String alternateMobileNo;

	private Date dob;

	private String roleName;

	private long roleId;

	private String status;

	private long imageId;

	private Timestamp lastLogin;

	private long unsucessfulLoginAttempt;

	private Date validFromDate;

	private Date validToDate;

	private Time accessTimeFrom;

	private Time accessTimeTo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(String alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public long getUnsucessfulLoginAttempt() {
		return unsucessfulLoginAttempt;
	}

	public void setUnsucessfulLoginAttempt(long unsucessfulLoginAttempt) {
		this.unsucessfulLoginAttempt = unsucessfulLoginAttempt;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public Time getAccessTimeFrom() {
		return accessTimeFrom;
	}

	public void setAccessTimeFrom(Time accessTimeFrom) {
		this.accessTimeFrom = accessTimeFrom;
	}

	public Time getAccessTimeTo() {
		return accessTimeTo;
	}

	public void setAccessTimeTo(Time accessTimeTo) {
		this.accessTimeTo = accessTimeTo;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(BaseDto o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
