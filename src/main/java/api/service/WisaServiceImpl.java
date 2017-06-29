package api.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.Wisa;
import api.model.WisaPk;
import api.repository.WisaRepository;

@Service("wisaService")
@Transactional
public class WisaServiceImpl implements WisaService{
	
	@Autowired
	private WisaRepository wisaRepo;
	
	@Autowired
	public void setWisaRepo(WisaRepository wisaRepo){
		this.wisaRepo = wisaRepo;
	}

	@Override
	public Wisa save(Wisa w) {
		wisaRepo.save(w);
		return w;
	}

	@Override
	public void saveAll(List<Wisa> ld) {
		for (Wisa w:ld) wisaRepo.save(w);
		
	}

	@Override
	public void delete(Wisa w) {
		wisaRepo.delete(w);
		
	}

	@Override
	public List<Wisa> findDataByDateInterval(Date dIni, Date dFinal) {
		return wisaRepo.findDataByDateInterval(dIni, dFinal);
	}

	@Override
	public Object findByID(WisaPk id) {
		return wisaRepo.findOne(id);
	}

}
