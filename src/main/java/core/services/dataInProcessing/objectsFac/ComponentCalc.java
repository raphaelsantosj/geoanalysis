/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataInProcessing.objectsFac;



import java.text.DecimalFormat;

import api.model.Data;

public class ComponentCalc {
	
	private static DecimalFormat df = new DecimalFormat("#.00");
	
			//X COMPONENT CALC
			//h*Cos(D)
			public static Double calcX(Data d){
				if (d.getH() >= 99999 || d.getD() >= 99999 ) return 99999.00;
				Double angD = Math.asin(d.getY()/d.getH());
				Double result = d.getH()*Math.cos(angD);
				return Double.parseDouble(df.format(result).replace(",", "."));
				
			}
			
			//H COMPONENT CALC
			//x^2 + Y^2
			public static Double calcH(Data d){
				if (d.getX() >= 99999 || d.getY() >= 99999 ) return 99999.00;	
				Double result = Math.sqrt((Math.pow(d.getX(), 2)+ Math.pow(d.getY(), 2)));
				return Double.parseDouble(df.format(result).replace(",", "."));
	
			}
			
			//D COMPONENT CALC (Not in nT)
			public static Double calcD(Data d){
				if (d.getH() >= 99999 || d.getY() >= 99999 ) return 99999.00;
				Double angD = Math.asin(d.getY()/d.getH());
				return angD;				
			}
			
			//I COMPONENT CALC
			public static Double calcI(Data d){
				if (d.getZ() >= 99999 || d.getH() >= 99999 ) return 99999.00;
				Double result = Math.atan(d.getZ()/d.getH());
				return Double.parseDouble(df.format(result).replace(",", "."));
			}
			

			
		
}
