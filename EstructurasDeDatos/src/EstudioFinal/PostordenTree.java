package EstudioFinal;

import java.util.*;

public class PostordenTree {
    
    public ArrayList<Integer> fromPreordenToPostorden(Integer[] preorden) {
    	
    	return(fromPreordenToPostorden(preorden, 0, preorden.length-1));
    	
    	
    }
    
    private ArrayList<Integer> fromPreordenToPostorden(Integer[] preorden, int l, int r) {
    	
    	ArrayList<Integer> izq = new ArrayList<Integer>();
    	ArrayList<Integer> der = new ArrayList<Integer>();
    	
    	if(l > r) {
    		return null;
    	}
    	
    	Integer root = preorden[l];
    	Integer aux = root-1;
    	int mid = l;
    	l++;
    	
    	while(mid < r && aux < root) {
    		mid++;
    		aux = preorden[mid];
    	}
    	
    	izq = fromPreordenToPostorden(preorden, l, mid-1);
    	if(mid != r) {
    		der = fromPreordenToPostorden(preorden, mid, r);
    	}else if(preorden[r] != root){
    		der.add(preorden[r]);
    	}
    	ArrayList<Integer> sol = new ArrayList<Integer>();
    	if(izq != null) {
    		sol.addAll(izq);
    	}
    	if(der != null) {
    		sol.addAll(der);
    	}
    	sol.add(root);
    	
    	return sol;
    }
    

    
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] preordenS=line.split(",");
        Integer[] preorden=new Integer[preordenS.length];
        for (int i=0;i<preordenS.length;i++)
            preorden[i]=Integer.parseInt(preordenS[i]);
        PostordenTree p=new PostordenTree();
        //p.preordenpostorden(preorden, 0, preorden.length);
        ArrayList<Integer> resultado=p.fromPreordenToPostorden(preorden);
        for (Integer s:resultado)
            System.out.println(s);
        in.close();
    }

}