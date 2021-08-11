package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.F3;
import static constants.Constants.EULER;
/**
 * 
 * Test Case to compare F3's results with that of the Math library
 * @author Adekunle Falodun
 *
 */
public class F3Tests {
    F3 f3 = new F3();
    
    /**
     * Method for calculating sinh using the Math library
     */
    public String sinhWithMathLibrary(double x) {
    	double pow = Math.pow(EULER, x);
        return String.format("%.5f", (pow-(1/pow))/2);
    }

    /**
     * Test for input of zero
     */
    @Test
    public void inputZero() {
        String result = String.format("%.5f", f3.sinh(0));
        assertEquals(result, sinhWithMathLibrary(0));
    }
    
    /**
     * Test for input of One
     */
    @Test
    public void inputOne() {
        String result = String.format("%.5f", f3.sinh(1));
        assertEquals(result, sinhWithMathLibrary(1));
    }
    
    /**
     * Test for a positive integer input
     */
    @Test
    public void positiveInteger() {
        String result = String.format("%.5f", f3.sinh(50));
        assertEquals(result, sinhWithMathLibrary(50));
    }
    
    /**
     * Test for a large positive integer input
     */
    @Test
    public void largePositiveInteger() {
        String result = String.format("%.5f", f3.sinh(9787));
        assertEquals(result, sinhWithMathLibrary(9787));
    }
    
    /**
     * Test for -1 input
     */
    @Test
    public void negativeOneInput() {
        String result = String.format("%.5f", f3.sinh(-1));
        assertEquals(result, sinhWithMathLibrary(-1));
    }
    
    /**
     * Test for a negative integer
     */
    @Test
    public void negativeInteger() {
        String result = String.format("%.5f", f3.sinh(-50));
        assertEquals(result, sinhWithMathLibrary(-50));
    }
    
    /**
     * Test for a Large negative integer
     */
    @Test
    public void largeNegative() {
        String result = String.format("%.5f", f3.sinh(-9787));
        assertEquals(result, sinhWithMathLibrary(-9787));
    }
    
    /**
     * Test for a normal floating number
     */
    @Test
    public void normalFloatingNumber() {
        String result = String.format("%.5f", f3.sinh(12.37382));
        assertEquals(result, sinhWithMathLibrary(12.37382));
    }
    
    /**
     * Test for a large floating number
     */
    @Test
    public void largeFloating() {
        String result = String.format("%.5f", f3.sinh(177728.6));
        assertEquals(result, sinhWithMathLibrary(177728.6));
    }
    
    /**
     * Test for a floating number close to zero
     */
    @Test
    public void closeToZero() {
        String result = String.format("%.5f", f3.sinh(0.000000000000001));
        assertEquals(result, sinhWithMathLibrary(0.000000000000001));
    }
    
    /**
     * Test for a floating number close to one
     */
    @Test
    public void closeToOne() {
        String result = String.format("%.5f", f3.sinh(0.999999999999999));
        assertEquals(result, sinhWithMathLibrary(0.999999999999999));
    }
    
    /**
     * Test for a floating number with an extremely long decimal part
     */
    @Test
    public void extremelyLongDecimalPart() {
        String result = String.format("%.5f", f3.sinh(0.373853666666666664473733844746453673));
        assertEquals(result, sinhWithMathLibrary(0.373853666666666664473733844746453673));
    }
    
    /**
     * Test for an extremely large positive input
     */
    @Test
    public void extremelyLargePositiveInput() {
        String result = String.format("%.5f", f3.sinh(9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.37));
        assertEquals(result, sinhWithMathLibrary(9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.37));
    }
    
    /**
     * Test for an extremely large negative input
     */
    @Test
    public void extremelyLargeNegativeInput() {
        String result = String.format("%.5f", f3.sinh(-9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.37));
        assertEquals(result, sinhWithMathLibrary(-9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.37));
    }
    
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal1() {
        String result = String.format("%.5f", f3.sinh(0.1));
        assertEquals(result, sinhWithMathLibrary(0.1));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal2() {
        String result = String.format("%.5f", f3.sinh(0.2));
        assertEquals(result, sinhWithMathLibrary(0.2));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal3A() {
        String result = String.format("%.5f", f3.sinh(0.3));
        assertEquals(result, sinhWithMathLibrary(0.3));
    }
    
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal4() {
        String result = String.format("%.5f", f3.sinh(0.4));
        assertEquals(result, sinhWithMathLibrary(0.4));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal5() {
        String result = String.format("%.5f", f3.sinh(0.5));
        assertEquals(result, sinhWithMathLibrary(0.5));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal6() {
        String result = String.format("%.5f", f3.sinh(0.6));
        assertEquals(result, sinhWithMathLibrary(0.6));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal7() {
        String result = String.format("%.5f", f3.sinh(0.7));
        assertEquals(result, sinhWithMathLibrary(0.7));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal8() {
        String result = String.format("%.5f", f3.sinh(0.8));
        assertEquals(result, sinhWithMathLibrary(0.8));
    }
    
    /**
     * Test for a floating number with a decimal part of only 1 digit
     */
    @Test
    public void singleDecimal9() {
        String result = String.format("%.5f", f3.sinh(0.9));
        assertEquals(result, sinhWithMathLibrary(0.9));
    }
    
}
