package api.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.DataMin;
import api.model.DataMinPk;
import api.repository.DataMinRepository;

@Service("dataMinService")
@Transactional
public class DataMinServiceImpl implements DataMinService{

	
	@Autowired
	private DataMinRepository dataMinRepo;
	
	@Autowired
	public void setDataMinRepo(DataMinRepository dataMinRepo) {
		this.dataMinRepo = dataMinRepo;
	}

	@Override
	public DataMin save(DataMin d) {
		dataMinRepo.save(d);
		return d;
	}

	@Override
	@Transactional
	public void saveAll(List<DataMin> ld) {
		for (DataMin d: ld) dataMinRepo.save(d);
	}

	@Override
	public void delete(DataMin d) {
		dataMinRepo.delete(d);		
	}
	@Override
	public List<Double> findComponentH(Date dIni, Date dFinal, String obs){
		return dataMinRepo.findComponentH(dIni, dFinal, obs);
	}
	@Override
	public List<DataMin> findDataByDateInterval(Date dIni, Date dFinal, String obs ){
		return dataMinRepo.findDataByDateInterval(dIni, dFinal, obs);
	}

	@Override
	public Object findByID(DataMinPk id) {
		return dataMinRepo.findOne(id);
	}

}
