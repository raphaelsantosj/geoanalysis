package core.services.dataInProcessing;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

public class WisaCalc {
	
	public static List<List> wisaCalc(Date dIni, Date dFim){
		long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
		List<Date> list_data = new LinkedList<Date>();
		List<Time> list_hora = new LinkedList<Time>();
		
		int dia_interval = (int) ((dFim.getTime() - dIni.getTime())/MILLISECONDS_IN_DAY);
		int dia_minutos = 1440;
		
		//Calcula a quantidade de minutos que existe no intervalo entre as duas datas
		for(int i = 0; i < dia_interval; i++){
			Date dia_atual = new Date(dIni.getTime() + (MILLISECONDS_IN_DAY*i));
			//Calcula a quantidade de dias que existe no intervalo entre as duas datas
			for(int k = 0; k < dia_minutos; k++){
				int quant_dia = k;
				Time hora = new Time(quant_dia/60, quant_dia%60, 0);
				list_data.add(dia_atual);
				list_hora.add(hora);
			}
		}
		
		List<List> resultado = new LinkedList<List>();
		resultado.add(list_data);
		resultado.add(list_hora);
		
		for(int r = 0; r < dia_interval*dia_minutos; r++){
			System.out.println(resultado.get(0).get(r).toString() + " " + resultado.get(1).get(r).toString());
		}
		System.out.println(resultado.get(0).size());
		
		return null;
	}

}
