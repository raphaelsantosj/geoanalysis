/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.services.dataInProcessing.objectsFac.types;

import java.util.LinkedList;
import java.util.List;

import api.model.DataSecPk;
import api.model.Observatory;
import api.model.DataSec;
import core.services.dataInProcessing.objectsFac.ComponentCalc;
import core.services.dataInProcessing.objectsFac.ObjectsMaker;
import core.services.dataInProcessing.objectsFac.DateCalc;

public class XYZFSec implements ObjectsMaker {
	
	public DataSec makeObject(String s, Observatory obs){
		DataSec d = new DataSec();
		DataSecPk dPK = new DataSecPk();
		d.setId(dPK);
		String[] vString = s.split(" ");
		List<String> aux = new LinkedList<String>();
		for (String s2: vString){
			if (s2.equals("NaN") || s2.equals("0.00") ) s2 = "99999";
			if (!s2.equals("")) aux.add(s2);
		}
			d.getId().setObservatory(obs);			
			d.getId().setDate(DateCalc.dateConverter(aux.get(0)));
			d.getId().setHour(DateCalc.timeConverter(aux.get(1)));
			d.setDOY(Integer.valueOf(aux.get(2)));
			d.setX(Double.parseDouble(aux.get(3)));
			d.setY(Double.parseDouble(aux.get(4)));
			d.setZ(Double.parseDouble(aux.get(5)));
			d.setF(Double.parseDouble(aux.get(6)));
			d.setH(ComponentCalc.calcH(d));
			d.setD(ComponentCalc.calcD(d));
			d.setI(ComponentCalc.calcI(d));
			return d;

	}



}
