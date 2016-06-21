package com.treasury.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.dtos.SettingsDto;
import com.treasury.services.SettingsService;

@Component
@Path("settings/{createdBy}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SettingsResource {

	@Autowired
	private SettingsService settingsService;

	@GET
	public Response findBy(@PathParam("createdBy") String createdBy) {
		SettingsDto settingsDto = settingsService.findBy(createdBy);
		return Response.ok(settingsDto).build();
	}

	@POST
	public Response createNew(SettingsDto settingsDto) {
		settingsService.createNew(settingsDto);
		return Response.ok().build();
	}

	@PUT
	public Response update(SettingsDto settingsDto) {
		settingsService.update(settingsDto);
		return Response.ok().build();
	}

}