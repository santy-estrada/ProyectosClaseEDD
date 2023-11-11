package Final2023;

import java.util.*;

public class PreH {
    //COMPLETE
    public static int calcularAlturaPre(int[] preorden) {
        return altura(preorden, 0, preorden.length-1);
    }
    
  private static int altura(int[] preorden, int l, int r) {
    	
    	int izq = 0;
    	int der = 0;
    	
    	if(l > r) {
    		return 0;
    	}
    	
    	int root = preorden[l];
    	int aux = root-1;
    	int mid = l;
    	l++;
    	
    	while(mid < r && aux < root) {
    		mid++;
    		aux = preorden[mid];
    	}
    	
    	izq = 1 +altura(preorden, l, mid-1);
    	if(mid != r) {
        	der = 1 + altura(preorden, mid, r);
    	}else if(preorden[r] != root){
    		der+= 1;
    	}
    
    	return Math.max(izq, der);
    }

     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        String[] lineSplit=line.split(",");
        in.close();
        int[] preorden=new int[lineSplit.length];
        for(int i=0;i<lineSplit.length;i++)
            preorden[i]=Integer.parseInt(lineSplit[i]);
        int altura = calcularAlturaPre(preorden)-1;
        System.out.println("Altura: " + altura);
     }

}
