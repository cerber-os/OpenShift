package com.studia.calcbackend.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.studia.calcbackend.model.InputModel;
import com.studia.calcbackend.model.ResponseModel;
import com.studia.calcbackend.service.CalcApi;
import com.studia.calcbackend.util.IncorrectExpressionException;

@Path("/computeOneArgExpr")
public class ComputeOneArgExpr {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        return "Send POST request to compute";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(InputModel data) {
    	ResponseModel response = new ResponseModel();
    	
    	if(data == null || data.first == null || data.func == null) {
    		response.errorMsg = "Invalid input data";
    		response.success = false;
    	} else {
	    	
	        try {
	            response.result = CalcApi.executeOneArgExpr(data.first, data.func);
	            response.success = true;
	        } catch(IncorrectExpressionException e) {
	            response.errorMsg = e.getMessage();
	            response.success = false;
	        }
	        
    	}
        return Response.status(response.success ? 200: 400).entity(response).build();
    }
}
