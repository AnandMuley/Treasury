package com.treasury.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.dtos.ReportDto;
import com.treasury.services.ReportingService;

@Component
@Path("reports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReportingResource {

	@Autowired
	private ReportingService reportingService;

	@GET
	@Path("payments")
	public Response getPaymentReports() {
		ReportDto reportDto = reportingService.getReport();
		return Response.ok(reportDto).build();
	}

}
