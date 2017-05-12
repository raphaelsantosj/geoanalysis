package api.service;

import java.util.List;

import api.model.FailedFile;

public interface FailedFileService {
	
	public List<FailedFile> findAll();
	public FailedFile findByID(String f);
	public FailedFile save (FailedFile f);
	public void delete (FailedFile f);

}
