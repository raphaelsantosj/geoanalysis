package api.service;

import java.util.List;

import api.model.DataFile;

public interface DataFileService {
	
	public List<DataFile> findAll();
	public DataFile findByID(String fName);
	public DataFile save(DataFile d);
	public void delete(DataFile d);

}
