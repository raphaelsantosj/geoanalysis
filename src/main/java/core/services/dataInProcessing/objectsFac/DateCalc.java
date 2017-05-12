/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/

package core.services.dataInProcessing.objectsFac;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class DateCalc {
	
	

	
	//Extract the date from a fileName
	public static int getFileDate(String fileName){
		return Integer.parseInt((fileName.substring(3, 11)));
	}
	
	@SuppressWarnings("deprecation")
	public static Date today(){
		return new Date(Calendar.getInstance().getTime().getYear(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getDate());
	}
	
	public static Integer dateCompare(){
		return Integer.parseInt(today().toString().replace("-", ""));
	}
	
	//DATE CONVERTER FOR FILE AND FAILED FILE CONTROL USING FILE NAME
	public static Date dateForFilesAndFF(String fileName){
		int year = Integer.parseInt(fileName.substring(3, 7))-1900;
		int month = Integer.parseInt(fileName.substring(7, 9))-1;
		int day = Integer.parseInt(fileName.substring(9, 11));
		@SuppressWarnings("deprecation")
		Date dt = new Date(year,month, day);
		
		
		return dt;
	}


	//DATE FORMAT CONVERTER
	@SuppressWarnings("deprecation")
	public static Date dateConverter(String s){
					
		Date dt = new Date((Integer.parseInt(s.substring(0, 4))-1900), (Integer.parseInt(s.substring(5, 7))-1), Integer.parseInt(s.substring(8, 10)));
		
		return dt;
	}
	
	//DAYS BETWEEN TWO SQL DATES
	public static Long daysBetweenDates(Date dIni, Date dFinal){
		final Long MS_IN_DAY = (long) (24 * 60 * 60 * 1000);
		
		Long dIniMS = dIni.getTime();
		Long dFinalMS = dFinal.getTime();
		
		return ((dFinalMS - dIniMS)/MS_IN_DAY);
	}
	
	//TIME FORMAT CONVERTER
	public static Time timeConverter(String s){
		@SuppressWarnings("deprecation")
		Time tm = new Time(Integer.parseInt(s.substring(0, 2)), Integer.parseInt(s.substring(3, 5)), Integer.parseInt(s.substring(6, 8)));
		return tm;
	}
}
