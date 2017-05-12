/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

/*This interface defines how a Data Access should be to a DataSec Entity */


package api.repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.model.DataSec;
import api.model.DataSecPk;
@Repository
public interface DataSecRepository  extends CrudRepository<DataSec, DataSecPk>{
	
	@Query("select ds.h from DataSec ds where ds.id.date >= ?1 and ds.id.date <= ?2 and ds.id.observatory.IAGA = ?3 order by ds.id.date, ds.id.hour")
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs );

	@Query("select ds from DataSec ds where ds.id.date >= ?1 and ds.id.date <= ?2 and ds.id.observatory.IAGA = ?3 order by ds.id.date, ds.id.hour")
	public List<DataSec> findDataByDateInterval(Date dIni, Date dFinal, String obs );
	
}
