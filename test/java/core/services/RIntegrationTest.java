package core.services;

import org.junit.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;

import junit.framework.TestCase;

public class RIntegrationTest extends TestCase {
	
	@Test
	public void testRIntegration(){
		try {
			//Testing basic sum operation
			assertEquals(4.0, RIntegration.getInstance().getRConnection().eval("2+2").asDouble());
			//Testing basic logical operation
			assertEquals(true, RIntegration.getInstance().getRConnection().eval("2==2").isLogical());
			//Testing R "c" method returning a array
			assertEquals(5 ,RIntegration.getInstance().getRConnection().eval("c(5, 3, 5, 4, 2)").length());
		} catch (RserveException | REXPMismatchException e) {
			e.printStackTrace();
		}
	}

}
