import java.util.Scanner;

public class F5 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("You have choosen F5: f(x) = AB^x");
		System.out.println("Please enter A");
		double a = s.nextDouble();
		System.out.println("Please enter B");
		double b = s.nextDouble();
		System.out.println("Please enter x");
//		String xString = s.nextLine();
//		String xInt = xString.substring(0, xString.indexOf("."));
		s.nextLine();
		String xString = s.nextLine();
//		Float x1 = s.nextFloat();
		xString.trim();
		int x2 = Integer.parseInt(xString.substring(0, xString.indexOf(".")));
		int x3 = Integer.parseInt(xString.substring(xString.indexOf(".") + 1));
		
		System.out.println(x2 + "   ---   " + x3);
		Double x1 = Double.parseDouble(xString);
		
		double x = x1;
		boolean isNegative = x < 0;
		
		System.out.println(x);
		if(x == 0) {
			printResult(a, b, x1, a);
//			System.out.println(x);
		}
		else if(x == 1) {
			printResult(a, b, x1, a*b);
//			System.out.println(x);
		}
		else if(x>0 && x<1){
			System.out.println(x);
			double result = a;
//			double[] exponential = doExponential(b, !isNegative ? x : -1 * x);
//			result *= !isNegative ? exponential[0] : 1 / exponential[0];
//			System.out.println(result + "\n Something went wrong");
//			x = exponential[1];
			if(x>0 && x<1) 
			{
				double[] xInFractions = getFraction(Double.parseDouble("0." + x3));
				System.out.println(xInFractions[0]*xInFractions[1] + "/" + xInFractions[1]);
				x = 0;
				
				double exponentialForDenominator = squareRoot(b, xInFractions[1]);
				double[] exponentialForNumerator = doExponential(b, xInFractions[0]*xInFractions[1]);
				result *= exponentialForNumerator[0]/exponentialForDenominator;
				System.out.println(exponentialForNumerator[0] + "/" + exponentialForDenominator);
			}
			if(x==0) {
				printResult(a, b, x1, result);
			}
			else 
			{
				System.out.println("\n Something went wrong");
			}
		}
		else {
			System.out.println(x);
			double result = a;
			double[] exponential = doExponential(b, !isNegative ? x : -1 * x);
			result *= !isNegative ? exponential[0] : 1 / exponential[0];
			System.out.println(result + "\n Something went wrong");
			x = exponential[1];
			if(x>0 && x<1) 
			{
				double[] xInFractions = getFraction(Double.parseDouble("0." + x3));
				System.out.println(xInFractions[0]*xInFractions[1] + "/" + xInFractions[1]);
				x = 0;
				
				double exponentialForDenominator = squareRoot(b, xInFractions[1]);
				double[] exponentialForNumerator = doExponential(b, xInFractions[0]*xInFractions[1]);
				result *= exponentialForNumerator[0]/exponentialForDenominator;
				System.out.println(exponentialForNumerator[0] + "/" + exponentialForDenominator);
			}
			if(x==0) {
				printResult(a, b, x1, result);
			}
			else 
			{
				System.out.println("\n Something went wrong");
			}
		}
		s.close();
	}
	
	public static double[] doExponential(double b, double x) 
	{
		double result = 1;
		while(x>0) 
		{
			result*= b;
			x--;
			System.out.println(x);
			if(x<1){
				break;
			}
		}
		double[] ret = {result, x};
//		System.out.println(x);
		return ret;
	}
	
	public static boolean isInteger(double num) 
	{
		return num % 1 == 0;
	}
	
	public static double[] getFraction(double num) 
	{
		double numerator = num;
		double denominator = 1;
		while(!isInteger(numerator*denominator)) 
		{
			denominator++;
		}
		double[] ret = {numerator, denominator};
		System.out.println(num);
		System.out.println(denominator);
		System.out.println("true");
		return ret;
	}
	
	public static void printResult(double a, double b, double x, double result) 
	{
		System.out.printf("f(x) = (%.2f)(%.2f)^(%.2f) = %.2f", a,b,x,result);
	}
	
	public static double squareRoot(double number, double root) {
		double temp;

		double sr = number / root;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / root;
		} while ((temp - sr) > 0.001 );

		return sr;
	    }
}
