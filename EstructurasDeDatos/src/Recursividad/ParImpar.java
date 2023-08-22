package Recursividad;

public class ParImpar {
	
	public static boolean impar(int n) {
		if(n==0) {
			return false;
		}else {
			return par(n-1);
		}
	}
	
	public static boolean par(int n) {
		if(n == 0) {
			return true;
		}else {
			return impar(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(par(8));
		System.out.println(impar(8));
		System.out.println("--------------");
		System.out.println(par(9));
		System.out.println(impar(9));
	}

}
