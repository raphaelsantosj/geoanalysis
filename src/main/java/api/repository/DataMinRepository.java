/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package api.repository;

/*This interface defines how a Data Access to the DataBase should be to a DataMin Entity */

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.model.DataMin;
import api.model.DataMinPk;

@Repository
public interface DataMinRepository  extends JpaRepository<DataMin, DataMinPk>{
	
	@Query("select" + " dm.h " + "from DataMin dm "
			+ "where dm.id.date >= ?1 and dm.id.date <= ?2 and dm.id.observatory.IAGA = ?3 "
			+ "order by dm.id.date, dm.id.hour")
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs);
	
	@Query("select dm from DataMin dm "
			+ "where dm.id.date >= ?1 and dm.id.date <= ?2 and dm.id.observatory.IAGA = ?3 "
			+ "order by dm.id.date, dm.id.hour")
	public List<DataMin> findDataByDateInterval(Date dIni, Date dFinal, String obs );

	
}

