package com.fiber.web.app.dto;

import com.fiber.web.app.common.BaseDto;

public class RoleDto extends BaseDto {

	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String ACTIVE = "active";
	public static final String INACTIVATE = "Inactive";

	private String name;

	private String description;

	private String canRead = YES;

	private String canWrite = YES;

	private String canUpdate = YES;

	private String canDelete = YES;

	private String status = ACTIVE;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCanRead() {
		return canRead;
	}

	public void setCanRead(String canRead) {
		this.canRead = canRead;
	}

	public String getCanWrite() {
		return canWrite;
	}

	public void setCanWrite(String canWrite) {
		this.canWrite = canWrite;
	}

	public String getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(String canUpdate) {
		this.canUpdate = canUpdate;
	}

	public String getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(String canDelete) {
		this.canDelete = canDelete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return name;
	}

	@Override
	public int compareTo(BaseDto o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
