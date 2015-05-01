package com.inoutcorp.cpq.opportunity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.utils.InOutCPQConstants;
import com.inoutcorp.cpq.opportunity.utils.InOutErrorCodes;
import com.inoutcorp.cpq.opportunity.utils.InOutException;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

/**
 * The Class OpportunityCRUDServiceImpl.
 */
public class OpportunityCRUDServiceImpl implements OpportunityCRUDService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(OpportunityCRUDServiceImpl.class);

	/** The Constant opportunityMap. */
	private static final Map<String, OpportunityVo> opportunityMap = new HashMap<String, OpportunityVo>();

	/** The opportunity id. */
	private static long opportunityId = InOutCPQConstants.OPPORTUNITY_SEQUENCE_NUMBER;

	/**
	 * upsert. This method saves or updates new opportunity
	 *
	 * @param opportunityVo
	 *            the opportunity vo
	 * @return the response
	 */
	public OpportunityVo upsert(OpportunityVo opportunityVo) {
		OpportunityVo updatedOpportunityVo = null;

		if (opportunityVo != null && opportunityVo.getId() != null
				&& !"".equalsIgnoreCase(opportunityVo.getId())) {
			/*
			 * If opportunity ID is provided, then its update request
			 */

			synchronized (opportunityMap) {
				/*
				 * Use synchronized block to write into the opportunity Map
				 */
				opportunityMap.put(opportunityVo.getId(), opportunityVo);
			}

			updatedOpportunityVo = opportunityMap.get(opportunityVo.getId());

		} else {

			/*
			 * If Opportunity ID is not provided, then its create request
			 */

			synchronized (opportunityMap) {
				/*
				 * Generate opportunity sequence number
				 */
				++opportunityId;

				opportunityVo.setId(BigDecimal.valueOf(opportunityId)
						.toPlainString());

				opportunityMap.put(opportunityVo.getId(), opportunityVo);
			}

			updatedOpportunityVo = opportunityMap.get(opportunityVo.getId());

		}

		return updatedOpportunityVo;
	}

	/**
	 * read. Read the Opportunity Object using the key ID
	 *
	 * @param id
	 *            the opportunity id
	 * @return the OpportunityVo
	 */
	public OpportunityVo read(String id) throws InOutException {
		OpportunityVo opportunityVo = null;
		if (id != null && !"".equalsIgnoreCase(id)) {
			opportunityVo = opportunityMap.get(id);
			if (opportunityVo == null)
				throw new InOutException(InOutErrorCodes.NOT_FOUND,
						"Opportunity Not Found");
		} else {
			throw new InOutException(InOutErrorCodes.NOT_FOUND,
					"Opportunity ID Not Provided");
		}

		return opportunityVo;

	}

	/**
	 * Delete. This Deletes the Opportunity Object based on the ID
	 *
	 * @param opportunityVo
	 *            the opportunity vo
	 * @return the response
	 * @throws InOutException
	 */
	public boolean delete(String id) throws InOutException {

		if (id != null && !"".equalsIgnoreCase(id)) {
			OpportunityVo opportunityVo = opportunityMap.get(id);
			if (opportunityVo == null)
				throw new InOutException(InOutErrorCodes.NOT_FOUND,
						"Opportunity Not Found");
			else
				synchronized (opportunityMap) {
					opportunityMap.remove(id);
				}

		} else {
			throw new InOutException(InOutErrorCodes.NOT_FOUND,
					"Opportunity ID Not Provided");
		}

		return true;
	}

	/**
	 * readAll. Returns all the opportunities
	 *
	 * @param List
	 *            <OpportunityVo> List of Opportunity
	 * @return the opportunityVos
	 */
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
