package EstudioFinal;

import java.util.*;


class Persona implements Comparable<Persona>{
    private String nombre;
    private int edad;
    private char sexo;// F para femenino y M para masculino
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }    
    public char getSexo() {
        return sexo;
    }
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo=sexo;
    }
    @Override
    public String toString() {
        return  nombre + ", "+ edad ;
    }
    @Override
    public int compareTo(Persona arg0) {
        return (nombre.compareTo(arg0.getNombre())==0)?
                edad-arg0.getEdad():nombre.compareTo(arg0.getNombre());
    }
}

class ExceptionNodo extends Exception{
    public ExceptionNodo(String s){
        super(s);
    }
}

class NodoB<E extends Comparable<E>> {
    protected E llave;
    protected NodoB<E> hijoIzq;
    protected NodoB<E> hijoDer;
    protected NodoB<E> padre;

    public NodoB(E llave) {
        this.llave = llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }

    public NodoB(E llave, NodoB<E> hijoIzq, NodoB<E> hijoDer, NodoB<E> padre) {
        super();
        this.llave = llave;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.padre = padre;
    }

    public E getLlave() {
        return llave;
    }

    public void setLlave(E llave) {
        this.llave = llave;
    }

    public NodoB<E> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoB<E> hijoIzq) {
        if (hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }

    public NodoB<E> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoB<E> hijoDer) {
        if (hijoDer!=null){
            hijoDer.setPadre(this);
        }
        this.hijoDer = hijoDer;
    }

    public NodoB<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoB<E> padre) {
        this.padre = padre;
    }

    public int altura (NodoB<E> n){
        if (n== null) return -1;
        int altder = (n.getHijoDer() == null? 0:1 + altura (n.getHijoDer()));
        int altizq = (n.getHijoIzq() == null? 0:1 + altura (n.getHijoIzq()));
        return Math.max(altder,altizq);
    }
    
    public int altura(){
        return altura(this);
    }
    
    public int FE(){
        return altura(this.getHijoDer())-altura(this.getHijoIzq());
    }
    
    @Override
    public String toString() {
        String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
        String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
        return ((Comparable<E>)llave).toString()+ "("+HI+","+HD+")";
    }

}

class AVL<E extends Comparable<E>>{
    private NodoB<E> raiz;

    public NodoB<E> getRaiz() {
        return raiz;
    }
    public AVL() {
        raiz=null;
    }
    
    public void insert(NodoB<E> n) throws ExceptionNodo{
        raiz=insert(n, raiz);
    }
    
    protected NodoB<E> insert(NodoB<E> n, NodoB<E> r) throws ExceptionNodo {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insert(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insert(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodo("El nodo esta repetido");
        }
        return r;        
    }
    
    public void insertNodo(NodoB<E> n) throws ExceptionNodo {
        insert(n);
        balancear(n);
    }
    
        
    private void balancear(NodoB<E> n) {
        NodoB<E> desb = desbalance(n);
        if (desb!=null){
            NodoB<E> p= desb.getPadre();
            desb=(desb.FE()>0)?
                ((desb.getHijoDer().FE()>=0)? balanceSimpleIzq(desb):balanceDobleIzq(desb)):
                ((desb.getHijoIzq().FE()<=0)? desb=balanceSimpleDer(desb):balanceDobleDer(desb));
            if (p==null)
                 raiz=desb;
            else
                if(desb.getLlave().compareTo(p.getLlave())>0)
                    p.setHijoDer(desb);
                else
                    p.setHijoIzq(desb);
        }        
    }

    public NodoB<E> desbalance(NodoB<E> n){
        NodoB<E> nodo=n;
        while(nodo!=null && Math.abs(nodo.FE())<=1){
            nodo= nodo.getPadre();
        }
        return nodo;
    }
    
    public NodoB<E> balanceSimpleDer(NodoB<E> n){
        NodoB<E> izq=n.getHijoIzq();
        izq.setPadre(n.getPadre());
        n.setHijoIzq(izq.getHijoDer());
        izq.setHijoDer(n);
        return izq;
    }    
    
    public NodoB<E> balanceSimpleIzq(NodoB<E> n){
        NodoB<E> der=n.getHijoDer();
        der.setPadre(n.getPadre());
        n.setHijoDer(der.getHijoIzq());
        der.setHijoIzq(n);
        return der;
    }
    
    public NodoB<E> balanceDobleDer(NodoB<E> n){
        n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq())); 
        return balanceSimpleDer(n);
    }
    
    public NodoB<E> balanceDobleIzq(NodoB<E> n){
        n.setHijoDer(balanceSimpleDer(n.getHijoDer())); 
        return balanceSimpleIzq(n);
    }
}


public class AVL_Final {
    
    public ArrayList<Persona> buscarMujeres(AVL<Persona> arbolPersonas){
    	Stack<Persona> asc = new Stack<Persona>();
    	
		return sol(ListInorden(arbolPersonas.getRaiz(), asc));
	}
    
    private ArrayList<Persona> sol(Stack<Persona> asc){
    	ArrayList<Persona> desc = new ArrayList();
    	while (!asc.isEmpty()) {
    		desc.add(asc.pop());
    	}
    	
    	return desc;
    }

	private Stack<Persona> ListInorden(NodoB<Persona> r, Stack <Persona> asc) {
		if(r != null) {
			ListInorden(r.getHijoIzq(), asc);
			if(r.getLlave().getSexo() == 'F') {
				asc.push(r.getLlave());

			}
			ListInorden(r.getHijoDer(), asc);
		}
		return asc;
	}
	

    
    //Haga las funciones que necesite

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        AVL<Persona> arbol=new AVL<Persona>();
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(" ");
            Persona p=new Persona(lineSplit[0], Integer.parseInt(lineSplit[1]),lineSplit[2].charAt(0));
            NodoB<Persona> nodo=new NodoB<Persona>(p);
            try {
                arbol.insertNodo(nodo);
            } catch (ExceptionNodo e) {
                System.out.println(e.getMessage());
            }
        }
        AVL_Final avl=new AVL_Final();
        ArrayList<Persona> a=avl.buscarMujeres(arbol);
        ListIterator<Persona> it= a.listIterator();
        while(it.hasNext()) {
            Persona p= it.next();
            System.out.println(p.getNombre()+ " "+ p.getEdad());
        }

        in.close();
    }

}