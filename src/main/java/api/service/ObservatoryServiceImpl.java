package api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.Observatory;
import api.repository.ObservatoryRepository;

@Service("observatoryService")
@Transactional
public class ObservatoryServiceImpl implements ObservatoryService {
	
	@Autowired
	private ObservatoryRepository observatoryRepo;
	
	

	public void setObservatoryRepo(ObservatoryRepository observatoryRepo) {
		this.observatoryRepo = observatoryRepo;
	}

	@Override
	public List<Observatory> findAll() {
		List<Observatory> lo = new LinkedList<Observatory>();
		for(Observatory o: observatoryRepo.findAll()) lo.add(o);	
		return lo;	
	}

	@Override
	public Observatory findByID(String id) {
		return observatoryRepo.findOne(id);
	}

	@Override
	public Observatory save(Observatory o) {
		return observatoryRepo.save(o);
	}

	@Override
	public void delete(Observatory o) {
		observatoryRepo.delete(o);
	}

}
