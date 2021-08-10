package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.F5;
import view.F5FunctionInputField;

/**
 * 
 * @author Natheepan Ganeshamoorthy (Natt)
 *
 */
public class F5Tests {

	/**
	 * Testing Variable a in ab^x where a has no input from user. Should receive error
	 */
	@Test
	public void testNoInputForVariableA() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: NO INPUT RECEIVED\nPlease try again", f5InputFieldForA.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b has no input from user. Should receive error
	 */
	@Test
	public void testNoInputForVariableB() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "3";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: NO INPUT RECEIVED\nPlease try again", f5InputFieldForB.errorMsg);
	}

	/**
	 * Testing Variable x in ab^x where x has no input from user. Should receive error
	 */
	@Test
	public void testNoInputForVariableX() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "3";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "2";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: NO INPUT RECEIVED\nPlease try again", f5InputFieldForX.errorMsg);
	}
	
	/**
	 * Testing Variable a in ab^x where a does not equal a real number. Should receive error
	 */
	@Test
	public void testNonRealNumberForVariableA() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "edwdre";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "2";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nA real number is expected", f5InputFieldForA.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b does not equal a real number. Should receive error
	 */
	@Test
	public void testNonRealNumberForVariableB() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "3";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "dexerxewdx";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nA real number is expected", f5InputFieldForB.errorMsg);
	}
	
	/**
	 * Testing Variable x in ab^x where x does not equal a real number. Should receive error
	 */
	@Test
	public void testNonRealNumberForVariableX() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "4";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "2";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "fcederd";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nA real number is expected", f5InputFieldForX.errorMsg);
	}
	
	/**
	 * Testing Variable a in ab^x where a = 0. Should receive error
	 */
	@Test
	public void testEqualZeroForVariableA() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "0";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "2";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nParameter 'a' cannot be 0.", f5InputFieldForA.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b = 0. Should receive error
	 */
	@Test
	public void testEqualZeroForVariableB() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "2";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "0";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nParameter 'b' must be greater than 0, and cannot be 1.", f5InputFieldForB.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b = 1. Should receive error
	 */
	@Test
	public void testEqualOneForVariableB() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "2";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "1";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nParameter 'b' must be greater than 0, and cannot be 1.", f5InputFieldForB.errorMsg);
	}
	
	/**
	 * Testing Variable b in ab^x where b < 0. Should receive error
	 */
	@Test
	public void testLessThanZeroForVariableB() {
		F5 f5 = new F5();
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "2";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "-2";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "3";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		
		assertEquals("ERROR: INVALID INPUT\nParameter 'b' must be greater than 0, and cannot be 1.", f5InputFieldForB.errorMsg);
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
		F5FunctionInputFieldTest f5InputFieldForA = new F5FunctionInputFieldTest();
		f5InputFieldForA.a = "1";
		F5FunctionInputFieldTest f5InputFieldForB = new F5FunctionInputFieldTest();
		f5InputFieldForB.b = "5";
		F5FunctionInputFieldTest f5InputFieldForX = new F5FunctionInputFieldTest();
		f5InputFieldForX.x = "-3.5";
		f5.f5InputFieldForA = f5InputFieldForA;
		f5.f5InputFieldForB = f5InputFieldForB;
		f5.f5InputFieldForX = f5InputFieldForX;
		f5.getInputs();
		f5.calculateResult();
		assertEquals(0.00358, f5.result, 0.00001);
	}
}

class F5FunctionInputFieldTest extends F5FunctionInputField
{
	String a = "";
	String b = "";
	String x = "";
	
	@Override
	public String getResponseForA(String message) 
	{
		showDialog = false;
		return "" + a;
	}

	@Override
	public String getResponseForB(String message) 
	{
		showDialog = false;
		return "" + b;
	}

	@Override
	public String getResponseForX(String message) 
	{
		showDialog = false;
		return "" + x;
	}
}