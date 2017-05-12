package api.service;

import java.sql.Date;
import java.util.List;

import api.model.DataMin;
import api.model.DataMinPk;

public interface DataMinService {
	
	public DataMin save(DataMin d);
	public void saveAll(List<DataMin> d);
	public void delete(DataMin d);
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs);
	public List<DataMin> findDataByDateInterval(Date dIni, Date dFinal, String obs );
	public Object findByID(DataMinPk id);
	
}
