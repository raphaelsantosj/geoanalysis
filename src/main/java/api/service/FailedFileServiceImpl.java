package api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.FailedFile;
import api.repository.FailedFileRepository;

@Service("failedFileService")
@Transactional
public class FailedFileServiceImpl implements FailedFileService {

	@Autowired
	private FailedFileRepository failedFileRepo;
	

	public void setFailedFileRepo(FailedFileRepository failedFileRepo) {
		this.failedFileRepo = failedFileRepo;
	}

	@Override
	public List<FailedFile> findAll() {
		List<FailedFile> lff = new LinkedList<FailedFile>();
		for(FailedFile ff: failedFileRepo.findAll()) lff.add(ff);	
		return lff;	
	}

	@Override
	public FailedFile findByID(String id) {
		return failedFileRepo.findOne(id);
	}

	@Override
	public FailedFile save(FailedFile ff) {
		return failedFileRepo.save(ff);
	}

	@Override
	public void delete(FailedFile ff) {
		failedFileRepo.delete(ff);
	}

}
