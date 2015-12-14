package com.inoutcorp.cpq.opportunity.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.utils.InOutCPQConstants;
import com.inoutcorp.cpq.opportunity.utils.InOutException;
import com.inoutcorp.cpq.opportunity.utils.JSONUtils;
import com.inoutcorp.cpq.opportunity.vo.InOutCorpResponse;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

/**
 * The Class OpportunityAPI.
 */
@Component
@Path(InOutCPQConstants.API_OPPORTUNITY)
public class OpportunityAPI {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(OpportunityAPI.class);

	/** The Constant getService(). */
	@Autowired
	private OpportunityCRUDService service;

	public OpportunityCRUDService getService() {
		return service;
	}

	public void setService(OpportunityCRUDService service) {
		this.service = service;
	}

	/**
	 * Health check. This API is to perform health check operation To make sure
	 * whether the service is up and running
	 *
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_HEALTH_CHECK)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response healthCheck() {
		InOutCorpResponse response = new InOutCorpResponse();
		response.putMessage(InOutCPQConstants.RESULT, InOutCPQConstants.SUCCESS);
		return Response.ok().entity(response).build();
	}

	/**
	 * Upsert. This API performs both insert & update operation of the
	 * Opportunity. If ID is passed in the request, then it updates the existing
	 * opportunity if ID is not passed in the request, it creates a new
	 * opportunity
	 *
	 * @param opportunityVo
	 *            the opportunity vo
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_UPSERT)
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response upsert(List<OpportunityVo> opportunityVos) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			if (opportunityVos != null && opportunityVos.size() > 0)
				response.putMessage(InOutCPQConstants.RESULT, getService()
						.upsert(opportunityVos));
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Errored Request "
					+ JSONUtils.getJSONString(opportunityVos));
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}
	}

	/**
	 * Delete. Deletes the opportunity using the ID
	 *
	 * @param pkey
	 *            the id
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_DELETE)
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam(InOutCPQConstants.PKEY) Long pkey) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			boolean result = getService().delete(pkey);
			response.putMessage(InOutCPQConstants.RESULT, result);
			return Response.ok().entity(response).build();
		} catch (InOutException e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

	/**
	 * Read. Retrieves the Opportunity using the ID
	 *
	 * @param pkey
	 *            the id
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_READ)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response read(@QueryParam(InOutCPQConstants.PKEY) Long pkey) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			OpportunityVo opportunityVo = getService().read(pkey);
			response.putMessage(InOutCPQConstants.RESULT, opportunityVo);
			return Response.ok().entity(response).build();
		} catch (InOutException e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

	/**
	 * Read all. Retrieves all opportunities
	 *
	 * @param pageNo
	 *            the page no
	 * @param pageSize
	 *            the page size
	 * @param sortBy
	 *            the sort by
	 * @param asc
	 *            the asc
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_READALL)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response readAll(@QueryParam("pageNo") Long pageNo,
			@QueryParam("pageSize") Long pageSize,
			@QueryParam("sortBy") String sortBy, @QueryParam("asc") Boolean asc) {
		InOutCorpResponse response = new InOutCorpResponse();
		try {
			List<OpportunityVo> opportunityVos = getService().readAll(pageNo,
					pageSize, sortBy, asc);
			response.putMessage(InOutCPQConstants.RESULT, opportunityVos);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}
	}

	/**
	 * Test request. This API is to test the request JSON structure. This will
	 * be useful to debug the data type mismatch errors in Rest API Call
	 *
	 * @param stringRequest
	 *            the string request
	 * @return the response
	 */
	@Path(InOutCPQConstants.API_TEST_REQUEST)
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response testRequest(String stringRequest) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			LOGGER.info("stringRequest " + stringRequest);
			response.putMessage(InOutCPQConstants.RESULT, stringRequest);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

	@Path("{opp1}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response defaultGET(@QueryParam("opp") String opp,
			@PathParam("opp1") String opp1) {
		// request example
		// http://localhost:8080/inoutcpqsolutions/api/opportunity/100?opp=101
		InOutCorpResponse response = new InOutCorpResponse();
		try {
			LOGGER.info("opp " + opp);
			LOGGER.info("opp1 " + opp1);
			response.putMessage(InOutCPQConstants.RESULT, "success");
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response defaultPOST(String stringRequest) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			LOGGER.info("stringRequest " + stringRequest);
			response.putMessage(InOutCPQConstants.RESULT, stringRequest);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

}
