package com.classroom.app.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.classroom.app.services.SigInInterface;
import com.classroom.app.services.SigInService;

@Path("/SignIn")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class SignInResource {

	SigInInterface signIn = new SigInService();
	// private String Message;

	@GET
	@Path("/{userName}/{password}")
	public Response authenticate(@PathParam("userName") String userName, @PathParam("password") String password) {
		return Response.status(200).entity("Message: " + signIn.authenticateUser(userName, password)).build();
	}

}
