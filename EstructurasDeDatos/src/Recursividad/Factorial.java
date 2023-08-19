package Recursividad;

public class Factorial {
	
	public static long factorial(long n) {
		long f = 1;
		for(int i = 1; i <= n; i++) {
			f*=i;
		}
		
		return f;
	}
	
	public static long factorialRecursivo(long n) {
		if(n == 1 || n ==0) {
			return 1;
		}else {
			return n*factorialRecursivo(n-1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(factorial(5));
		System.out.println(factorialRecursivo(5));

	}

}
