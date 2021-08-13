package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.F7;

/**
 * 
 * @author Himani Himani
 *
 */
public class F7Tests {

	
	F7 f7 = new F7();
	
	/**
	 * Testing 0^0. Should result in 1 as output result.
	 */
	@Test
	public void testZeroBaseZeroPower() {
	
		f7.x = 0;
		f7.y = 0;  //zero power returns answer as 1
		
		f7.calculateResult();
		assertEquals(1.0, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a number raised to positive power.
	 */
	@Test
	public void testFindResultFoPositivePower() {
	
		f7.x = -2;
		f7.y = 3;  
		
		f7.calculateResult();
		assertEquals(-8.0, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a number raised to positive power.
	 */
	@Test
	public void testFindResultForNegativePower() {
	
		f7.x = 2;
		f7.y = -3;  
		
		f7.calculateResult();
		assertEquals(0.1250, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a number raised to fraction power.
	 */
	@Test
	public void testFindResultForFractionPositivePower() {
	
		f7.x = 2;
		f7.y = 3.2;  
		
		f7.calculateResult();
		assertEquals(9.189590, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a negative number raised to fraction power.
	 */
	@Test
	public void testFindResultForFractionNegativePower() {
	
		f7.x = 8;
		f7.y = -1.5;  
		
		f7.calculateResult();
		assertEquals(0.044194167960819215, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a number raised to 1 power.
	 */
	@Test
	public void testFindResultForOnePower() {
	
		f7.x = -5;
		f7.y = 1;  
		
		f7.calculateResult();
		assertEquals(-5.0, f7.result, 0.0);
		
	}
	
	/**
	 * Testing a number raised to 0 power.
	 */
	@Test
	public void testFindResultForZeroPower() {
	
		f7.x = -5;
		f7.y = 0;  
		
		f7.calculateResult();
		assertEquals(1.0, f7.result, 0.0);
		
	}
	
}
