package Estudio;

import java.util.*;

public class ConstruccionFrases_Backtracking {
	public static String permutaciones [] = new String [0];
	
	public static void printPerms() {
		for(String s: permutaciones) {
			System.out.println(s);
		}
	}
        
    public void caracteresPermutados(String sentence){
    	int pos[] = new int [sentence.length()];
    	for(int i = 0; i < sentence.length(); i++) {
    		pos[i] = i;
    	}
        permutacion(orden(sentence), new int[0], pos);
        printPerms();
        
    }
    
    private void permutacion(String sentence, int[] perm, int[] pos) {
    	if(perm.length == sentence.length()) {
    		saveString(posToString(perm, sentence));
    		return;
    	}

    	for(int i = 0; i < sentence.length(); i++) {
    		if(valid(perm, i, sentence)) {
    			perm = Arrays.copyOf(perm, perm.length+1);
    			perm[perm.length-1] = i;
    			permutacion(sentence, perm, pos);
    			perm = Arrays.copyOf(perm, perm.length-1);
    		}
    	}
   
    	
    }
    
    private static boolean checkRepetidos(String s) {
    	int i = 0;
    	while(i < permutaciones.length && !s.equals(permutaciones[i])) {
    		i++;
    	}
    	
    	return (i == permutaciones.length)? true: false;
    }
    
    private static void saveString(String s) {
    	if(checkRepetidos (s)) {
    		permutaciones = Arrays.copyOf(permutaciones, permutaciones.length+1);
        	permutaciones[permutaciones.length-1] = s;
    	}
    }
    
    private String posToString(int[] pos, String sentence) {
    	String s = new String();
    	for(int i: pos) {
    		s = s + sentence.charAt(i);
    	}
    	
    	return s;
    }
    
    private boolean valid(int[] sol, int p, String sentence) {
    	if(sol.length == 0) {
    		return true;
    	}else {
    		
    	}
    	
    	int index = 0;
    	while(index < sol.length && sol[index] != p) {
    		index++;
    	}
    	/*
    	if(index < sentence.length() && sentence.charAt(index) == sentence.charAt(index+1)) {
    		return false;
    	}*/
    	
    	return (index == sol.length)? true: false;
    }
    
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