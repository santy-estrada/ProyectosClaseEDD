package EEDD;

import java.util.Stack;

class notBalanced extends Exception{
	public notBalanced(String s) {
		super("Posicion(es) de error: " + s);
	}
}



public class ProblemaDeLosPar�ntesis {
	
	public static boolean balanceado(String s) {
		Stack<Character> p = new Stack<Character>();
		int i = 0;
		boolean flag = true;
		while(i < s.length() && flag) {
			if(s.charAt(i) == '(') {
				p.push(s.charAt(i));
			}else if(s.charAt(i) == ')'){
				if(p.isEmpty()) {
					flag = false;
				}else {
					p.pop();
				}
				
			}
			i++;
		}
		
		return (p.isEmpty() && flag)? true: false;
	}
	
	public static boolean findErrors(String s) throws notBalanced {
		//Stack con los par�ntesis abiertos
		Stack<Character> e = new Stack<Character>();
		//Stack con las posiciones de los errores
		Stack<Integer> pos = new Stack<Integer>();
		for(int i = 0; i < s.length(); i ++) {
			//Guarda posici�n y par�ntesis abierto
			if(s.charAt(i) == '(') {
				e.push(s.charAt(i));
				pos.push(i+1);
			}
			//Si va a eliminar y est� vac�o, a�ada el error. Si no est� vac�o, pop()
			if(s.charAt(i) == ')'){
				if(e.isEmpty()) {
					pos.push(i+1);
				}else {
					e.pop();
					pos.pop();
				}
			}
		}
		
		String errores = pos.toString();
		
		if(errores.compareTo("[]") == 0) {
			return true;
		}else {
			throw new notBalanced(errores);
		}

	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(balanceado("()("));
		try {
			System.out.println(findErrors("(a+b))((c*4)))(x"));
		} catch (notBalanced e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
	}

}
