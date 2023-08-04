package TemaNuevo;

public class masString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Juanu";
		System.out.println(str.charAt(0));		//Posición del caracter
		System.out.println(str.indexOf("u"));	//Posición de la primera cadena
		System.out.println(str.lastIndexOf("u"));	//Posición de la última cadena
		
		System.out.println(str.substring(2));			//Output: lo que está desúés del índice
		System.out.println(str.substring(2,4));			//Output: entre ambos indices

		String str2 = "Janua";
		System.out.println(str.compareTo(str2));		//Si es mayor, devuelve num positivo
		System.out.println(str2.compareTo(str));		//Si es menor, devuelve num negativo
		System.out.println(str.compareTo(str));		//Si es igual, devuelve 0

	}

}
