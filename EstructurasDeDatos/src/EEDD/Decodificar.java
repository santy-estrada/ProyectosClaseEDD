package EEDD;

import java.util.Stack;


public class Decodificar {
	public static String decodificar(String s) {
		Character[] chars = charToCharacter(s.toCharArray());
		String mensaje1 = invert(generateStack(chars));	//Se inviritió todo
		
		String mensaje = pedacitos(mensaje1);
		
		return mensaje;
	}
	
	public static String codificar(String s) {
		String mensaje1 = pedacitos(s);
		
		Character[] chars = charToCharacter(mensaje1.toCharArray());
		
		String mensaje = invert(generateStack(chars));	//Se inviritió todo
		
		
		return mensaje;
	}
	
	//Invertir cada subcadena de consonantes
	private static String pedacitos(String mensaje) {
		String aux = new String();
		String res = new String();
		String vocales = "aeiouAEIOU";
		int indexI = 0;
		int indexF = 0;
		while(indexF < mensaje.length()) {
			//Si el caracter es una vocal
			if(vocales.indexOf(mensaje.charAt(indexF)) != -1) {
				//Toma los caracteres desde la última vocal hasta este caracter
				aux = mensaje.substring(indexI, indexF);
				//Cree el arreglo de chars auxiliar
				Character[] chars = charToCharacter(aux.toCharArray());
				//Se concatena la respuesta y se adicional la vocal
				res = res + invert(generateStack(chars)) + mensaje.charAt(indexF);
				//Se pone el próximo indice de inicio como el caracter después de la vocal
				indexI = indexF+1;
			}
			
			indexF++;
		}
		
		//Si la última letra no fue una vocal
		if(res.length() < mensaje.length()) {
			//Tome todos los caracteres desde la última vocal
			aux = mensaje.substring(indexI);
			Character[] chars = charToCharacter(aux.toCharArray());
			//Concatenelos a la respuesta
			res = res + invert(generateStack(chars));
		}
		
		return res;
		
	}
	
	
	
	//Dado un arreglo de Character se da un Stack con esos elementos
	private static Stack<Character> generateStack(Character[] chars){
		Stack<Character> stc= new Stack<Character>();
		for(Character c: chars) {
			stc.push(c);
		}
		
		return stc;
	}
	
	
	//Dado un arreglo de char se da un arreglo de Character con esos elementos
	private static Character[] charToCharacter(char[] chars) {
		Character[] res = new Character[chars.length];
		for(int i = 0;  i < res.length; i++) {
			res[i] = chars[i];
		}
		
		return res;
	}
	
	/*
	 * Dado un Stack se da un String con los elementos, resultando en un string donde el primer
	 * caracter es el último del stack
	 */
	private static String invert (Stack<Character> mensaje){
		String str = new String();
		while(!mensaje.empty()) {
			str = str + mensaje.pop();
		}
		
		return str;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Mensaje entrante: S.ENTASERENTIR-EPIS HAMEBLOPR" + " Decodificación: " + decodificar("S.ENTASERENTIR-EPIS HAMEBLOPR"));
		System.out.println();
		System.out.println("Mensaje entrante: S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE. VENTERGU" + " Decodificación: " + decodificar("S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE. VENTERGU"));
		System.out.println();
		System.out.println("Mensaje a enviar: PROBLEMAS HIPER-INTERESANTES. Salida: " + codificar("PROBLEMAS HIPER-INTERESANTES."));
		System.out.println();
		System.out.println("Mensaje a enviar: URGENTE. VEA SI CONSIGUE COMPRAR OTRAS TRES BOTELLAS. Salida: " + codificar("URGENTE. VEA SI CONSIGUE COMPRAR OTRAS TRES BOTELLAS."));


	}

}
