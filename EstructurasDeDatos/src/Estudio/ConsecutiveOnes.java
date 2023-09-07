package Estudio;

import java.util.*;

public class ConsecutiveOnes {
    
    public int[] consecutive(int[][] matriz) {
        return cant(matriz, new int [matriz.length], 0,0, 0);
    }
    
    private int[] cant(int[][] m, int[] cants, int i, int j, int aux) {
    	if(i == m[0].length) {
    		if(aux > 1) {
    			cants[j]++;
    		}
    		if(j == m.length-1) {
    			return cants;
    		}
    		
    		return cant(m, cants, 0, j+1, 0);
    	}
    	
    	if(m[j][i] == 1) {
    		aux++;
    		
    	}else {
    		if(aux > 1) {
    			cants[j]++;
    		}
    		aux = 0;
    	}
    	
    	return cant(m, cants, i+1, j, aux);
    	
    }
    
    // Haga las funciones que necesite
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row= Integer.parseInt(in.nextLine());
        int col= Integer.parseInt(in.nextLine());
        int[][] matriz=new int[row][col];
        for (int i=0;i<row;i++) {
            String s[]= in.nextLine().split(",");
            for(int j =0 ;j < s.length;j++)
                matriz[i][j]= Integer.parseInt(s[j]);
        }
        ConsecutiveOnes co=new ConsecutiveOnes();
        int[] consecutive=co.consecutive(matriz);
        for (int c:consecutive)
            System.out.println(c);          
        in.close();
    }

}