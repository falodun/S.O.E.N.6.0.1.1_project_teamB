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
		
		System.out.printf("f(x) = (%.2f)(%.2f)^(%.2f) = ", a,b,x);
		
		if(x == 0) System.out.printf("%.2f\n", a);
		else if(x == 1) System.out.printf("%.2f\n", a*b);
		else {
			double result = a;
			while(x>0) 
			{
				result*= b;
				x--;
			}
			System.out.printf("%.2f\n", result);
		}
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
		return ret;
	}
}
