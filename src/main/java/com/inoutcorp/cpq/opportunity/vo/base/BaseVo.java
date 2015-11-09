package com.inoutcorp.cpq.opportunity.vo.base;

import java.io.Serializable;
import java.util.Calendar;

public class BaseVo implements Serializable {

	private static final long serialVersionUID = 7665388940974264209L;

	private Long pkey;

	private Boolean deletedFlag = false;

	private String createdBy;

	private Calendar createdTime;

	private String changedBy;

	private Calendar changedTime;

	private Integer version;

	public Long getPkey() {
		return pkey;
	}

	public void setPkey(Long pkey) {
		this.pkey = pkey;
	}

	public Boolean getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Calendar getChangedTime() {
		return changedTime;
	}

	public void setChangedTime(Calendar changedTime) {
		this.changedTime = changedTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
