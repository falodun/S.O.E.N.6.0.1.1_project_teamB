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
		double x = s.nextDouble();
		double xClone = x;

		boolean isNegative = x < 0;
		if(x == 0) {
			printResult(a, b, x, a);
		}
		else if(x == 1) {
			printResult(a, b, x, a*b);
		}
		else{
			if(isNegative) {
				x *= -1;
			}
			double result = a;
			if(x >= 1) {
				double[] exponential = doExponential(b, x);
				result *= !isNegative ? exponential[0] : 1 / exponential[0];
				x = exponential[1];
			}
			if(x>0 && x<1) {
				String xString = String.format("%.5f", x);
				x = Double.parseDouble(xString);
				double[] xFrac = getFraction(x);
				double expDeno = root(b, xFrac[1]);
				result *= !isNegative ? doExponential(expDeno, xFrac[0]*xFrac[1])[0] : 1 / doExponential(expDeno, xFrac[0]*xFrac[1])[0];
			}
			printResult(a, b, xClone, result);
		}
		s.close();
	}
	
	public static double[] doExponential(double b, double x) {
		double result = 1;
		while(x>0) 
		{
			result*= b;
			x--;
			if(x<1){
				break;
			}
		}
		double[] ret = {result, x};
		return ret;
	}
	
	public static boolean isInteger(double num) {
		return num % 1 == 0;
	}
	
	public static double[] getFraction(double num) {
		double numerator = num;
		double denominator = 1;
		while(!isInteger(numerator*denominator)) 
		{
			denominator++;
		}
		double[] ret = {numerator, denominator};
		return ret;
	}
	
	public static void printResult(double a, double b, double x, double result) {
		System.out.printf("f(x) = (%.3f)(%.3f)^(%.3f) = %.5f", a,b,x,result);
	}
	
	public static double root(double number, double root) {
		double percision = 1;
		double closestRoot = findClosestRootWithPercision(number, root, 0, percision);
		while(number < doExponential(closestRoot, root)[0] && percision > 0.0000000000001) 
		{
			closestRoot -= percision;
			percision *= 0.1;
			closestRoot = findClosestRootWithPercision(number, root, closestRoot, percision);
		}
//		System.out.println(root + " root of " + number + " is = " + closestRoot);
		return closestRoot;
	}

	public static double findClosestRootWithPercision(double number, double root, double closestRoot, double percision) {
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
