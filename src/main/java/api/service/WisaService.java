package api.service;

import java.sql.Date;
import java.util.List;

import api.model.Wisa;
import api.model.WisaPk;

public interface WisaService {
	
	public Wisa save(Wisa w);
	public void saveAll(List<Wisa> w);
	public void delete(Wisa w);
	public List<Wisa> findDataByDateInterval(Date dIni, Date dFinal);
	public Object findByID(WisaPk id);
}
