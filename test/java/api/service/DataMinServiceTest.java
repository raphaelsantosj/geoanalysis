package api.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.DataFile;
import api.model.DataMin;
import api.model.DataMinPk;
import api.model.DataSec;
import api.model.Observatory;
import core.services.DataBaseService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class DataMinServiceTest extends TestCase  {
	
	DataMinPk dMinPk1 = new DataMinPk();
	DataMinPk dMinPk2 = new DataMinPk();
	DataMinPk dMinPk3 = new DataMinPk();
	DataMin dMin1 = new DataMin();
	DataMin dMin2 = new DataMin();
	DataMin dMin3 = new DataMin();
	@Before
	public void prepareEnvironment(){
		Observatory pkObs = DataBaseService.getInstance().getObservatoryService().findByID("kak");
		Date pkDate1 = new Date(110, 9, 31);
		Date pkDate2 = new Date(110, 9, 30);
		Date pkDate3 = new Date(110, 9, 29);
		Time pkTime = new Time(00, 00, 00);
		dMinPk1.setDate(pkDate1);
		dMinPk1.setObservatory(pkObs);
		dMinPk1.setHour(pkTime);
		dMinPk2.setDate(pkDate2);
		dMinPk2.setObservatory(pkObs);
		dMinPk2.setHour(pkTime);
		dMinPk3.setDate(pkDate3);
		dMinPk3.setObservatory(pkObs);
		dMinPk3.setHour(pkTime);
		
		dMin1.setId(dMinPk1);
		dMin2.setId(dMinPk2);
		dMin3.setId(dMinPk3);
		
		dMin1.setDOY(250);
		dMin2.setDOY(250);
		dMin3.setDOY(250);
		
		dMin1.setH(20100.02);
		dMin2.setH(9954.55);
		dMin3.setH(20100.02);
		
		dMin1.setD(15999.22);
		dMin2.setD(15999.22);
		dMin3.setD(15999.22);
		
		dMin1.setZ(4000.45);
		dMin2.setZ(4000.45);
		dMin3.setZ(4000.45);
		
		dMin1.setX(20142.32);
		dMin2.setX(20142.32);
		dMin3.setX(20142.32);
		
		dMin1.setY(25999.32);
		dMin2.setY(25999.32);
		dMin3.setY(25999.32);
		
		dMin1.setF(25999.32);
		dMin2.setF(25999.32);
		dMin3.setF(25999.32);
		
		dMin1.setI(1032.9);
		dMin2.setI(1032.92);
		dMin3.setI(1032.99);
	}
	
	
	@Test
	public void testSave(){
		assertEquals(dMin1.toString(), DataBaseService.getInstance().getDataMinService().save(dMin1).toString());
		assertEquals(dMin2.toString(), DataBaseService.getInstance().getDataMinService().save(dMin2).toString());
	}
	@Test
	public void findOneTest(){
		assertEquals(dMin1.toString(), DataBaseService.getInstance().getDataMinService().findByID(dMin1.getId()).toString());
		assertEquals(dMin2.toString(), DataBaseService.getInstance().getDataMinService().findByID(dMin2.getId()).toString());
		assertEquals(null, DataBaseService.getInstance().getDataMinService().findByID(dMin3.getId()));
	}
	@Test
	public void deleteTest(){
		DataBaseService.getInstance().getDataMinService().delete(dMin1);
		DataBaseService.getInstance().getDataMinService().delete(dMin2);
		assertEquals(null, DataBaseService.getInstance().getDataMinService().findByID(dMin1.getId()));
		assertEquals(null, DataBaseService.getInstance().getDataMinService().findByID(dMin2.getId()));	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void findCompHTest(){
		DataBaseService.getInstance().getDataMinService().save(dMin1);
		DataBaseService.getInstance().getDataMinService().save(dMin2);
		List<Double> result = DataBaseService.getInstance().getDataMinService().
				findComponentH(new Date(110, 9, 29), new Date(110, 9, 31), "kak");
		assertEquals(9954.55, result.get(0));
		assertEquals(20100.02, result.get(1));
		DataBaseService.getInstance().getDataMinService().delete(dMin1);
		DataBaseService.getInstance().getDataMinService().delete(dMin2);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void findDataByDateTest(){
		DataBaseService.getInstance().getDataMinService().save(dMin1);
		DataBaseService.getInstance().getDataMinService().save(dMin2);
		List<DataMin> result = DataBaseService.getInstance().getDataMinService().
				findDataByDateInterval(new Date(110, 9, 29), new Date(110, 9, 31), "kak");
		assertEquals(dMin2.toString(), result.get(0).toString());
		assertEquals(dMin1.toString(), result.get(1).toString());
		DataBaseService.getInstance().getDataMinService().delete(dMin1);
		DataBaseService.getInstance().getDataMinService().delete(dMin2);
	}
	

}
