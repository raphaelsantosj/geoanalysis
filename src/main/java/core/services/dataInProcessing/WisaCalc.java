package core.services.dataInProcessing;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WisaCalc {
	
	public static List<List> ls(Date dIni, Date dFim){
		long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
		List<Date> ld = new LinkedList<Date>();
		List<Time> lh = new LinkedList<Time>();
		
		int fK = (int) ((dFim.getTime() - dIni.getTime())/MILLISECONDS_IN_DAY+2);
		int sK = 1440;
		
		
		
		for(int k = 0; k < fK; k++){
			Date dAtual = new Date(dIni.getTime() + (MILLISECONDS_IN_DAY*k));
			for(int i = 0; i < sK; i++){
				int mDay = i; 
				Time t = new Time(mDay/60, mDay%60 ,0);
				ld.add(dAtual);
				lh.add(t);		
			}
		}
		
		List<List> result = new LinkedList<List>();
		result.add(ld);
		result.add(lh);
		
		return result;
	}

}
