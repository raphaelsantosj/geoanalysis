package api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.DataFile;
import api.repository.DataFileRepository;
@Service("dataFileService")
@Transactional
public class DataFileServiceImpl implements DataFileService{
	
	@Autowired
	private DataFileRepository dataFileRepo;
	

	public void setDataFileRepo(DataFileRepository dataFileRepo) {
		this.dataFileRepo = dataFileRepo;
	}

	@Override
	public List<DataFile> findAll() {
		List<DataFile> allFiles = new LinkedList<DataFile>();
		for (DataFile df: dataFileRepo.findAll()) allFiles.add(df);
		return allFiles;
	}

	@Override
	public DataFile findByID(String fName) {
		return dataFileRepo.findOne(fName);
	}

	@Override
	public DataFile save(DataFile d) {
		return dataFileRepo.save(d);
	}

	@Override
	public void delete(DataFile d) {
		dataFileRepo.delete(d);
	}
	
	


}
