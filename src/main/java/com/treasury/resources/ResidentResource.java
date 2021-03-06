package com.treasury.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.treasury.dtos.ResidentDto;
import com.treasury.services.ResidentService;
import com.treasury.services.ValidationService;

@Component
@Path("residents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResidentResource {

	@Autowired
	private ResidentService residentService;

	@Autowired
	private ValidationService validationService;

	@Context
	UriInfo uriInfo;

	@GET
	@Path("all")
	public Response getAll(@QueryParam("createdBy") String createdBy) {
		if (StringUtils.isEmpty(createdBy)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		List<ResidentDto> residentDtos = residentService.getAll(createdBy);
		return Response.ok(residentDtos).build();
	}

	@POST
	public Response createResident(ResidentDto residentDto) {
		residentService.create(residentDto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		URI residentUri = builder.path(residentDto.getId()).build();
		return Response.created(residentUri).entity(residentDto).build();
	}

	@PUT
	@Path("{residentId}")
	public Response update(@PathParam("residentId") String residentId,
			ResidentDto residentDto) {
		residentDto.setId(residentId);
		residentService.save(residentDto);
		return Response.ok().build();
	}

	@DELETE
	@Path("{residentId}")
	public Response deleteResident(@PathParam("residentId") String residentId) {
		residentService.delete(residentId);
		return Response.ok().build();
	}

}
