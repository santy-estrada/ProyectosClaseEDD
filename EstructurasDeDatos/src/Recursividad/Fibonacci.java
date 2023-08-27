package Recursividad;

import java.math.BigInteger;

public class Fibonacci {

	public static long fibonacciR(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fibonacciR(n-1)+fibonacciR(n-2);
	}
	
	public static long fibonacciF(int n) {
		long n0 = 0;
		long n1 = 1;
		for(int i = 1; i <= n; i++) {
			n1 += n0;
			n0 = n1 - n0;
		}
		
		return n0;
	}
	
	public static long fibonacciFast(long n) throws EListaVacia {
		if(n < 0) {
			throw new EListaVacia();
		}
		
		int actual = (n==0)? 0:1;

		return fibonacciBueno(n, 0, actual);
		//Pasa primer valor como 0 y segundo como 1 por definición matemática
	}
	
	private static long fibonacciBueno(long n, long anterior, long actual) {
		if (n <= 1) {
			return actual;	//devuelve el actual si se llega al 1
			//Este caso será el de parada excepto cuando el primer n sea 0
		}	
		
		//El próximo anterior es el actual y el próximo actual es la suma de anterior y actual
		return fibonacciBueno(n-1, actual, anterior+actual);
		//Se repite el ciclo pasando n-1
		
	}
	
	public static BigInteger fibonacciFast3 (int n) {
		int actual = (n ==0)? 0:1;
		
		return fibonacciR3(n, new BigInteger("0"), new BigInteger(Integer.toString(actual)));
	}
	
	private static BigInteger fibonacciR3(int n, BigInteger anterior, BigInteger  actual) {
		if(n <= 1) {
			return actual;
		}
		//Anterior es el actual y actual es anterior más actual
		return fibonacciR3(n-1, actual, new BigInteger(actual.toString()).add(anterior));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1, t2;
		
		t1 = System.currentTimeMillis();
		System.out.println(fibonacciR(45));
		t2 = System.currentTimeMillis();
		System.out.println("Tiempo redundant: " + (t2-t1));
		
		t1 = System.currentTimeMillis();
		System.out.println(fibonacciF(45));
		t2 = System.currentTimeMillis();
		System.out.println("Tiempo for: " + (t2-t1));
		
		try {
			t1 = System.currentTimeMillis();
			System.out.println(fibonacciFast(45));
			t2 = System.currentTimeMillis();
			System.out.println("Tiempo recursividad r: " + (t2-t1));
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1 = System.currentTimeMillis();
		System.out.println(fibonacciFast3(500));
		t2 = System.currentTimeMillis();
		System.out.println("Tiempo BigInteger: " + (t2-t1));
	}

}
