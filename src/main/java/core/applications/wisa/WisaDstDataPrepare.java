/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.applications.wisa;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import core.services.CacheService;
import core.services.dataOutProcessing.ComponentProcessing;

@Path("/wisadata")
public class WisaDstDataPrepare {
	
	ComponentProcessing chP = new ComponentProcessing();
	
	@SuppressWarnings("deprecation")
	@GET
	@Path("/wisatodaydata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response wisaTodayRESTService() throws JSONException {		
		
		List<Double> hHer = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "her");
		List<Double> hHon = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "hon");
		List<Double> hKak = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "kak");
		List<Double> hSjg = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "sjg");
		
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		for (int k = 0 ; k < hHer.size() ; k++){
			jo = new JSONObject();
			jo.put("hHer", hHer.get(k));
			jo.put("hHon", hHon.get(k));
			jo.put("hKak", hKak.get(k));
			jo.put("hSjg", hSjg.get(k));
			ja.put(jo);
		}
		
		CacheService.getInstance().getWisaCache().put("today", ja);
		
		return Response.status(201).entity(ja.toString()).build();		
	}
	
	@SuppressWarnings("deprecation")
	@GET
	@Path("/wisainterval")
	@Produces(MediaType.APPLICATION_JSON)
	public Response wisaIntervalRESTService(String dates) throws JSONException {
		try{
			return Response.status(201).entity(CacheService.getInstance().getWisaCache().get(dates).toString()).build();
		}
		catch(Exception npe){
			
		}
		
	
		List<Double> hHer = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "her");
		List<Double> hHon = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "hon");
		List<Double> hKak = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "kak");
		List<Double> hSjg = chP.CompApproxWisa(new java.sql.Date(114, 8,1), new java.sql.Date(114, 9, 31), "sjg");
		
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		for (int k = 0 ; k < hHer.size() ; k++){
			jo = new JSONObject();
			jo.put("hHer", hHer.get(k));
			jo.put("hHon", hHon.get(k));
			jo.put("hKak", hKak.get(k));
			jo.put("hSjg", hSjg.get(k));
			ja.put(jo);
		}
		
		CacheService.getInstance().getWisaCache().put(dates, ja);
		
		return Response.status(201).entity(ja.toString()).build();		
	
	}



}
