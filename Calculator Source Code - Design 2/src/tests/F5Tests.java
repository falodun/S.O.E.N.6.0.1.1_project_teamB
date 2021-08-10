package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.F5;

/**
 * 
 * @author Natheepan Ganeshamoorthy (Natt)
 *
 */
public class F5Tests {

	/**
	 * Testing Variable a in ab^x where a = 0. Should receive error
	 */
	@Test
	public void testNotEqualZeroForVariableA() {
		F5 f5 = new F5();
		f5.a = 0;
		f5.b = 2;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'a' cannot be 0.", f5.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b = 0. Should receive error
	 */
	@Test
	public void testNotEqualZeroForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 0;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b = 1. Should receive error
	 */
	@Test
	public void testNotEqualOneForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 1;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b < 0. Should receive error
	 */
	@Test
	public void testNotLessThanZeroForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = -2;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}
	
	/**
	 * Testing Variable x in ab^x where x = 0
	 */
	@Test
	public void testEqualZeroForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 3;
		f5.x = 0;
		f5.calculateResult();
        assertEquals(2.0, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where x = 1
	 */
	@Test
	public void testEqualOneForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 3;
		f5.x = 1;
		f5.calculateResult();
        assertEquals(6.0, f5.result, 0.00001);
	}

	/**
	 * Testing Variable x in ab^x where -1 < x < 0
	 */
	@Test
	public void testLessThanZeroGreaterThanMinusOneForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = -0.5;
		f5.calculateResult();
		assertEquals(0.44721, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where 0 < x < 1
	 */
	@Test
	public void testLessThanOneGreaterThanZeroForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = 0.5;
		f5.calculateResult();
		assertEquals(2.23607, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where x > 1 and is integer number
	 */
	@Test
	public void testGreaterThanOneAndIntegerForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = 5;
		f5.calculateResult();
		assertEquals(3125, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where x > 1 and is a decimal number
	 */
	@Test
	public void testGreaterThanOneAndDecimalForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = 6.5;
		f5.calculateResult();
		assertEquals(34938.56215, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where x < -1 and is integer number
	 */
	@Test
	public void testLessThanMinusOneAndIntegerForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = -5;
		f5.calculateResult();
		assertEquals(0.00032, f5.result, 0.00001);
	}
	
	/**
	 * Testing Variable x in ab^x where x < -1 and is a decimal number
	 */
	@Test
	public void testLessThanMinusOneAndDecimalForPowerVariableX() {
		F5 f5 = new F5();
		f5.a = 1;
		f5.b = 5;
		f5.x = -3.5;
		f5.calculateResult();
		assertEquals(0.00358, f5.result, 0.00001);
	}
}
