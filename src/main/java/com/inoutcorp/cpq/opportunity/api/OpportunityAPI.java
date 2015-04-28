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

import org.apache.log4j.Logger;

import com.inoutcorp.cpq.opportunity.service.OpportunityCRUDService;
import com.inoutcorp.cpq.opportunity.service.impl.OpportunityCRUDServiceImpl;
import com.inoutcorp.cpq.opportunity.vo.InOutCorpResponse;
import com.inoutcorp.cpq.opportunity.vo.OpportunityVo;

@Path("/opportunity")
public class OpportunityAPI {

	private static final Logger LOGGER = Logger.getLogger(OpportunityAPI.class);

	private static final OpportunityCRUDService service = new OpportunityCRUDServiceImpl();

	@Path("/healthCheck")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response healthCheck() {
		InOutCorpResponse response = new InOutCorpResponse();

		response.putMessage("result", "success");

		return Response.ok().entity(response).build();
	}

	@Path("/create")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(OpportunityVo opportunityVo) {
		InOutCorpResponse response = new InOutCorpResponse();

		opportunityVo = service.create(opportunityVo);

		response.putMessage("result", opportunityVo);

		return Response.ok().entity(response).build();
	}

	@Path("/update")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(OpportunityVo opportunityVo) {
		InOutCorpResponse response = new InOutCorpResponse();

		opportunityVo = service.update(opportunityVo);

		response.putMessage("result", opportunityVo);

		return Response.ok().entity(response).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") String id) {
		InOutCorpResponse response = new InOutCorpResponse();

		boolean result = service.delete(id);

		response.putMessage("result", result);

		return Response.ok().entity(response).build();

	}

	@Path("/read")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response read(@QueryParam("id") String id) {
		InOutCorpResponse response = new InOutCorpResponse();

		OpportunityVo opportunityVo = service.read(id);

		response.putMessage("result", opportunityVo);

		return Response.ok().entity(response).build();
	}

	@Path("/readAll")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response readAll(@QueryParam("pageNo") Long pageNo,
			@QueryParam("pageSize") Long pageSize,
			@QueryParam("sortBy") String sortBy, @QueryParam("asc") Boolean asc) {
		InOutCorpResponse response = new InOutCorpResponse();
		try {
			List<OpportunityVo> opportunityVos = service.readAll(pageNo,
					pageSize, sortBy, asc);
			response.putMessage("result", opportunityVos);

		} catch (Exception e) {
			LOGGER.error("Error ", e);
		}

		return Response.ok().entity(response).build();
	}

}
