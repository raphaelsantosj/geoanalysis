package api.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.Wisa;
import api.model.WisaPk;
import core.services.DataBaseService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class WisaTest extends TestCase{
	
	WisaPk wisaPk1 = new WisaPk();
	WisaPk wisaPk2 = new WisaPk();
	WisaPk wisaPk3 = new WisaPk();
	Wisa wisa1 = new Wisa();
	Wisa wisa2 = new Wisa();
	Wisa wisa3 = new Wisa();
	@Before
	public void prepareEnvironment(){
		Date pkDate1 = new Date(110, 9, 31);
		Date pkDate2 = new Date(110, 9, 30);
		Date pkDate3 = new Date(110, 9, 29);
		Time pkTime = new Time(00, 00, 00);
		wisaPk1.setDate(pkDate1);
		wisaPk1.setHour(pkTime);
		wisaPk2.setDate(pkDate2);
		wisaPk2.setHour(pkTime);
		wisaPk3.setDate(pkDate3);
		wisaPk3.setHour(pkTime);
		
		wisa1.setId(wisaPk1);
		wisa2.setId(wisaPk2);
		wisa3.setId(wisaPk3);
	}
	
	
	@Test
	public void testSave(){
		assertEquals(wisa1.toString(), DataBaseService.getInstance().getWisaService().save(wisa1).toString());
		assertEquals(wisa2.toString(), DataBaseService.getInstance().getWisaService().save(wisa2).toString());
	}
	@Test
	public void findOneTest(){
		assertEquals(wisa1.toString(), DataBaseService.getInstance().getWisaService().findByID(wisa1.getId()).toString());
		assertEquals(wisa2.toString(), DataBaseService.getInstance().getWisaService().findByID(wisa2.getId()).toString());	
		assertEquals(null, DataBaseService.getInstance().getWisaService().findByID(wisa3.getId()));
	}
	@Test
	public void deleteTest(){
		DataBaseService.getInstance().getWisaService().delete(wisa1);
		DataBaseService.getInstance().getWisaService().delete(wisa2);
		assertEquals(null, DataBaseService.getInstance().getWisaService().findByID(wisa1.getId()));
		assertEquals(null, DataBaseService.getInstance().getWisaService().findByID(wisa2.getId()));	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void findDataByDateTest(){
		DataBaseService.getInstance().getWisaService().save(wisa1);
		DataBaseService.getInstance().getWisaService().save(wisa2);
		List<Wisa> result = DataBaseService.getInstance().getWisaService().
				findDataByDateInterval(new Date(110, 9, 29), new Date(110, 9, 31));
		assertEquals(wisa2.toString(), result.get(0).toString());
		assertEquals(wisa1.toString(), result.get(1).toString());
		DataBaseService.getInstance().getWisaService().delete(wisa1);
		DataBaseService.getInstance().getWisaService().delete(wisa2);
	}
	
}
