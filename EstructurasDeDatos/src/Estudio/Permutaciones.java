package Estudio;

import java.util.Arrays;
import java.util.Scanner;

public class Permutaciones {
    int[][] permutMatriz = new int [0][0];
    
    public void calcularCombinacion(int[] lista){
        permutaciones(lista, new int[0], 0);
    }
    
    private void permutaciones(int[] lista, int [] sol, int index) {
    	if(sol.length == lista.length) {
    		saveSol(sol);
    		return;
    	}
    	
    	for(int i: lista) {
    		if(valid(sol, i)) {
    			sol = Arrays.copyOf(sol, sol.length+1);
    			sol[index] = i;
    			permutaciones(lista, sol, index+1);
    			sol = Arrays.copyOf(sol, sol.length-1);
    		}
    	}
    }
    
    private boolean valid(int[] sol, int i) {
    	if(sol.length == 0) {
    		return true;
    	}
    	int index = 0;
    	while(index < sol.length && sol[index] != i) {
    		index++;
    	}
    	
    	return (index == sol.length)? true: false;
    }
    
    private void saveSol(int[] sol) {
    	permutMatriz = Arrays.copyOf(permutMatriz, permutMatriz.length+1);
    	int temp[] = new int[sol.length];
    	permutMatriz[permutMatriz.length-1] = temp;
    	System.arraycopy(sol, 0, permutMatriz[permutMatriz.length-1], 0, sol.length);
    }

      /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        String[] lineSplit=line.split(",");
        int[] l= new int[lineSplit.length];
        for (int i=0;i<lineSplit.length;i++)
            l[i]=Integer.parseInt(lineSplit[i]);    
        Permutaciones p=new Permutaciones();
        p.calcularCombinacion(l);
        for (int i=0;i<p.permutMatriz.length;i++){
			for (int j=0;j<p.permutMatriz[i].length;j++) {
				if (j!=0)
					System.out.print(",");
				System.out.print(p.permutMatriz[i][j]);
			}				
			System.out.println();
		}        

    }

}
