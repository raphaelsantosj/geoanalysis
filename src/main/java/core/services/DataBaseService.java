/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.1
  updated by: Raphael bboy
  
 **/
package core.services;

import org.springframework.beans.factory.annotation.Autowired;

import api.service.DataFileService;
import api.service.DataMinService;
import api.service.DataSecService;
import api.service.FailedFileService;
import api.service.ObservatoryService;
import api.service.WisaService;


public class DataBaseService {
	private static DataBaseService dataBaseServiceInstance;
	
	@Autowired
	private DataFileService dataFileService;
	@Autowired
	private FailedFileService failedFileService;
	@Autowired
	private ObservatoryService observatoryService;
	@Autowired
	private DataMinService	dataMinService;
	@Autowired
	private DataSecService dataSecService;
	@Autowired
	private WisaService wisaService;
	
	
	private DataBaseService(){
		
	}
	
	public static DataBaseService getInstance(){
		if(dataBaseServiceInstance == null) dataBaseServiceInstance = new DataBaseService();
		return dataBaseServiceInstance;
	}

	public DataFileService getDataFileService() {
		return dataFileService;
	}

	public FailedFileService getFailedFileService() {
		return failedFileService;
	}

	public ObservatoryService getObservatoryService() {
		return observatoryService;
	}

	public DataMinService getDataMinService() {
		return dataMinService;
	}

	public DataSecService getDataSecService() {
		return dataSecService;
	}

	public static DataBaseService getDataBaseServiceInstance() {
		return dataBaseServiceInstance;
	}
	
	public WisaService getWisaService() {
		return wisaService;
	}


	public void setDataFileService(DataFileService dataFileService) {
		this.dataFileService = dataFileService;
	}

	public void setFailedFileService(FailedFileService failedFileService) {
		this.failedFileService = failedFileService;
	}

	public void setObservatoryService(ObservatoryService observatoryService) {
		this.observatoryService = observatoryService;
	}

	public void setDataMinService(DataMinService dataMinService) {
		this.dataMinService = dataMinService;
	}

	public void setDataSecService(DataSecService dataSecService) {
		this.dataSecService = dataSecService;
	}
	
	public void setWisaService(WisaService wisaService) {
		this.wisaService = wisaService;
	}

	

	
	 

}
