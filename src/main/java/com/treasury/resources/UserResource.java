package com.treasury.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;
import com.treasury.services.UserService;

@Component
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Autowired
	private UserService userService;

	@Context
	UriInfo uriInfo;

	@GET
	@Path("find")
	public Response findUser(@QueryParam("username") String username,
			@QueryParam("password") String password) {
		UserBean userBean = userService.find(username, password);
		if (userBean == null) {
			userBean = new UserBean();
		} else {
			userBean.setUsername(null);
			userBean.setPassword(null);
		}
		return Response.ok(userBean).build();
	}

	@POST
	public Response createUser(UserDto userDto) {
		userService.create(userDto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		URI userUri = builder.path(userDto.getId()).build();
		return Response.created(userUri).entity(userDto).build();
	}

}
