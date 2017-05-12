package api.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.DataSec;
import api.model.DataSecPk;
import api.model.Observatory;
import core.services.DataBaseService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class DataSecServiceTest extends TestCase {
	

	DataSecPk dSecPk1 = new DataSecPk();
	DataSecPk dSecPk2 = new DataSecPk();
	DataSecPk dSecPk3 = new DataSecPk();
	DataSec dSec1 = new DataSec();
	DataSec dSec2 = new DataSec();
	DataSec dSec3 = new DataSec();

	@Before
	public void prepareEnvironment(){
		
		Observatory pkObs = DataBaseService.getInstance().getObservatoryService().findByID("kak");
		
		Date pkDate1 = new Date(110, 9, 31);
		Date pkDate2 = new Date(110, 9, 30);
		Date pkDate3 = new Date(110, 9, 29);
		
		Time pkTime = new Time(00, 00, 00);
		
		dSecPk1.setDate(pkDate1);
		dSecPk1.setObservatory(pkObs);
		dSecPk1.setHour(pkTime);
		dSecPk2.setDate(pkDate2);
		dSecPk2.setObservatory(pkObs);
		dSecPk2.setHour(pkTime);
		dSecPk3.setDate(pkDate3);
		dSecPk3.setObservatory(pkObs);
		dSecPk3.setHour(pkTime);
		
		dSec1.setId(dSecPk1);
		dSec2.setId(dSecPk2);
		dSec3.setId(dSecPk3);
		
		dSec1.setDOY(250);
		dSec2.setDOY(250);
		dSec3.setDOY(250);
		
		dSec1.setH(20100.02);
		dSec2.setH(9954.55);
		dSec3.setH(20100.02);
		
		dSec1.setD(15999.22);
		dSec2.setD(15999.22);
		dSec3.setD(15999.22);
		
		dSec1.setZ(4000.45);
		dSec2.setZ(4000.45);
		dSec3.setZ(4000.45);
		
		dSec1.setX(20142.32);
		dSec2.setX(20142.32);
		dSec3.setX(20142.32);
		
		dSec1.setY(25999.32);
		dSec2.setY(25999.32);
		dSec3.setY(25999.32);
		
		dSec1.setF(25999.32);
		dSec2.setF(25999.32);
		dSec3.setF(25999.32);
		
		dSec1.setI(1032.9);
		dSec2.setI(1032.92);
		dSec3.setI(1032.99);
	}
	
	
	@Test
	public void testSave(){
		assertEquals(dSec1.toString(), DataBaseService.getInstance().getDataSecService().save(dSec1).toString());
		assertEquals(dSec2.toString(), DataBaseService.getInstance().getDataSecService().save(dSec2).toString());
	}
	
	@Test
	public void findTest(){
		assertEquals(dSec1.toString(), DataBaseService.getInstance().getDataSecService().findByID(dSec1.getId()).toString());
		assertEquals(dSec2.toString(), DataBaseService.getInstance().getDataSecService().findByID(dSec2.getId()).toString());
		assertEquals(null, DataBaseService.getInstance().getDataSecService().findByID(dSec3.getId()));
	}
	
	
	@Test
	public void deleteTest(){
		DataBaseService.getInstance().getDataSecService().delete(dSec1);
		DataBaseService.getInstance().getDataSecService().delete(dSec2);
		assertEquals(null, DataBaseService.getInstance().getDataSecService().findByID(dSec1.getId()));
		assertEquals(null, DataBaseService.getInstance().getDataSecService().findByID(dSec2.getId()));
		
	}
	
	@Test
	public void findDataByDateTest(){
		DataBaseService.getInstance().getDataSecService().save(dSec1);
		DataBaseService.getInstance().getDataSecService().save(dSec2);
		List<DataSec> result = DataBaseService.getInstance().getDataSecService().findDataByDateInterval(new Date(110, 9, 29), new Date(110, 9, 31), "kak");
		assertEquals(dSec2.toString(), result.get(0).toString());
		assertEquals(dSec1.toString(), result.get(1).toString());
		DataBaseService.getInstance().getDataSecService().delete(dSec1);
		DataBaseService.getInstance().getDataSecService().delete(dSec2);
	}
	
	@Test
	public void findCompHTest(){
		DataBaseService.getInstance().getDataSecService().save(dSec1);
		DataBaseService.getInstance().getDataSecService().save(dSec2);
		List<Double> result = DataBaseService.getInstance().getDataSecService().findComponentH(new Date(110, 9, 29), new Date(110, 9, 31), "kak");
		assertEquals(9954.55, result.get(0));
		assertEquals(20100.02, result.get(1));
		DataBaseService.getInstance().getDataSecService().delete(dSec1);
		DataBaseService.getInstance().getDataSecService().delete(dSec2);
	}
	


}
