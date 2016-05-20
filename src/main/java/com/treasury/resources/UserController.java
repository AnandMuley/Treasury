package com.treasury.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.treasury.dtos.UserDto;
import com.treasury.services.UserService;
import com.treasury.services.ValidationService;

@Component
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationService validationService;

	@POST
	public Response createUser(UserDto userDto) {
		Response response = Response.status(
				Response.Status.INTERNAL_SERVER_ERROR).build();
		validationService.validate(userDto);
		if (CollectionUtils.isEmpty(userDto.getValidationErrors())) {
			userService.create(userDto);
			response = Response.ok(userDto).build();
		}
		return response;
	}

	@PUT
	public Response update(UserDto userDto) {
		userService.save(userDto);
		return Response.ok().build();
	}

	@DELETE
	public Response deleteUser(UserDto userDto) {
		userService.delete(userDto.getId());
		return Response.ok().build();
	}

}
