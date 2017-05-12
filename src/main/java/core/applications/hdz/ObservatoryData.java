package core.applications.hdz;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.model.Observatory;
import core.services.DataBaseService;

@Path("/test")
public class ObservatoryData {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testRESTService() throws JSONException {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		JSONObject coord;
		List<Observatory> lo = new LinkedList<Observatory>();
		
		lo.add(DataBaseService.getInstance().getObservatoryService().findByID("kak"));
		lo.add(DataBaseService.getInstance().getObservatoryService().findByID("hon"));
		lo.add(DataBaseService.getInstance().getObservatoryService().findByID("her"));
		
		for (Observatory o: lo){
			 jo = new JSONObject();
			 coord = new JSONObject();
			 jo.put("IAGA", o.getIAGA());
			 jo.put("name", o.getName());
			 jo.put("country", o.getCountry());
			 jo.put("institute", o.getInstitute());
			 
			 coord.put("colatitute", o.getColatitute());
			 coord.put("eastLong", o.getEastLong());
			 
			 jo.put("coord", coord);
			 
			 
			 ja.put(jo);	
		}
		
		
		
		return Response.status(201).entity(ja.toString()).build();
	
	}
	
}
