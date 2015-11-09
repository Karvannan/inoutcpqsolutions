package com.inoutcorp.cpq.opportunity.utils;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.inoutcorp.cpq.opportunity.entity.base.AbstractEntity;

public class PersistenceListener {

	@PrePersist
	void onPreCreate(Object entity) {
		AbstractEntity baseEntity = (AbstractEntity) entity;
		if (baseEntity.getCreatedTime() == null)
			baseEntity.setCreatedTime(Calendar.getInstance());
		baseEntity.setChangedTime(Calendar.getInstance());
		if (baseEntity.getCreatedBy() == null
				|| baseEntity.getCreatedBy().length() <= 0) {
			String createdBy = "karvannan";
			baseEntity.setCreatedBy(createdBy);
			baseEntity.setChangedBy(createdBy);
		} else {
			baseEntity.setChangedBy(baseEntity.getCreatedBy());
		}

		if (baseEntity.getDeletedFlag() == null) {
			baseEntity.setDeletedFlag(false);
		}
	}

	@PreUpdate
	void onPreUpdate(Object entity) {
		AbstractEntity baseEntity = (AbstractEntity) entity;
		baseEntity.setChangedTime(Calendar.getInstance());
		String changedBy = "karvannan";

		if ("anonymous".equalsIgnoreCase(changedBy)) {
			if (baseEntity.getChangedBy() == null
					|| baseEntity.getChangedBy().toString().length() <= 0) {
				baseEntity.setChangedBy(baseEntity.getCreatedBy());
			}
		} else {
			baseEntity.setChangedBy(changedBy);
		}

		if (baseEntity.getDeletedFlag() == null) {
			baseEntity.setDeletedFlag(false);
		}
	}

}