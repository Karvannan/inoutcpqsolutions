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

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.service.impl.OpportunityCRUDServiceImpl;
import com.inoutcorp.cpq.opportunity.utils.InOutCPQConstants;
import com.inoutcorp.cpq.opportunity.utils.JSONUtils;
import com.inoutcorp.cpq.opportunity.vo.InOutCorpResponse;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

@Path(InOutCPQConstants.API_OPPORTUNITY)
public class OpportunityAPI {

	private static final Logger LOGGER = Logger.getLogger(OpportunityAPI.class);

	private static final OpportunityCRUDService service = new OpportunityCRUDServiceImpl();

	@Path(InOutCPQConstants.API_HEALTH_CHECK)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response healthCheck() {
		InOutCorpResponse response = new InOutCorpResponse();
		response.putMessage(InOutCPQConstants.RESULT, InOutCPQConstants.SUCCESS);
		return Response.ok().entity(response).build();
	}

	@Path(InOutCPQConstants.API_UPSERT)
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response upsert(OpportunityVo opportunityVo) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			opportunityVo = service.upsert(opportunityVo);
			response.putMessage(InOutCPQConstants.RESULT, opportunityVo);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.debug("Errored Request "
					+ JSONUtils.getJSONStringFromObject(opportunityVo));
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") String id) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			boolean result = service.delete(id);
			response.putMessage(InOutCPQConstants.RESULT, result);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

	@Path(InOutCPQConstants.API_READ)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response read(@QueryParam(InOutCPQConstants.ID) String id) {
		InOutCorpResponse response = new InOutCorpResponse();

		try {
			OpportunityVo opportunityVo = service.read(id);
			response.putMessage(InOutCPQConstants.RESULT, opportunityVo);
			return Response.ok().entity(response).build();
		} catch (Exception e) {
			LOGGER.error("Error ", e);
			response.setErrors(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(response).build();
		}

	}

	@Path(InOutCPQConstants.API_READALL)
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response readAll(@QueryParam("pageNo") Long pageNo,
			@QueryParam("pageSize") Long pageSize,
			@QueryParam("sortBy") String sortBy, @QueryParam("asc") Boolean asc) {
		InOutCorpResponse response = new InOutCorpResponse();
		try {
			List<OpportunityVo> opportunityVos = service.readAll(pageNo,
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

}
