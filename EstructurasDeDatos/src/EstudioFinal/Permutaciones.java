package EstudioFinal;

import java.util.Arrays;
import java.util.Scanner;

public class Permutaciones {
    int[][] permutMatriz = new int [0][0];
    
    public void calcularCombinacion(int[] lista){
        permutaciones(lista, 0, new int[lista.length]);
    }
    
    private void permutaciones(int[] lista, int pos, int[] sol) {
    	if(sol[lista.length-1] != 0) {
    		save(sol);
    		return;
    	}
    	
    	for(int i: lista) {
    		if(valid(sol, i)) {
    			sol[pos] = i;
    			permutaciones(lista, pos+1, sol);
    			sol[pos] = 0;
    		}
    	}
    }
    
    private boolean valid(int[] perm, int i) {
    	if(perm.length == 0) {
    		return true;
    	}
    	int index = 0;
    	while(index < perm.length && perm[index] != i) {
    		index++;
    	}
    	
    	return index == perm.length;
    }
    
    private void save(int[] sol) {
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
