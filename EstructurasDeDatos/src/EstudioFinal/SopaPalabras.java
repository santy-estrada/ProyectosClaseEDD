package EstudioFinal;
import java.util.*;


public class SopaPalabras {
    
    // Complete    
    public ArrayList<String> todasPalabras(char[][] sopa) {
       ArrayList<String> id = recorridoID(sopa, 0, 0, new ArrayList<String>(), new String());
       ArrayList<String> di = recorridoDI(sopa, sopa.length-1, sopa[0].length-1, new ArrayList<String>(), new String());
       ArrayList<String> ab = recorridoAB(sopa, 0, 0, new ArrayList<String>(), new String());
       ArrayList<String> ba = recorridoBA(sopa, sopa.length-1, sopa[0].length-1, new ArrayList<String>(), new String());

       id.addAll(di);
       id.addAll(ab);
       id.addAll(ba);
       
       return id;
    }
        
    // Complete
    public PriorityQueue<String> palabrasContenidas(char[][] sopa, String[] palabras){
        ArrayList<String> cadenasFilD = inverso(recorridoFilas(sopa, 0, 0, new LinkedList <String>(), new String()));
        ArrayList<String> cadenasFilI = new ArrayList<String>(recorridoFilas(sopa, 0, 0, new LinkedList <String>(), new String()));
        ArrayList<String> cadenasColA = inverso(recorridoCol(sopa,sopa.length-1, sopa[0].length-1, new LinkedList <String>(), new String()));
        ArrayList<String> cadenasColB = new ArrayList<String>(recorridoCol(sopa,sopa.length-1, sopa[0].length-1, new LinkedList <String>(), new String()));
        
        cadenasFilD.addAll(cadenasFilI);
        cadenasFilD.addAll(cadenasColA);
        cadenasFilD.addAll(cadenasColB);

		PriorityQueue<String> pq = new PriorityQueue<String>();
		for(String s: palabras) {
			int index = 0;
			while(index < cadenasFilD.size()) {
				if(cadenasFilD.get(index).contains(s)) {
					pq.add(s);
				}
				index++;
			}
			
		}
		
		return pq;

    }
    
    private ArrayList<String> recorridoID(char[][] sopa, int i, int j, ArrayList<String> palabras, String current) {
    	if(j == sopa[0].length) {
			if(i == sopa.length-1) {
				return palabras;
			}
			return recorridoID(sopa, i+1, 0, palabras, new String());
		}
		current += sopa[i][j];
		palabras.add(current);
		return recorridoID(sopa, i, j+1, palabras, current);
    }
    
    private ArrayList<String> recorridoDI(char[][] sopa, int i, int j, ArrayList<String> palabras, String current) {
    	if(j == -1) {
			if(i == 0) {
				return palabras;
			}
			return recorridoDI(sopa, i-1, sopa[0].length-1, palabras, new String());
		}
		current += sopa[i][j];
		palabras.add(current);
		return recorridoDI(sopa, i, j-1, palabras, current);
    }
    
    private ArrayList<String> recorridoAB(char[][] sopa, int i, int j, ArrayList<String> palabras, String current) {
    	if(i == sopa.length) {
			if(j == sopa[0].length-1) {
				return palabras;
			}
			return recorridoAB(sopa, 0, j+1, palabras, new String());
		}
		current += sopa[i][j];
		palabras.add(current);
		return recorridoAB(sopa, i+1, j, palabras, current);
    }
    
    private ArrayList<String> recorridoBA(char[][] sopa, int i, int j, ArrayList<String> palabras, String current) {
    	if(i == -1) {
			if(j == 0) {
				return palabras;
			}
			return recorridoBA(sopa, sopa.length-1, j-1, palabras, new String());
		}
		current += sopa[i][j];
		palabras.add(current);
		return recorridoBA(sopa, i-1, j, palabras, current);
    }
    
    private Queue<String> recorridoFilas(char[][] sopa, int i, int j, Queue<String> palabras, String current) {
    	if(j == sopa[0].length) {
			if(i == sopa.length-1) {
				palabras.add(current);
				return palabras;
			}
			palabras.add(current);
			return recorridoFilas(sopa, i+1, 0, palabras, new String());
		}
		current += sopa[i][j];
		return recorridoFilas(sopa, i, j+1, palabras, current);
    }
    
    private Queue<String> recorridoCol(char[][] sopa, int i, int j, Queue<String> palabras, String current) {
    	if(i == -1) {
			if(j == 0) {
				palabras.add(current);
				return palabras;
			}
			palabras.add(current);
			return recorridoCol(sopa, sopa.length-1, j-1, palabras, new String());
		}
		current += sopa[i][j];
		return recorridoCol(sopa, i-1, j, palabras, current);
    }
    
    private ArrayList<String> inverso(Queue<String> der){
    	Stack<String> inv = new Stack<String>();
    	ArrayList<String> s = new ArrayList<String>();
    	while(!der.isEmpty()) {
    		inv.push(der.poll());
    	}
    	while(!inv.isEmpty()) {
    		s.add(inv.pop());
    	}
    	
    	return s;
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] palabras=line.split(",");
        ArrayList<String> s=new ArrayList<String>();
        while ((line=in.nextLine()).compareTo("")!=0)
            s.add(line);
        char[][] sopa= new char[s.size()][];
        for (int i=0;i<s.size();i++)
            sopa[i]=s.get(i).toCharArray();
        SopaPalabras sopaP=new SopaPalabras();
        PriorityQueue<String> p=sopaP.palabrasContenidas(sopa,palabras);
        while (!p.isEmpty())
            System.out.println(p.poll());
        in.close();

    }

}
