package com.inoutcorp.cpq.opportunity.entity.base;

import java.util.Calendar;

public interface IEntity {

	Long getPkey();

	void setPkey(Long pkey);
	
	Integer getVersion();

	void setVersion(Integer version);
	
	Boolean getDeletedFlag();
    
    void setDeletedFlag(Boolean deletedFlag);
    
	String getCreatedBy();

	void setCreatedBy(String createdBy);
	
	Calendar getCreatedTime();

	void setCreatedTime(Calendar createdTime);

	String getChangedBy();

	void setChangedBy(String changedBy);

	Calendar getChangedTime();

	void setChangedTime(Calendar changedTime);    
}