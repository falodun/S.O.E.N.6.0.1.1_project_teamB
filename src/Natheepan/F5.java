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
//		s.nextLine();
//		String xString = s.nextLine();
		double x = s.nextDouble();
		double xCopy = x;
//		xString.trim();
//		int xWhole = Integer.parseInt(xString.substring(0, xString.indexOf(".")));
//		int xRemainder = Integer.parseInt(xString.substring(xString.indexOf(".") + 1));
		
//		System.out.println(x2 + "   ---   " + x3);
//		Double x1 = Double.parseDouble(xString);
		
//		double x = x1;
		boolean isNegative = x < 0;
		
//		System.out.println(x);
		if(x == 0) {
			printResult(a, b, x, a);
//			System.out.println(x);
		}
		else if(x == 1) {
			printResult(a, b, x, a*b);
//			System.out.println(x);
		}
//		else if(x>0 && x<1){
////			System.out.println(x);
//			double result = a;
//			if(x>0 && x<1) 
//			{
//				double[] xInFractions = getFraction(Double.parseDouble("0." + xRemainder));
////				System.out.println(xInFractions[0]*xInFractions[1] + "/" + xInFractions[1]);
//				x = 0;
//				
//				double exponentialForDenominator = root(b, xInFractions[1]);
//				result *= doExponential(exponentialForDenominator, xInFractions[0]*xInFractions[1])[0];
//			}
//			printResult(a, b, x1, result);
//		}
		else{
//			System.out.println(x);
			if(isNegative) {
				x *= -1;
			}
			double result = a;
			if(x >= 1) 
			{
				double[] exponential = doExponential(b, x);
				result *= !isNegative ? exponential[0] : 1 / exponential[0];
//				System.out.println(x);
				x = exponential[1];
//				System.out.println(x);
			}
			if(x>0 && x<1) 
			{
				String xString = String.format("%.5f", x);
				x = Double.parseDouble(xString);
				double[] xInFractions = getFraction(x);
//				System.out.println(xInFractions[0]*xInFractions[1] + "/" + xInFractions[1]);
				
				double exponentialForDenominator = root(b, xInFractions[1]);
				result *= !isNegative ? doExponential(exponentialForDenominator, xInFractions[0]*xInFractions[1])[0] : 1 / doExponential(exponentialForDenominator, xInFractions[0]*xInFractions[1])[0];
			}
			printResult(a, b, xCopy, result);
		}
//		else {
//			System.out.println(x);
//			double result = a;
//			double[] exponential = doExponential(b, !isNegative ? x : -1 * x);
//			result *= !isNegative ? exponential[0] : 1 / exponential[0];
//			System.out.println(result + "\n Something went wrong");
//			x = exponential[1];
//			if(x>0 && x<1) 
//			{
//				double[] xInFractions = getFraction(Double.parseDouble("0." + xRemainder));
//				System.out.println(xInFractions[0]*xInFractions[1] + "/" + xInFractions[1]);
//				x = 0;
//				
//				double exponentialForDenominator = root(b, xInFractions[1]);
//				double[] exponentialForNumerator = doExponential(b, xInFractions[0]*xInFractions[1]);
//				result *= exponentialForNumerator[0]/exponentialForDenominator;
//				System.out.println(exponentialForNumerator[0] + "/" + exponentialForDenominator);
//			}
//			if(x==0) {
//				printResult(a, b, x1, result);
//			}
//			else 
//			{
//				System.out.println("\n Something went wrong");
//			}
//		}
		s.close();
	}
	
	public static double[] doExponential(double b, double x) 
	{
		double result = 1;
		while(x>0) 
		{
			result*= b;
			x--;
//			System.out.println(x);
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
//		System.out.println(num);
//		System.out.println(denominator);
//		System.out.println("true");
		return ret;
	}
	
	public static void printResult(double a, double b, double x, double result) 
	{
		System.out.printf("f(x) = (%.2f)(%.2f)^(%.4f) = %.5f", a,b,x,result);
	}
	
	public static double root(double number, double root) {
		double percision = 1;
		double closestRoot = findClosestRootWithPercision(number, root, 0, percision);
		System.out.println(" findClosestRoot " + closestRoot);
		
		while(number < doExponential(closestRoot, root)[0] && percision > 0.0000000001) 
		{
			closestRoot -= percision;
			percision *= 0.1;
			closestRoot = findClosestRootWithPercision(number, root, closestRoot, percision);
		}
		System.out.println(root + " root of " + number + " is = " + closestRoot);
		return closestRoot;
	}

	
//	public static double root(double number, double root) {
//		double closestRoot = findClosestRootWithPercision(number, root, 0, 1);
//		System.out.println(" findClosestRoot " + closestRoot);
//		if(number < doExponential(closestRoot, root)[0]) 
//		{
//			closestRoot--;
//			closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.1);
//			if(number < doExponential(closestRoot, root)[0]) 
//			{
//				closestRoot -= 0.1;
//				closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.01);
//				if(number < doExponential(closestRoot, root)[0]) 
//				{
//					closestRoot -= 0.01;
//					closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.001);
//					if(number < doExponential(closestRoot, root)[0]) 
//					{
//						closestRoot -= 0.001;
//						closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.0001);
//						if(number < doExponential(closestRoot, root)[0]) 
//						{
//							closestRoot -= 0.0001;
//							closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.00001);
//							if(number < doExponential(closestRoot, root)[0]) 
//							{
//								closestRoot -= 0.00001;
//								closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.000001);
//								if(number < doExponential(closestRoot, root)[0]) 
//								{
//									closestRoot -= 0.000001;
//									closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.0000001);
//									if(number < doExponential(closestRoot, root)[0]) 
//									{
//										closestRoot -= 0.0000001;
//										closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.00000001);
//										if(number < doExponential(closestRoot, root)[0]) 
//										{
//											closestRoot -= 0.00000001;
//											closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.000000001);
//											if(number < doExponential(closestRoot, root)[0]) 
//											{
//												closestRoot -= 0.000000001;
//												closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.0000000001);
//												if(number < doExponential(closestRoot, root)[0]) 
//												{
//													closestRoot -= 0.0000000001;
//													closestRoot = findClosestRootWithPercision(number, root, closestRoot, 0.00000000001);
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//		System.out.println(root + " root of " + number + " is = " + closestRoot);
//		return closestRoot;
//	}
	
//	public static double findClosestRoot(double number, double root) 
//	{
//		double closestRoot = 1;
//		double[] temp = doExponential(closestRoot, root);
//		while(temp[0] < number) 
//		{
//			closestRoot++;
//			temp = doExponential(closestRoot, root);
//		}
//		return closestRoot;
//	}
	public static double findClosestRootWithPercision(double number, double root, double closestRoot, double percision) 
	{
		closestRoot += percision;
		double[] temp = doExponential(closestRoot, root);
		while(temp[0] < number) 
		{
			closestRoot += percision;
			temp = doExponential(closestRoot, root);
		}
		return closestRoot;
	}
}
