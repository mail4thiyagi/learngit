package com.test.jerseyrest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/smooth")
public class QueryParamTest {
	@RolesAllowed("ADMIN")
	@POST
	@Produces("application/json")
	
	public Response smooth(
			@DefaultValue("2") @QueryParam("step") int step,
			@DefaultValue("true") @QueryParam("min-m") boolean hasMin,
			@DefaultValue("true") @QueryParam("max-m") boolean hasMax,
			@DefaultValue("true") @QueryParam("last-m") boolean hasLast,
			@DefaultValue("blue") @QueryParam("min-color") ColorParam minColor,
			@DefaultValue("green") @QueryParam("max-color") ColorParam maxColor,
			@DefaultValue("red") @QueryParam("last-color") ColorParam lastColor) {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("min-m", hasMin);
		jsonObject.put("step", step);
		jsonObject.put("max-m", hasMax);
		jsonObject.put("last-m", hasLast);
		jsonObject.put("min-color", minColor);
		jsonObject.put("max-color", maxColor);
		jsonObject.put("last-color", lastColor);

		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();

	}

}
