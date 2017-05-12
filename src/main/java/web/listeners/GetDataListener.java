/**
  author: Rodrigo Takeshi Seo
  rodrigo.seo@inpe.br
  National Institute For Space Research
  Version 1.0
 **/
package web.listeners;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import core.services.getData.GetDataService;

public class GetDataListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		long TEMPO = (1000 * 60 * 120 );
		final GetDataService d = new GetDataService();
		Timer timer = null;
		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {	
						//d.persistAllMin();
						//d.persistAllSec();						
						//d.persistAllFailedFiles();  
						System.out.println(Calendar.getInstance().getTime().toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, 0, TEMPO);			
		}
	  }


	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
