package com.studia.calcbackend.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class CalcRESTService {
	private static final String API_VERSION = "1.0.0";
	
	/**
     * Return current API version
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAPIVersion() {
        return Response.ok("[PROZ] Calculator backend v." + API_VERSION).build();
    }
}
