package api.service;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.DataFile;
import core.services.DataBaseService;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class DataFileServiceTest extends TestCase {
	
	DataFile d1 = new DataFile();
	DataFile d2 = new DataFile();
	DataFile d3 = new DataFile();
	
    public DataFileServiceTest(){
        
    }
  
	
	@Before
	public void prepareEnvironment(){
		Date d1Date = new Date(110, 9, 31);
		Date d1PDate = new Date(110, 9, 30);
		Date d2Date = new Date(110, 8, 31);
		Date d2PDate = new Date(110, 8, 30);
		Date d3Date = new Date(110, 7, 31);
		Date d3PDate = new Date(110, 7, 30);
		
		d1.setfName("xxx20101031pmin.min");
		d1.setDate(d1Date);
		d1.setpDate(d1PDate);
		d1.setType("M");
		
		d2.setfName("xxx20100931pmin.min");
		d2.setDate(d2Date);
		d2.setpDate(d2PDate);
		d2.setType("M");
		
		d3.setfName("xxx20100831pmin.min");
		d3.setDate(d3Date);
		d3.setpDate(d3PDate);
		d3.setType("M");
	}
	
	@Test
	public void testSave(){
		assertEquals(d1.toString(), DataBaseService.getInstance().getDataFileService().save(d1).toString());
		assertEquals(d2.toString(), DataBaseService.getInstance().getDataFileService().save(d2).toString());
	}
	
	@Test
	public void findTest(){
		assertEquals(d1.toString(), DataBaseService.getInstance().getDataFileService().findByID(d1.getfName()).toString());
		assertEquals(d2.toString(), DataBaseService.getInstance().getDataFileService().findByID(d2.getfName()).toString());
		assertEquals(null, DataBaseService.getInstance().getDataFileService().findByID(d3.getfName()));
	}
	
	@Test
	public void findAllTest(){
		List<DataFile> dataFileList = DataBaseService.getInstance().getDataFileService().findAll();
		assertEquals(2, dataFileList.size());	
	}
	
	@Test
	public void deleteTest(){
		DataBaseService.getInstance().getDataFileService().delete(d1);
		DataBaseService.getInstance().getDataFileService().delete(d2);
		assertEquals(null, DataBaseService.getInstance().getDataFileService().findByID(d1.getfName()));
		assertEquals(null, DataBaseService.getInstance().getDataFileService().findByID(d2.getfName()));
		
	}
	
	
	
	
	

}
