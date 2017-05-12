/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataInProcessing.objectsFac;

import api.model.Observatory;
import api.model.Data;


public interface ObjectsMaker {
	public Data makeObject(String s, Observatory obs);

}
