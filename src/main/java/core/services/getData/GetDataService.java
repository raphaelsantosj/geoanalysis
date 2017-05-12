/**
author: Rodrigo Takeshi Seo
rodrigo.seo@inpe.br
National Institute For Space Research
Version 1.0
**/
package core.services.getData;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import api.model.FailedFile;
import core.services.DataBaseService;
import core.services.LogService;
import core.services.EnvironmentSetup;
import core.services.dataInProcessing.DataFactory;
import core.services.dataInProcessing.objectsFac.DataFileStaticFactory;
import core.services.dataInProcessing.objectsFac.DateCalc;
import core.services.ftp.FtpConnection;

public class GetDataService {
	
	private FtpConnection ftp = new FtpConnection(EnvironmentSetup.getInstance().getAddress(), EnvironmentSetup.getInstance().getFtpLogin(), EnvironmentSetup.getInstance().getFtpPW()); 
	private DataFactory df = new DataFactory(); 	
	private LogService ls = new LogService();
    
	public void persistAllMin() throws IOException{
		ftp.connect();
		ftp.setDir("m");
		List<String> files = ftp.getFileList(); //GET ALL FILES NAME FROM DIRECTORY
		ftp.disconnect();
		for(String fileName: files){ //FOR EACH FILE IN FTP DIRECTORY, DO:
			System.out.println(fileName);
			try {			  			
				if (fileValidator(fileName)){	
							List<String> file = ftp.getFile(fileName);
							DataBaseService.getInstance().getDataMinService()
							.saveAll(df.makeDataObjectListMin(file)); //SAVES ALL THE OBJECTS IN THE DB
							DataBaseService.getInstance().getDataFileService()
							.save(DataFileStaticFactory.makeDataFileFromFileName(fileName));
				}	
			} catch(Exception e){		
			ls.getDataLog(Calendar.getInstance().getTime().toString() + "    " + fileName +  "    " + e.getClass().getName());
			e.printStackTrace();
			DataBaseService.getInstance().getFailedFileService()
			.save(DataFileStaticFactory.makeFailedFileFromFileName(fileName));
			}
		}
		
	}
		

	public void persistAllSec() throws IOException{
		ftp.connect();
		ftp.setDir("s");
		List<String> files = ftp.getFileList(); //GET ALL FILE NAMES FROM DIRECTORY
		ftp.disconnect();
		for(String fileName: files){ //FOR EACH FILE IN FTP DIRECTORY, DO:
			try {			  			
				if (fileValidator(fileName)){ 
					List<String> file = ftp.getFile(fileName);							
					DataBaseService.getInstance().getDataSecService().saveAll(df.makeDataObjectListSec(file)); //SAVES ALL THE OBJECTS IN THE DB
					DataBaseService.getInstance().getDataFileService().save(DataFileStaticFactory.makeDataFileFromFileName(fileName));
				}							
			} catch(Exception e){
			ls.getDataLog(Calendar.getInstance().getTime().toString() + "    " + fileName +  "    " + e.getClass().getName());
			e.printStackTrace();
			DataBaseService.getInstance().getFailedFileService().save(DataFileStaticFactory.makeFailedFileFromFileName(fileName));
			}
		}
	}
	
	//This method will check everyday if a FailedFile became available
	public void persistAllFailedFiles(){
		List<FailedFile> lff = new LinkedList<FailedFile>(); //listFailedFiles (ALL)
		lff = DataBaseService.getInstance().getFailedFileService().findAll();
		 for (FailedFile ff: lff){
			 try {
				List<String> file = ftp.getFile(ff.getfName());
				if (ff.getType().equals("m") && file!=null)
					DataBaseService.getInstance().getDataMinService().saveAll(df.makeDataObjectListMin(file));
				else if (ff.getType().equals("s") && file!=null)
					DataBaseService.getInstance().getDataSecService().saveAll(df.makeDataObjectListSec(file)); 
				DataBaseService.getInstance().getDataFileService().save(DataFileStaticFactory.makeDataFileFromFileName(ff.getfName()));	
				DataBaseService.getInstance().getFailedFileService().delete(ff);		
			} catch(Exception e){
				e.printStackTrace();
			}
		 }
	
	}
	
	private Boolean fileValidator(String fileName){
		if (DataBaseService.getInstance().getFailedFileService().findByID(fileName) != null) return false; //VERIFY IF THE FILE IS BROKEN (IT WILL TRY TO DOWNLOAD THE BROKEN FILES AGAIN LATER)
		if (DateCalc.getFileDate(fileName) >= DateCalc.dateCompare()) return false;//VERIFY IF THE FILE IS AT LAST "DAY-1"
		if (DataBaseService.getInstance().getDataFileService().findByID(fileName)!=null) return false; //VERIFY IF THE FILE IS NOT IN DATA BASE (findByID search by name)
		return true;
	}
	


}
