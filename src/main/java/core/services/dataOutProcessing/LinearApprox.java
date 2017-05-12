/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package core.services.dataOutProcessing;

import java.util.List;

public class LinearApprox {
	
	private static Double[] interpolate(double start, double end, int count) {
	    if (count < 2) {
	        throw new IllegalArgumentException("interpolate: illegal count!");
	    }
	    Double[] array = new Double[count + 1];
	    for (int i = 0; i <= count; ++ i) {
	        array[i] = start + i * (end - start) / count;
	    }
	    return array;
	}
	
	public static List<Double> linearApprox(List<Double> data){

		for (int k = 0; k<data.size(); k++){
			if (data.get(k)>99998){
				Double iniPoint = data.get(k-1);
				for (int j = k; j<data.size(); j++){
					if(data.get(j)<99999){
						Double endPoint = data.get(j);
						int count = j-k+1;					
						Double[] inter = interpolate(iniPoint, endPoint, count);
						for (int i = 0; i<count; i++){
							data.set(i+k, inter[i+1]) ;
						}
						k = j;
						break;
					}
				}
			}
		}
		return data;
	}
	

}
