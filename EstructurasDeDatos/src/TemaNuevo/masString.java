package TemaNuevo;

public class masString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Juanu";
		System.out.println(str.charAt(0));		//Posici�n del caracter
		System.out.println(str.indexOf("u"));	//Posici�n de la primera cadena
		System.out.println(str.lastIndexOf("u"));	//Posici�n de la �ltima cadena
		
		System.out.println(str.substring(2));			//Output: lo que est� des��s del �ndice
		System.out.println(str.substring(2,4));			//Output: entre ambos indices

		String str2 = "Janua";
		System.out.println(str.compareTo(str2));		//Si es mayor, devuelve num positivo
		System.out.println(str2.compareTo(str));		//Si es menor, devuelve num negativo
		System.out.println(str.compareTo(str));		//Si es igual, devuelve 0

	}

}
