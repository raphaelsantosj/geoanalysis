package api.service;

import java.util.List;

import api.model.Observatory;

public interface ObservatoryService {
	public List<Observatory> findAll();
	public Observatory findByID(String id);
	public Observatory save(Observatory o);
	public void delete(Observatory o);
}
