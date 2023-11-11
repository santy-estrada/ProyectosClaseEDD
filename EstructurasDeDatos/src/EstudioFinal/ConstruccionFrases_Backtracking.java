package EstudioFinal;

import java.util.*;

public class ConstruccionFrases_Backtracking {
	//Variable que guarda resultados de permutaciones
	public static String permutaciones [] = new String [0];
	
	public static void printPerms() {
		for(String s: permutaciones) {
			System.out.println(s);
		}
	}
    
	//Primero convertir lo que se dé en términos de sus posiciones
    public void caracteresPermutados(String sentence){
    	int pos[] = new int [sentence.length()];
    	for(int i = 0; i < sentence.length(); i++) {
    		pos[i] = i;
    	}
        permutacion(orden(sentence), new int[0], pos);
        printPerms();
        
    }
    
    //Permutar posiciones 
    private void permutacion(String sentence, int[] perm, int[] pos) {
    	if(perm.length == sentence.length()) {
    		//Guardar como se deba
    		saveString(posToString(perm, sentence));
    		return;
    	}

    	//Recorrer todas las posibles posiciones
    	for(int i = 0; i < sentence.length(); i++) {
    		//Validar y permutar la posición correspondiente
    		if(valid(perm, i)) {
    			perm = Arrays.copyOf(perm, perm.length+1);
    			perm[perm.length-1] = i;
    			permutacion(sentence, perm, pos);
    			//Backtracking
    			perm = Arrays.copyOf(perm, perm.length-1);
    		}
    	}
   
    	
    }
    
    //Revisar que permutar posiciones no haya generado repetidos
    private static boolean checkRepetidos(String s) {
    	int i = 0;
    	while(i < permutaciones.length && !s.equals(permutaciones[i])) {
    		i++;
    	}
    	
    	return (i == permutaciones.length)? true: false;
    }
    
    //Guardar en la variable estática
    private static void saveString(String s) {
    	if(checkRepetidos (s)) {
    		permutaciones = Arrays.copyOf(permutaciones, permutaciones.length+1);
        	permutaciones[permutaciones.length-1] = s;
    	}
    }
    
    //Convertir posiciones en lo que sea necesario
    private String posToString(int[] pos, String sentence) {
    	String s = new String();
    	for(int i: pos) {
    		s = s + sentence.charAt(i);
    	}
    	
    	return s;
    }
    
    //Validar que no se ha puesto la posición
    private boolean valid(int[] sol, int p) {
    	if(sol.length == 0) {
    		return true;
    	}else {
    		
    	}
    	
    	int index = 0;
    	while(index < sol.length && sol[index] != p) {
    		index++;
    	}
    	
    	
    	return index == sol.length;
    }
    
    //Método para organizar... no es backtracking
    private String orden (String sentence) {
    	char a[] = sentence.toCharArray();
		//Bandera para indicar si hacer o no otra iteración
		boolean flag = true;
		int len = a.length-1;
		while(len > 0 && flag) {
			flag = false;	//Se marca de una que ya no van a haber más iteraciones
			for(int i = 0; i < len; i++) {
				if(a[i] > a[i+1]) {
					flag = true;	//Si hubo al menos un cambio, hace otra iteración
					char temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			len--;
		}
		return new String (a);
    }
    

    // Implemente las funciones que necesite

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        ConstruccionFrases_Backtracking create=new ConstruccionFrases_Backtracking();
        create.caracteresPermutados(line);
        in.close();
    }
}