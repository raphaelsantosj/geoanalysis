/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataInProcessing.objectsFac;

import api.model.DataFile;
import api.model.FailedFile;


public class DataFileStaticFactory {
	
	public static FailedFile makeFFile (DataFile df){
		FailedFile ff = new FailedFile();
		ff.setfName(df.getfName());
		ff.setDate(df.getDate());
		ff.setpDate(df.getpDate());
		ff.setType(df.getType());	
		return ff;
	}
	
	
	public static DataFile makeDFile(FailedFile ff){
		DataFile df = new DataFile();
		df.setfName(ff.getfName());
		df.setDate(DateCalc.dateForFilesAndFF(ff.getfName()));
		df.setpDate(DateCalc.today());
		df.setType(ff.getType());
		return df;
	}
	
	public static DataFile makeDataFileFromFileName(String fileName){
		DataFile df = new DataFile();
		df.setfName(fileName);
		df.setDate(DateCalc.dateForFilesAndFF(fileName));
		df.setpDate(DateCalc.today());
		df.setType(fileName.substring(12, 13));
		return df;
	}
	
	public static FailedFile makeFailedFileFromFileName(String fileName){
		FailedFile ff = new FailedFile();
		ff.setfName(fileName);
		ff.setDate(DateCalc.dateForFilesAndFF(fileName));
		ff.setpDate(DateCalc.today());
		ff.setType(fileName.substring(12, 13));
		return ff;
	}
}
