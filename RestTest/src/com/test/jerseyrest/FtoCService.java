package com.test.jerseyrest;
  
/**
 * This is code change in TestBranch
 */

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {
	List list;
	@Context UriInfo uriinfo;
	@Context HttpHeaders headers;
	  @GET
	  @RolesAllowed("ADMIN")
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
     
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32)*5/9; 
		jsonObject.put("F Value", fahrenheit); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("F Value", f); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(jsonObject.toString()).build();
	  }
	  @Path("/hell/{f}/{k}")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response convertFtoCfromInput(@PathParam("f") String f, @PathParam("k") String k) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		
		jsonObject.put("F Value d", f); 
		jsonObject.put("C Value d", k);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		//return Response.status(200).entity(jsonObject.toString()).build();
		return Response.noContent().build();
	  }

}
