package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import model.F1;

public class F1Tests {
	
	F1 f1 = new F1();
	
	/*
	 * Finding square root
	 */
	@Test
	public void test1() {
		double x = 0.025;
		assertEquals(String.valueOf(f1.getSquareRoot(x)), String.valueOf(0.15811388300841897));
	}
	
	/*
	 * Reducing value of X to the equivalent arc-tangent value
	 */
	@Test
	public void test2() {
		double x = 0.92;
		assertEquals(String.valueOf(f1.arcCosX(x)), String.valueOf(0.40271534418895777));
	}
	
	/*
	 * Input not in the range -1 and 1
	 */
	@Test
	public void test3() {
		double x = 2;
		assertEquals(String.valueOf(f1.arcCosX(x)), String.valueOf("NaN"));
	}
	
	/*
	 * Input in the range -1 and 1
	 */
	@Test
	public void test4() {
		double x = 0.9;
		assertNotEquals(String.valueOf(f1.arcCosX(x)), String.valueOf("NaN"));
	}

	/*
	 * Input in the range -1 and 1
	 */
	@Test
	public void test5() {
		double x = 1;
		assertNotEquals(String.valueOf(f1.arcCosX(x)), String.valueOf("NaN"));
	}
	
	/*
	 * Tangent Value of X
	 */
	@Test
	public void test6() {
		double x = 1;
		assertEquals(String.valueOf(f1.arcTanx(x)), String.valueOf("0.7854111405631049"));
	}
}
