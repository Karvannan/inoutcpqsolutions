package com.inoutcorp.cpq.opportunity.service;

import java.util.List;

import com.inoutcorp.cpq.opportunity.utils.InOutException;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

/**
 * The Interface OpportunityCRUDService.
 */
public interface OpportunityCRUDService {

	/**
	 * Upsert.
	 *
	 * @param opportunityVo
	 *            the opportunity vo
	 * @return the opportunity vo
	 */
	OpportunityVo upsert(OpportunityVo opportunityVo);

	/**
	 * Upsert.
	 *
	 * @param opportunityVos
	 *            the opportunity vos
	 * @return the opportunity vo
	 */
	List<Long> upsert(List<OpportunityVo> opportunityVos);

	/**
	 * Read.
	 *
	 * @param id
	 *            the id
	 * @return the opportunity vo
	 * @throws InOutException
	 *             the in out exception
	 */
	OpportunityVo read(Long id) throws InOutException;

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @return true, if successful
	 * @throws InOutException
	 *             the in out exception
	 */
	boolean delete(Long id) throws InOutException;

	/**
	 * Read all.
	 *
	 * @param pageNo
	 *            the page no
	 * @param pageSize
	 *            the page size
	 * @param sortBy
	 *            the sort by
	 * @param asc
	 *            the asc
	 * @return the list
	 */
	List<OpportunityVo> readAll(Long pageNo, Long pageSize, String sortBy,
			Boolean asc);

}
