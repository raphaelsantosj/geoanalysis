package api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.DataSecPk;
import api.model.DataSec;
import api.repository.DataSecRepository;

@Service("dataSecService")
@Transactional
public class DataSecServiceImpl implements DataSecService {
	
	@Autowired
	private DataSecRepository dataSecRepo;
	

	public void setDataSecRepo(DataSecRepository dataSecRepo) {
		this.dataSecRepo = dataSecRepo;
	}

	@Override
	public DataSec save(DataSec d) {
		return dataSecRepo.save(d);
	}

	@Override
	@Transactional
	public void saveAll(List<DataSec> ld) {
		for(DataSec d: ld) dataSecRepo.save(d);
	}

	@Override
	public void delete(DataSec d) {
		dataSecRepo.delete(d);
	}

	@Override
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs) {
		return dataSecRepo.findComponentH(dIni, dFinal, obs);
	}

	@Override
	public List<DataSec> findDataByDateInterval(Date dIni, Date dFinal, String obs) {
		return dataSecRepo.findDataByDateInterval(dIni, dFinal, obs);
	}
	
	@Override
	public Object findByID(DataSecPk id) {
		return dataSecRepo.findOne(id);
	}

}
