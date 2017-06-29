/**
  author: Raphael dos Santos Jesus
  raphaelsantos.j@gmail.com
  National Institute For Space Research
  Version 1.0
 **/
package api.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.model.Wisa;
import api.model.WisaPk;


@Repository
public interface WisaRepository extends JpaRepository<Wisa, WisaPk>{

	@Query("select ws from Wisa ws "
			+ "where ws.id.date >= ?1 and ws.id.date <= ?2 "
			+ "order by ws.id.date, ws.id.hour")
	public List<Wisa> findDataByDateInterval(Date dIni, Date dFinal);
	
}
