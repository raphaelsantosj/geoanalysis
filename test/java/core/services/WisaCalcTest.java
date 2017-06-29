package core.services;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.services.dataInProcessing.WisaCalc;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class WisaCalcTest extends TestCase{
	
	WisaCalc wisaCalc = new WisaCalc();
	
	
	@Before
	public void prepareEnvironment(){
		Date d1 = new Date(114, 9, 1);
		Date d2 = new Date(114, 9, 2);
	}
	
	@Test
	public void testCalc(){

	}
}