package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import model.F1;


/**
 * class contains methods to test F1
 * @author Tejaswini
 *
 */
public class F1Tests {

	F1 f1 = new F1();
	/*
	 * R04 - Finding square root
	 */
	@Test
	public void testSquareRootFunctionality() {
		double x = 0.025;
		assertEquals(String.valueOf(F1.getSquareRoot(x)), String.valueOf(0.15811388300841897));
	}

	/*
	 * R05 - Reducing value of X to the equivalent arc-tangent value
	 */
	@Test
	public void testArcosFunctionality() {
		double x = 0.92;
		assertEquals(String.valueOf(f1.arcCosX(x)), String.valueOf(0.40271534418895777));
	}

	/*
	 * R03 - Input not in the range -1 and 1, then returns NaN(in-valid Input)
	 */
	@Test
	public void testDomain() {
		double x = 2;
		assertEquals(String.valueOf(f1.arcCosX(x)), String.valueOf("NaN"));
	}

	/*
	 * R06 -Arc Tangent Value of X
	 */
	@Test
	public void testArctanget() {
		double x = 1;
		assertEquals(String.valueOf(f1.arcTanx(x)), String.valueOf("0.7854111405631049"));
	}

	/*
	 * R03 - Input in the range -1 and 1 and does not return NaN(Valid Input)
	 */
	@Test
	public void testDomain1() {
		double x = 0.9;
		assertNotEquals(String.valueOf(f1.arcCosX(x)), String.valueOf("NaN"));
	}

	/*
	 * R07 - Convert radians to degrees
	 */
	@Test
	public void testRadianToDegreeConversion() {
		double x = 0.83658;
		assertEquals(String.valueOf(F1.convertRadToDegress(x)), String.valueOf("47.932543711942046"));
	}


	/**
	 *  R03 - Input in the range -1 and 1
	 */
	@Test
	public void testNegativevalueinDomain() {
		double x = -0.83658;
		System.out.println(String.valueOf(f1.arcTanx(x)));
		assertEquals(String.valueOf(f1.arcTanx(x)), String.valueOf("-0.6966515384834499"));
	}

}
	