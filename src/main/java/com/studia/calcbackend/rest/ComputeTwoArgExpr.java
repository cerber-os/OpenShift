package com.studia.calcbackend.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.studia.calcbackend.model.InputModel;
import com.studia.calcbackend.model.ResponseModel;
import com.studia.calcbackend.service.CalcApi;
import com.studia.calcbackend.util.IncorrectExpressionException;

@Path("/computeTwoArgExpr")
public class ComputeTwoArgExpr {

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
    	
    	if(data == null || data.first == null || data.operator == null || data.second == null) {
    		response.errorMsg = "Invalid input data";
    		response.success = false;
    	} else {
	    	
	        try {
	            response.result = CalcApi.executeTwoArgsExpr(data.first, data.operator, data.second);
	            response.success = true;
	        } catch(IncorrectExpressionException e) {
	            response.errorMsg = e.getMessage();
	            response.success = false;
	        }
	        
    	}
        return Response.status(response.success ? 200: 400).entity(response).build();
    }
}
