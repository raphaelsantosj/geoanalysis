/**p
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/


package core.applications.hdz;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


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


@Path("/hdz")
public class HdzDataPrepare {
	
	
	private static ComponentProcessing chP = new ComponentProcessing();
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@GET
	@Path("/hdztoday")
	@Produces(MediaType.APPLICATION_JSON)
	public Response hdzRESTService() throws JSONException {
		List<List> data;
		try{
			return Response.status(201).entity(CacheService.getInstance().getHdzCache().get("today").toString()).build();
		}
		catch(NullPointerException npe){
			data = chP.CompApproxHDZ(new java.sql.Date(114, 9,16), new java.sql.Date(114, 9, 31), "kak");
		}
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		for (int k = 0 ; k < data.get(0).size() ;k++){
			//String sendTimeInUTC = (formatter.format(((java.sql.Date) data.get(0).get(k)).getTime() + ((Time)data.get(1).get(k)).getTime()));
			Double time = (double) (((Date) data.get(0).get(k)).getTime() + ((Time) data.get(1).get(k)).getTime());
			jo = new JSONObject();
			jo.put("dateHour", time);
			jo.put("h", data.get(2).get(k));
			jo.put("d", data.get(3).get(k));
			jo.put("z", data.get(4).get(k));
			ja.put(jo);
		}
		CacheService.getInstance().getHdzCache().put("today", ja);
			
		return Response.status(201).entity(ja.toString()).build();
	}

}
