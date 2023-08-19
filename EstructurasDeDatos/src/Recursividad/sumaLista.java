package Recursividad;

public class sumaLista {
	
	public static int sumaElementos(int[] l ) throws EListaVacia {
		if (l == null || l.length == 0) {
			throw new EListaVacia();
		}
		return sumaElementos1(l, l.length-1);
	}
	
	public static int sumaElementos3(int[] l ) throws EListaVacia {
		if (l == null || l.length == 0) {
			throw new EListaVacia();
		}
		return sumaElementos2(l, 0);
	}

	//Suma de elementos del último al primero
	private static int sumaElementos1(int[] e, int n) {
		if(n == 0) {
			return e[0];
		}else {
			return e[n] + sumaElementos1(e, n-1);
		}
	}
	
	//Suma de elementos del primero al último
	private static int sumaElementos2(int[] e, int n) {
		if(n == e.length-1) {
			return e[e.length-1];
		}else {
			return e[n] + sumaElementos2(e, n+1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] e = {11,8,2,5,10};
		try {
			System.out.println(sumaElementos(e));
			System.out.println(sumaElementos3(e));

		} catch (EListaVacia e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

	}

}
