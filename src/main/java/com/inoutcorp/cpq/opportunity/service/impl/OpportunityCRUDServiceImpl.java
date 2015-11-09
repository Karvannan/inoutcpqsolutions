package com.inoutcorp.cpq.opportunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.inoutcorp.cpq.opportunity.api.IDao;
import com.inoutcorp.cpq.opportunity.entity.Opportunity;
import com.inoutcorp.cpq.opportunity.entity.base.IEntity;
import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.utils.InOutException;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

/**
 * The Class OpportunityCRUDServiceImpl.
 */
public class OpportunityCRUDServiceImpl implements OpportunityCRUDService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(OpportunityCRUDServiceImpl.class);

	@Autowired
	private IDao<IEntity, Long> dao;

	public IDao<IEntity, Long> getDao() {
		return dao;
	}

	public void setDao(IDao<IEntity, Long> dao) {
		this.dao = dao;
	}

	private Opportunity getOpportunity(OpportunityVo opportunityVo) {
		Opportunity opportunity = new Opportunity();
		opportunity.setAmount(opportunityVo.getAmount());
		opportunity.setChangedBy(opportunityVo.getChangedBy());
		opportunity.setChangedTime(opportunityVo.getChangedTime());
		opportunity.setClosedDate(opportunityVo.getClosedDate());
		opportunity.setCreatedBy(opportunityVo.getCreatedBy());
		opportunity.setCreatedTime(opportunityVo.getCreatedTime());
		opportunity.setDeletedFlag(opportunityVo.getDeletedFlag());
		opportunity.setDescription(opportunityVo.getDescription());
		opportunity.setIsClosed(opportunityVo.getIsClosed());
		opportunity.setIsoCode(opportunityVo.getIsoCode());
		opportunity.setIsWon(opportunityVo.getIsWon());
		opportunity.setName(opportunityVo.getName());
		opportunity.setPkey(opportunityVo.getPkey());
		opportunity.setVersion(opportunityVo.getVersion());
		return opportunity;
	}

	private OpportunityVo getOpportunityVo(Opportunity opportunity) {
		OpportunityVo opportunityVo = new OpportunityVo();
		opportunityVo.setAmount(opportunity.getAmount());
		opportunityVo.setChangedBy(opportunity.getChangedBy());
		opportunityVo.setChangedTime(opportunity.getChangedTime());
		opportunityVo.setClosedDate(opportunity.getClosedDate());
		opportunityVo.setCreatedBy(opportunity.getCreatedBy());
		opportunityVo.setCreatedTime(opportunity.getCreatedTime());
		opportunityVo.setDeletedFlag(opportunity.getDeletedFlag());
		opportunityVo.setDescription(opportunity.getDescription());
		opportunityVo.setIsClosed(opportunity.getIsClosed());
		opportunityVo.setIsoCode(opportunity.getIsoCode());
		opportunityVo.setIsWon(opportunity.getIsWon());
		opportunityVo.setName(opportunity.getName());
		opportunityVo.setPkey(opportunity.getPkey());
		opportunityVo.setVersion(opportunity.getVersion());
		return opportunityVo;
	}

	/**
	 * Upsert.
	 *
	 * @param opportunityVos
	 *            the opportunity vos
	 * @return the opportunity vo
	 */
	@Transactional
	public List<Long> upsert(List<OpportunityVo> opportunityVos) {
		List<Long> ids = new ArrayList<Long>();
		for (OpportunityVo opportunityVo : opportunityVos) {
			ids.add(upsert(opportunityVo).getPkey());
		}
		return ids;
	}

	/**
	 * upsert. This method saves or updates new opportunity
	 *
	 * @param opportunityVo
	 *            the opportunity vo
	 * @return the response
	 */
	@Transactional
	public OpportunityVo upsert(OpportunityVo opportunityVo) {
		Opportunity opportunity = getOpportunity(opportunityVo);
		Long oppId = dao.saveOrUpdate(opportunity);
		opportunity.setPkey(oppId);
		return getOpportunityVo(opportunity);
	}

	/**
	 * read. Read the Opportunity Object using the key ID
	 *
	 * @param id
	 *            the opportunity id
	 * @return the OpportunityVo
	 * @throws InOutException
	 *             the in out exception
	 */
	@Transactional
	public OpportunityVo read(Long pkey) throws InOutException {
		Opportunity opportunity = dao.find(Opportunity.class, pkey);
		return getOpportunityVo(opportunity);
	}

	/**
	 * Delete. This Deletes the Opportunity Object based on the ID
	 *
	 * @param id
	 *            the id
	 * @return the response
	 * @throws InOutException
	 *             the in out exception
	 */
	@Transactional
	public boolean delete(Long pkey) throws InOutException {
		dao.delete(dao.find(Opportunity.class, pkey));
		return true;
	}

	/**
	 * readAll. Returns all the opportunities
	 *
	 * @param pageNo
	 *            the page no
	 * @param pageSize
	 *            the page size
	 * @param sortBy
	 *            the sort by
	 * @param asc
	 *            the asc
	 * @return the opportunityVos
	 */
	@Transactional
	public List<OpportunityVo> readAll(Long pageNo, Long pageSize,
			String sortBy, Boolean asc) {
		List<Opportunity> opportunities = dao.findAll(Opportunity.class, null);
		List<OpportunityVo> opportunityVos = new ArrayList<OpportunityVo>();
		for (Opportunity opportunity : opportunities) {
			opportunityVos.add(getOpportunityVo(opportunity));
		}
		return opportunityVos;
	}

}
