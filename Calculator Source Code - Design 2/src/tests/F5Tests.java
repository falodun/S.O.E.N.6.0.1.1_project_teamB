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

	@Test
	public void testNotEqualZeroForVariableA() {
		F5 f5 = new F5();
		f5.a = 0;
		f5.b = 2;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'a' cannot be 0.", f5.errorMsg);
	}
	
	@Test
	public void testNotEqualZeroForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 0;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}
	
	@Test
	public void testNotEqualOneForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = 1;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}
	
	@Test
	public void testNotLessThanZeroForVariableB() {
		F5 f5 = new F5();
		f5.a = 2;
		f5.b = -2;
		f5.x = 3;
		f5.calculateResult();
        assertEquals("ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.", f5.errorMsg);
	}

}
