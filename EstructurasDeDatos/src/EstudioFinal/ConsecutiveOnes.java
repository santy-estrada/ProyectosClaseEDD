package EstudioFinal;

import java.util.*;

public class ConsecutiveOnes {
    
    public int[] consecutive(int[][] matriz) {
        // Complete el código
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