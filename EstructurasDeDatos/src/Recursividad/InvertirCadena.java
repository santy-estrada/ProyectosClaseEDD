package Recursividad;

public class InvertirCadena {
	private static String invS(String cadena, int n) {
		if(n == 0) {
			return String.valueOf(cadena.charAt(n));
		}
		
		return String.valueOf(cadena.charAt(n)) + invS(cadena, n-1);
	}
	
	public static String invertir(String cadena) {
		if(cadena == "" || cadena == null) {
			return cadena;
		}
		return invS(cadena, cadena.length()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "casa";
		System.out.println(invertir(s));
	}

}
