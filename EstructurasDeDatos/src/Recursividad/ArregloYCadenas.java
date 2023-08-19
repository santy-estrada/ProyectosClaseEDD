package Recursividad;

public class ArregloYCadenas {
	
	private static int maxEnArrays(int a[], int max, int n) {
		if(a[n] > max) {	//Siempre veerifica si el valor actual es mayor al m�ximo
			max = a[n];
		}
		
		if(n == a.length-1) {	//Condici�n de parada: ya est� en la �ltima posici�n
			
			return max;
		}else {
			
			return maxEnArrays(a, max, n+1);	//Pasa el arreglo con el m�ximo y la siguiente posici�n
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
		if(a == b || b < a) {	//Si est�n en la misma posici�n o si a ya sobrepas� b
			return s;
		}else {
			char aux = s.charAt(a);	//Caracter en la posici�n a
			s.setCharAt(a, s.charAt(b));	//Posicion a se convierte en el caracter de la posici�n b
			s.setCharAt(b, aux);			//Posicion b se convierte en el antiguo a
			return cambio(s, a+1 , b-1);	//Se env�a la misma cadena con a hacia adelante y b hacia atr�s
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
			return true;	//Si lleg� hasta ac�, es pal�ndromo
		}else {
			if(s.charAt(b) != s.charAt(a)) {
				return false;	//Si son diferentes, no es pal�ndromo por definici�n
			}else {
				return palindromo(s, a+1 , b-1);	//Se pasa string y posiciones acercadas
			}
		}
	}
	
	
	//Recibe string y dice si es pal�ndromo o no
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
			if(checkPalindromo(s)) {System.out.println(s + ": es pal�ndromo");}
			else {System.out.println(s + ": no es pal�ndromo");}
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}

	}

}
