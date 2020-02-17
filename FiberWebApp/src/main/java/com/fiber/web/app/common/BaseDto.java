package com.fiber.web.app.common;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseDto implements Serializable, DropdownList, Comparable<BaseDto>{
	
	/**
	 * UID for serilization
	 */
	private static final long serialVersionUID = -6798048176901643521L;

	protected long id;
	
	protected String createdBy;
	
	protected String modifiedBy;
	
	protected Timestamp createdDateTime;
	
	protected Timestamp modifiedDateTime;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
}
