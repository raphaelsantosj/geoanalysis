/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This interface defines how a Data Access should be to a Observatory Entity */

package api.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.model.Observatory;
@Repository
public interface ObservatoryRepository extends CrudRepository<Observatory, String>{
	
	

}
