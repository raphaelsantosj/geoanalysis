/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.services;

import org.rosuda.REngine.REXPMismatchException;

//This class will integrate R with Java

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RIntegration {

	private static RIntegration rIntegration;
	private RConnection connection;
	
	private RIntegration(){
		try {
			connection = new RConnection();
			connection.eval("rm(list=ls())");
			
		} catch (RserveException e) {
			e.printStackTrace();
		}		
	}
	
	public static RIntegration getInstance(){
		if(rIntegration == null) rIntegration = new RIntegration();
		return rIntegration;
	}
	

	
	public void closeConnection(){
		this.connection.close();
	}
	
	public void startWisa() throws RserveException{
		connection.eval("source('/home/raphael/git/geoanalysis/src/main/java/core/applications/wisa/Rfiles/entradawisa.R')"); //LOAD R Function for WISA
		
	}
	
	public String plotWisa(String dIni, String dFinal, Integer isDaily) throws RserveException, REXPMismatchException{
		 //String[] dMY = dIni.split("-"); 
		 //connection.eval("year <- " + dMY[0].toString());
		 //connection.eval("isDaily <- " + isDaily.toString());
		 String wisa = connection.eval("start('"+dIni+"', '"+dFinal+"', "+isDaily+")").asString();
		 
		 return wisa;
	}
	
	public RConnection getRConnection(){
		return this.connection;
	}
	
}
