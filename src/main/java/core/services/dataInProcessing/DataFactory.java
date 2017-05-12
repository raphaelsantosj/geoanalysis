/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataInProcessing;


import java.util.LinkedList;
import java.util.List;

import api.model.Observatory;
import api.model.DataMin;
import api.model.DataSec;
import core.services.DataBaseService;
import core.services.dataInProcessing.objectsFac.ObjectsMaker;
import core.services.dataInProcessing.objectsFac.types.HDZFMin;
import core.services.dataInProcessing.objectsFac.types.HDZFSec;
import core.services.dataInProcessing.objectsFac.types.XYZFMin;
import core.services.dataInProcessing.objectsFac.types.XYZFSec;

public class DataFactory {
	
	//VERIFY IF DATA TYPE IS HDZF OR XYZF 
	public Boolean dataTypeVerify(List<String> ls) throws Exception{
		String dType = new String("");
		for (String hd: ls){
			if (hd.substring(0, 3).equals("DAT")){
				dType = hd;
				break;
			}
		}
		List<String> cab = new LinkedList<String>();
		String[] vString = dType.split(" ");
		for (String hd: vString){
			if(!hd.equals("")) cab.add(hd);
		}
		//GET HEADLINE SUBSTRING
		String dFinal = cab.get(3).substring(3) + cab.get(4).substring(3) + cab.get(5).substring(3) + cab.get(6).substring(3);

		if (dFinal.equals("HDZF")) return true;
		else return false;
		
	}
		
	public List<DataMin> makeDataObjectListMin(List<String> ls) throws Exception{
		ObjectsMaker mo;
		List<DataMin> ld = new LinkedList<DataMin>();
		System.out.println("MakeDataObjectList");
		Observatory obs = DataBaseService.getInstance().getObservatoryService().findByID(ls.get(1));
		if (dataTypeVerify(ls)){
			mo = new HDZFMin();
		}
		else{
			mo = new XYZFMin();
		}
		for (String s: ls){
			if(s.substring(0, 2).equals("20")){
				ld.add((DataMin) mo.makeObject(s, obs));
			}
		}
		return ld;
	}
	
	
	public List<DataSec> makeDataObjectListSec(List<String> ls) throws Exception{
		ObjectsMaker mo;
		List<DataSec> ld = new LinkedList<DataSec>();
		System.out.println("MakeDataObjectList");
		Observatory obs = DataBaseService.getInstance().getObservatoryService().findByID(ls.get(1));

			if (dataTypeVerify(ls)){
				mo = new HDZFSec();
			}
			else{
				mo = new XYZFSec();
			}
			
			for (String s: ls){
				if(s.substring(0, 2).equals("20")){
					ld.add((DataSec) mo.makeObject(s, obs));
				}
			}
			
			return ld;
		
		
	}
		
			

}