package com.inoutcorp.cpq.opportunity.service;

import java.util.List;

import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

public interface OpportunityCRUDService {

	OpportunityVo create(OpportunityVo opportunityVo);

	OpportunityVo update(OpportunityVo opportunityVo);

	OpportunityVo read(String id);

	boolean delete(String id);

	List<OpportunityVo> readAll(Long pageNo, Long pageSize, String sortBy,
			Boolean asc);

}
