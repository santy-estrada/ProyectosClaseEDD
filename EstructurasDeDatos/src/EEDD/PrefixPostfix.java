package EEDD;

import java.util.Stack;

public class PrefixPostfix {
	private static int orden(String s) {
		switch (s) {
		case "+":
		case "-":
			return 1;
			
		case "/":
		case "*":
		case "%":
			return 2;
			
		case "^":
			return 3;
		}
		
		return 0;
	}
	
	public static String inToPos(String s) {
		String op = "+-*/^%()";
		String pos = new String();
		String aux;
		int indexI = 0;
		int indexF = 0;
		Stack<String> operators= new Stack<String>();
		//Toma todo lo que esté antes de un paréntesis
		while(indexF < s.length()) {
			while(indexF < s.length() && s.charAt(indexF) != ' ') {
				indexF++;
			}
			aux = s.substring(indexI, indexF);
			indexF++;
			indexI = indexF;
			//Si no es un operador se añade
			if(op.indexOf(aux) == -1) {
				if(pos.length() != 0) {
					pos = pos + " " + aux;
				}else {
					pos = pos + aux;
				}
				
			//Si es un paréntesis que abre se pone en el stack
			}else if(aux.equals("(")) {
				operators.push(aux);
			//Si es un paréntesis que cierra se sacan los elementos del stack hasta que abra
			}else if(aux.equals(")")){
				while(!operators.isEmpty() && !operators.peek().equals("(")) {
					pos = pos + " " + operators.pop(); 
				}
				operators.pop();
			//Si es un operador
			}else if(op.indexOf(aux) != -1){
				//Añadir si el operador es de menor o mismo rango que el último puesto en el stack
				while(!operators.isEmpty() && orden(aux) <= orden(operators.peek())) {
					pos = pos + " " + operators.pop();
				}
				//Meter al stack el operador analizado
				operators.push(aux);
			}
		}
		
		//Sacar los últimos
		while(!operators.isEmpty()) {
			pos = pos + " " + operators.pop();
		}
		
		return pos;
	}
	
	public static double evalPostfix(String s) {
		Stack <Double> postfix = new Stack<Double>();
		Double aux = null;
		int indexI = 0;
		int indexF = 0;
		String aux2;
		
		while(indexF < s.length()) {
			//Toma todo lo que esté antes de un paréntesis
			while(indexF < s.length() && s.charAt(indexF) != ' ') {
				indexF++;
			}
			aux2 = s.substring(indexI, indexF);
			//Casos de operaciones
			switch (aux2) {
			case "+":
				aux = postfix.pop() + postfix.pop();
				break;
			case "-":
				aux = postfix.pop();
				aux = postfix.pop() - aux;
				break;
			case "/":
				aux = postfix.pop();
				aux = postfix.pop()/aux;;
				break;
			case "*":
				aux = postfix.pop() * postfix.pop();
				break;
			case "%":
				aux = postfix.pop();
				aux = postfix.pop() % aux;
				break;
			case "^":
				aux = postfix.pop();
				aux = Math.pow(postfix.pop(), aux);
				break;
			}
			//Si no fue ninguna operación
			if(aux == null) {
				//Se trata de un número
				postfix.push(Double.parseDouble(String.valueOf(aux2)));
			}else{
				postfix.push(aux);
				aux = null;
			}
			
			indexF++;
			indexI = indexF;
			
		}
		
		return postfix.pop();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(evalPostfix("4 5 6 * 3 / +"));
		System.out.println(inToPos("( 5 * 6 ) - 10"));
		System.out.println(inToPos("a + b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
	}

}
