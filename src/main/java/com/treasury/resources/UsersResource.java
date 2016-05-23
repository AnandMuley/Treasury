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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.dtos.UserDto;
import com.treasury.services.UserService;
import com.treasury.services.ValidationService;

@Component
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationService validationService;

	@Context
	UriInfo uriInfo;

	@GET
	public Response getAll() {
		List<UserDto> userDtos = userService.getAll();
		return Response.ok(userDtos).build();
	}

	@GET
	@Path("{userId}")
	public Response getUser(@PathParam("userId") String userId) {
		UserDto userDto = userService.findById(userId);
		return Response.ok(userDto).build();
	}

	@POST
	public Response createUser(UserDto userDto) {
		userService.create(userDto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		URI userUri = builder.path(userDto.getId()).build();
		return Response.created(userUri).entity(userDto).build();
	}

	@PUT
	@Path("{userId}")
	public Response update(@PathParam("userId") String userId, UserDto userDto) {
		userDto.setId(userId);
		userService.save(userDto);
		return Response.ok().build();
	}

	@DELETE
	@Path("{userId}")
	public Response deleteUser(@PathParam("userId") String userId) {
		userService.delete(userId);
		return Response.ok().build();
	}

}
