/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.services.dataInProcessing.objectsFac.types;

import java.util.LinkedList;
import java.util.List;

import api.model.Observatory;
import api.model.DataMin;
import api.model.DataMinPk;
import core.services.dataInProcessing.objectsFac.ComponentCalc;
import core.services.dataInProcessing.objectsFac.ObjectsMaker;
import core.services.dataInProcessing.objectsFac.DateCalc;

public class XYZFMin implements ObjectsMaker {
	
	public DataMin makeObject(String s, Observatory obs){
		DataMin d = new DataMin();
		DataMinPk dPK = new DataMinPk();
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
