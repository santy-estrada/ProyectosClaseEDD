package EEDD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodificarConPilasColas {
	
	public static String codificar(String s) {
		Queue<Character> aux1 = strToQ(s);
		Stack<Character> aux2 = invertirConsonantes(aux1);
		String mensaje = stackToString(aux2);

		
		return mensaje;
	}
	
	private static Queue<Character> strToQ(String s){
		Queue<Character> q = new LinkedList <Character>();
		for(int i = 0; i < s.length(); i++) {
			q.add(s.charAt(i));
		}
		
		return q;
	}
	/*
	 * 	private static Stack<Character> invNoVocales(Queue<Character> c) {
		String vowels = "AEIOUaeiou";
		Stack<Character> s = new Stack<Character>();	//Auxiliar
		Stack<Character> sool = new Stack<Character>();

		while (!c.isEmpty()) {
			while (!c.isEmpty() && !vowels.contains(String.valueOf(c.peek()))) 
				s.push(c.poll());
			while(!s.isEmpty())
				sool.push(s.pop());
			if(!c.isEmpty()) 
				sool.push(c.poll());
		}
		return sool;
	}

	 */
	
	private static Stack<Character> invertirConsonantes (Queue<Character> q){
		String vocales = "aeiouAEIOU";
		Stack<Character> s = new Stack<Character>();
		Stack<Character> sol = new Stack <Character>();
		
		while(!q.isEmpty()) {
			//True o false de si está en las vocales. Peek() permite ver en colas y pilas
			if(!vocales.contains(String.valueOf(q.peek()))) {
				//Sacar elemento de una cola para meterlo en una pila
				s.push(q.poll());
			}else {
				while(!s.isEmpty()) {
					//Sacar elemento de pila para meterlo en otra pila
					sol.push(s.pop());
				}
				sol.push(q.poll());
			}
		}
		//Vacear lo que queda en el stack auxiliar
		while(!s.isEmpty()) {
			sol.push(s.pop());
		}
		
		return sol;
	}
	
	private static String stackToString (Stack<Character> st) {
		String mensaje = new String();
		while(!st.empty()) {
			mensaje = mensaje + st.pop();
		}
		return mensaje;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(codificar("S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE. VENTERGU"));
	}

}
