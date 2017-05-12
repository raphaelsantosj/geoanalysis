package api.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.Observatory;
import api.model.Observatory;
import core.services.DataBaseService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ObservatoryServiceTest extends TestCase {
	
	Observatory o1 = new Observatory();
	Observatory o2 = new Observatory();
	Observatory o3 = new Observatory();
	
	
	@Before
	public void prepareEnvironment(){
		
		o1.setIAGA("xxy");
		o2.setIAGA("yxy");
		o3.setIAGA("xyx");
		o1.setCountry("Narnia");
		o2.setCountry("Terra Média");
		o3.setCountry("Westeros");
		o1.setInstitute("Hogwarts");
		o2.setInstitute("Hogwarts");
		o3.setInstitute("Hogwarts");
		o1.setGIN("ni");
		o2.setGIN("ni");
		o3.setGIN("ni");
		o1.setName("Obs1");
		o2.setName("Obs2");
		o3.setName("Obs3");
		o1.setColatitute(20.999);
		o2.setColatitute(120.999);
		o3.setColatitute(210.999);
		o1.setEastLong(99.2);
		o2.setEastLong(999.2);
		o3.setEastLong(8888.2);
	}
	
	@Test
	public void testSave(){
		assertEquals(o1.toString(), DataBaseService.getInstance().getObservatoryService().save(o1).toString());
		assertEquals(o2.toString(), DataBaseService.getInstance().getObservatoryService().save(o2).toString());
	}
	
	@Test
	public void findTest(){
		assertEquals(o1.toString(), DataBaseService.getInstance().getObservatoryService().findByID(o1.getIAGA()).toString());
		assertEquals(o2.toString(), DataBaseService.getInstance().getObservatoryService().findByID(o2.getIAGA()).toString());
		assertEquals(null, DataBaseService.getInstance().getObservatoryService().findByID(o3.getIAGA()));
	}
	
	@Test
	public void findAllTest(){
		List<Observatory> ObservatoryList = DataBaseService.getInstance().getObservatoryService().findAll();
		assertEquals(3, ObservatoryList.size()); // 2 Observatories + Kakioka
	}
	
	@Test
	public void deleteTest(){
		DataBaseService.getInstance().getObservatoryService().delete(o1);
		DataBaseService.getInstance().getObservatoryService().delete(o2);
		assertEquals(null, DataBaseService.getInstance().getObservatoryService().findByID(o1.getIAGA()));
		
	}

}
