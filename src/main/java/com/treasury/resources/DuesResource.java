package com.treasury.resources;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.dtos.DashboardDto;
import com.treasury.services.DashboardService;

@Path("dues")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DuesResource {

	@Autowired
	private DashboardService dashboardService;

	@GET
	public Response getAll() {
		Response response = null;
		try {
			DashboardDto dashboardDto = dashboardService.getDashboardDetails();
			response = Response.ok(dashboardDto).build();
		} catch (ParseException e) {
			e.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}

}
