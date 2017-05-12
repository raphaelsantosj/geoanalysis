package web.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.services.CacheService;

public class WisaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		//old
		/*try{
			//WisaDstPlot wdp = new WisaDstPlot();
			String[] ini = request.getParameter("dini").split("/");
			String[] fin = request.getParameter("dfinal").split("/");
			
			Date dIni = new Date((Integer.parseInt(ini[2])-1900), (Integer.parseInt(ini[1])-1), (Integer.parseInt(ini[0])));
			Date dFinal = new Date((Integer.parseInt(fin[2])-1900), (Integer.parseInt(fin[1])-1), (Integer.parseInt(fin[0])));
			
			
			if ((dIni.getTime()<dFinal.getTime())){
				CacheService.getInstance().setWisadIniNow(dIni);
				CacheService.getInstance().setWisadFinalNow(dFinal);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/geoindex/wisaplot.jsp");
				rd.forward(request, response);
			}
			else{
				response.sendRedirect("/geoanalysis/geoindex/invalid.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("/geoanalysis/geoindex/invalid.jsp");
		}*/
		
		/*==========================================================================================================================*/
		
		//neo
		try{
			//WisaDstPlot wdp = new WisaDstPlot();
			String[] ini = request.getParameter("datai").split("/");
			String[] fin = request.getParameter("dataf").split("/");
			
			Date dIni = new Date((Integer.parseInt(ini[2])-1900), (Integer.parseInt(ini[1])-1), (Integer.parseInt(ini[0])));
			Date dFinal = new Date((Integer.parseInt(fin[2])-1900), (Integer.parseInt(fin[1])-1), (Integer.parseInt(fin[0])));
			
			
			if ((dIni.getTime()<dFinal.getTime())){
				CacheService.getInstance().setWisadIniNow(dIni);
				CacheService.getInstance().setWisadFinalNow(dFinal);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/neo/geoindex/wisaplot.jsp");
				rd.forward(request, response);
			}
			else{
				response.sendRedirect("/geoanalysis/neo/geoindex/invalid.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("/geoanalysis/neo/geoindex/invalid.jsp");
		}
		
		
	
	}
		
}
