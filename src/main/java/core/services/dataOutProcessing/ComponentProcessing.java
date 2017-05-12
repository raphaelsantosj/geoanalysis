/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataOutProcessing;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import api.model.DataMin;
import core.services.DataBaseService;

public class ComponentProcessing {
	
	@SuppressWarnings("rawtypes")
	public List<List> CompApproxHDZ(Date dIni, Date dFinal, String obs){
		List<DataMin> data = DataBaseService.getInstance().getDataMinService().findDataByDateInterval(dIni, dFinal, obs);
		List<Date> date = new LinkedList<Date>();
		List<Time> time = new LinkedList<Time>();
		List<Double> compH = new LinkedList<Double>();
		List<Double> compD = new LinkedList<Double>();
		List<Double> compZ = new LinkedList<Double>();
		for(DataMin dmin: data){
			date.add(dmin.getId().getDate());
			time.add(dmin.getId().getHour());
			compH.add(dmin.getH());
			compD.add(dmin.getY());
			compZ.add(dmin.getZ());
			
		}
		compH = LinearApprox.linearApprox(compH);
		compD = LinearApprox.linearApprox(compD);
		compZ = LinearApprox.linearApprox(compZ);
		List<List> dthdz = new LinkedList<List>();
		dthdz.add(date);
		dthdz.add(time);
		dthdz.add(compH);
		dthdz.add(compD);
		dthdz.add(compZ);
		return dthdz;
	}
	
	public List<Double> CompApproxWisa(Date dIni, Date dFinal, String obs){
		List<Double> compH = DataBaseService.getInstance().getDataMinService().findComponentH(dIni, dFinal, obs);
		compH = LinearApprox.linearApprox(compH);

		return compH;
	}
	

}
