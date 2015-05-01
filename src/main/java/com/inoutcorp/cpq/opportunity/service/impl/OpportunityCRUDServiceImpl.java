package com.inoutcorp.cpq.opportunity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.utils.InOutCPQConstants;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

public class OpportunityCRUDServiceImpl implements OpportunityCRUDService {

	private static final Logger LOGGER = Logger
			.getLogger(OpportunityCRUDServiceImpl.class);

	private static final Map<String, OpportunityVo> opportunityMap = new HashMap<String, OpportunityVo>();

	private static long opportunityId = InOutCPQConstants.OPPORTUNITY_SEQUENCE_NUMBER;

	public OpportunityVo upsert(OpportunityVo opportunityVo) {
		OpportunityVo updatedOpportunityVo = null;

		if (opportunityVo != null && opportunityVo.getId() != null
				&& !"".equalsIgnoreCase(opportunityVo.getId())) {
			opportunityMap.put(opportunityVo.getId(), opportunityVo);

			updatedOpportunityVo = opportunityMap.get(opportunityVo.getId());

		} else {
			++opportunityId;

			opportunityVo.setId(BigDecimal.valueOf(opportunityId)
					.toPlainString());

			opportunityMap.put(opportunityVo.getId(), opportunityVo);

			updatedOpportunityVo = opportunityMap.get(opportunityVo.getId());

		}

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
