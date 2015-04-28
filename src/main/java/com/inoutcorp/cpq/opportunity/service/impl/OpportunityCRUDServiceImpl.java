package com.inoutcorp.cpq.opportunity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

public class OpportunityCRUDServiceImpl implements OpportunityCRUDService {

	private static final Logger LOGGER = Logger
			.getLogger(OpportunityCRUDServiceImpl.class);

	private static final Map<String, OpportunityVo> opportunityMap = new HashMap<String, OpportunityVo>();

	private static long opportunityId = 400000000000000000l;

	public OpportunityVo create(OpportunityVo opportunityVo) {

		OpportunityVo createdOpportunityVo = null;

		++opportunityId;

		opportunityVo.setId(BigDecimal.valueOf(opportunityId).toPlainString());
		
		opportunityMap.put(opportunityVo.getId(), opportunityVo);

		createdOpportunityVo = opportunityMap.get(opportunityVo.getId());

		return createdOpportunityVo;
	}

	public OpportunityVo update(OpportunityVo opportunityVo) {
		OpportunityVo updatedOpportunityVo = null;

		opportunityMap.put(opportunityVo.getId(), opportunityVo);

		updatedOpportunityVo = opportunityMap.get(opportunityVo.getId());

		return updatedOpportunityVo;
	}

	public OpportunityVo read(String id) {
		return opportunityMap.get(id);
	}

	public boolean delete(String id) {

		opportunityMap.remove(id);

		return true;
	}

	public List<OpportunityVo> readAll(Long pageNo, Long pageSize,
			String sortBy, Boolean asc) {

		List<OpportunityVo> opportunityVos = null;
		try {
			opportunityVos = new ArrayList<OpportunityVo>(
					opportunityMap.values());
		} catch (Exception e) {
			LOGGER.error("Error ", e);
		}
		return opportunityVos;
	}

}
