package Recursividad;

public class ArregloYCadenas {
	
	private static int maxEnArrays(int a[], int max, int n) {
		if(a[n] > max) {	//Siempre veerifica si el valor actual es mayor al máximo
			max = a[n];
		}
		
		if(n == a.length-1) {	//Condición de parada: ya está en la última posición
			
			return max;
		}else {
			
			return maxEnArrays(a, max, n+1);	//Pasa el arreglo con el máximo y la siguiente posición
		}
	}
	//Toma un arreglo y devuelve el maximo
	public static int max(int[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
		int max = a[0];
		int n = 0;
		return maxEnArrays(a, max, n);
	}
	
	private static StringBuffer cambio(StringBuffer s, int a, int b) {
		if(a == b || b < a) {	//Si están en la misma posición o si a ya sobrepasó b
			return s;
		}else {
			char aux = s.charAt(a);	//Caracter en la posición a
			s.setCharAt(a, s.charAt(b));	//Posicion a se convierte en el caracter de la posición b
			s.setCharAt(b, aux);			//Posicion b se convierte en el antiguo a
			return cambio(s, a+1 , b-1);	//Se envía la misma cadena con a hacia adelante y b hacia atrás
		}
	}
	
	//Toma una cadena e invierte su orden
	public static String invertirCadena(String s) throws EListaVacia {
		if(s == null || s.length() == 0) {
			throw new EListaVacia();
		}
		int a = 0;
		int b = s.length()-1;
		
		StringBuffer aux = new StringBuffer(s);
		
		return cambio(aux, a, b).toString();
		
		
	}
	
	private static boolean palindromo(StringBuffer s, int a, int b) {
		if(a == b || a > b) {
			return true;	//Si llegó hasta acá, es palíndromo
		}else {
			if(s.charAt(b) != s.charAt(a)) {
				return false;	//Si son diferentes, no es palíndromo por definición
			}else {
				return palindromo(s, a+1 , b-1);	//Se pasa string y posiciones acercadas
			}
		}
	}
	
	
	//Recibe string y dice si es palíndromo o no
	public static boolean checkPalindromo(String s) throws EListaVacia {
		if(s == null || s.length() == 0) {
			throw new EListaVacia();
		}
		int a = 0;
		int b = s.length()-1;
		
		StringBuffer aux = new StringBuffer(s);
		
		return palindromo(aux, a, b);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {100,-98,-1,5};
		String s = "oso";
		try {
			System.out.println(max(a));
			System.out.println(invertirCadena(s));
			if(checkPalindromo(s)) {System.out.println(s + ": es palíndromo");}
			else {System.out.println(s + ": no es palíndromo");}
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}

	}

}
