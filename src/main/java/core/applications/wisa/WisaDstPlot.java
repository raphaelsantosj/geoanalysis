/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.applications.wisa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import core.services.CacheService;
import core.services.RIntegration;
@Path("/wisaplot")
public class WisaDstPlot {
	
	@GET
	@Path("/wisaintervalplot")
	@Produces(MediaType.APPLICATION_JSON)
	public Response plotWisa(){
		try {
			
			if(!CacheService.getInstance().getWisaToday().equals("")){
				RIntegration.getInstance().startWisa();
				CacheService.getInstance().setWisaToday(RIntegration.getInstance().plotWisa(CacheService.getInstance().getWisadIniNow().toString(), CacheService.getInstance().getWisadFinalNow().toString(), 0));
			}
		
			return Response.status(201).entity(CacheService.getInstance().getWisaToday()).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	
	
	@GET
	@Path("/wisatodayplot")
	@Produces(MediaType.APPLICATION_JSON)
	public static Response todayWisa()  {
		String wisa = CacheService.getInstance().getWisaToday();
		
		if (!wisa.equals("")) return Response.status(201).entity(wisa).build();
		
		
		
		try {
			RIntegration.getInstance().startWisa();
			CacheService.getInstance().setWisaToday(RIntegration.getInstance().plotWisa("2014-09-01", "2014-10-31", 1));
			System.out.println(CacheService.getInstance().getWisaToday());
			return Response.status(201).entity(CacheService.getInstance().getWisaToday()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
	 
   
	
	
