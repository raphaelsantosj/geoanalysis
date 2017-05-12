package api.service;

import java.sql.Date;
import java.util.List;

import api.model.DataSecPk;
import api.model.DataSec;

public interface DataSecService {
	public DataSec save(DataSec d);
	public void saveAll(List<DataSec> d);
	public void delete(DataSec d);
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs );
	public List<DataSec> findDataByDateInterval(Date dIni, Date dFinal, String obs );
	public Object findByID(DataSecPk id);
}
