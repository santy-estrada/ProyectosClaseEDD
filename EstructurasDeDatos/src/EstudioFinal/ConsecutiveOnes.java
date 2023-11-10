package EstudioFinal;

import java.util.*;

public class ConsecutiveOnes {
    
    public int[] consecutive(int[][] matriz) {
    	return contador(matriz, 0, 0, 0, new int[matriz.length]);
    }
    
    private int[] contador(int[][] matriz, int i, int j, int sec, int cant[]) {
    	if(j == matriz[0].length) {
    		if(i == matriz.length-1) {
    			return cant;
    		}
    		return contador(matriz, i+1, 0, 0, cant);
    	}
    	
    	if(matriz[i][j] == 1) {
    		sec++;
    	}if(matriz[i][j] != 1 || j == matriz[0].length-1) {
    		if(sec > 1) {
    			cant[i]++;
    		}
    		sec = 0;
    		
    	}
    	
    	return contador(matriz, i, j+1, sec, cant);
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
    /* 
     *    
4
5
0,0,1,0,0
1,1,0,1,1
0,1,1,1,1
0,0,1,1,0
     */
 
}