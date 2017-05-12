package core.services;

import java.sql.Date;
import java.sql.Time;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.model.DataMin;
import api.model.DataMinPk;
import api.model.Observatory;
import core.services.dataInProcessing.objectsFac.ComponentCalc;
import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ComponentCalcTest extends TestCase {
	
	DataMinPk dMinPk1 = new DataMinPk();
	DataMin dMin1 = new DataMin();
	DataMin dMin2 = new DataMin();
	Observatory pkObs = new Observatory();
	
	@SuppressWarnings("deprecation")
	@Before
	public void prepareEnvironment(){
		pkObs.setIAGA("xxy");
		pkObs.setCountry("Westeros");
		pkObs.setInstitute("Hogwarts");
		pkObs.setGIN("ni");
		pkObs.setName("Obs1");
		pkObs.setColatitute(20.999);
		pkObs.setEastLong(99.2);
		Date pkDate1 = new Date(110, 9, 31);
		Time pkTime = new Time(00, 00, 00);
		dMinPk1.setDate(pkDate1);
		dMinPk1.setObservatory(pkObs);
		dMinPk1.setHour(pkTime);
		dMin1.setId(dMinPk1);
		dMin1.setDOY(250);
		dMin1.setD(0.99);
		dMin1.setH(333.00);
		dMin1.setF(123.12);
		dMin1.setI(55.12);
		dMin1.setX(330.00);
		dMin1.setY(88.44);
		dMin1.setZ(1985.55);
		dMin2.setId(dMinPk1);
		dMin2.setDOY(250);
		dMin2.setD(0.99);
		dMin2.setH(99999.99);
		dMin2.setF(123.12);
		dMin2.setI(55.12);
		dMin2.setX(99999.99);
		dMin2.setY(88.44);
		dMin2.setZ(1985.55);
	}
	
	@Test
	public void testXComponentCalc(){
		//h*Cos(ASin(Y/H))
		assertEquals(321.04, ComponentCalc.calcX(dMin1));
		//Test Data Fail
		assertEquals(99999.00, ComponentCalc.calcX(dMin2));	
	}
	
	@Test
	public void testHComponentCalc(){
		//sqrt(x^2 + Y^2)
		assertEquals(341.65, ComponentCalc.calcH(dMin1));
		//Test Data Fail
		assertEquals(99999.00, ComponentCalc.calcH(dMin2));
	}
	
	@Test
	public void testDComponentCalc(){
		//ASin(Y/H)
		assertEquals(0.26881127047801495, ComponentCalc.calcD(dMin1));
		//Test Data Fail
		assertEquals(99999.00, ComponentCalc.calcD(dMin2));
		
	}
	
	@Test
	public void testIComponentCalc(){
		//aTan(Z/H)
		assertEquals(1.4, ComponentCalc.calcI(dMin1));
		//Test Data Fail
		assertEquals(99999.00, ComponentCalc.calcI(dMin2));
		
	}

}
