package Recursividad;

public class Sumatoria {
	
	public static int sumatoriaRecursiva(int n) {
		if(n <= 0) {
			return 0;
		}else {
			return sumatoriaRecursiva(n-1)+n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumatoriaRecursiva(100));

	}
}
