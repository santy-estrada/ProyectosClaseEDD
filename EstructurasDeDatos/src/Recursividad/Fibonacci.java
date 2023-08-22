package Recursividad;

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
	
	public static long fibonacciFast(int n) throws EListaVacia {
		if(n < 0) {
			throw new EListaVacia();
		}

		return fibonacciBueno(n, 0, 1);
		//Pasa primer valor como 0 y segundo como 1 por definición matemática
	}
	
	private static long fibonacciBueno(int n, int anterior, int actual) {
		if (n == 1) {
			return actual;	//devuelve el actual si se llega al 1
			//Este caso será el de parada excepto cuando el primer n sea 0
		}
		if(n == 0) {
			return anterior; //Caso de parada cuando n es 0
		}		
	
		actual += anterior;	//Fibonacci actual es sí mismo más el fibonacci anterior
		anterior = actual - anterior;
		//Fibonacci anterior es el nuevo actual menos sí mismo
		
		return fibonacciBueno(n-1, anterior, actual);
		//Se repite el ciclo pasando n-1
		
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
	}

}
