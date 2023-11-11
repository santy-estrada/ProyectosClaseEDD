package EstudioFinal;
import java.util.*;

class ExceptionNodoB extends Exception{
    private static final long serialVersionUID = 1L;

    public ExceptionNodoB(String s){
        super(s);
    }
}

class Nodo<E extends Comparable<E>> {
    protected E llave;
    protected Nodo<E> hijoIzq;
    protected Nodo<E> hijoDer;
    protected Nodo<E> padre;

    public Nodo(E llave) {
        this.llave = llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(E llave, Nodo<E> hijoIzq, Nodo<E> hijoDer, Nodo<E> padre) {
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


    public Nodo<E> getHijoIzq() {
        return hijoIzq;
    }


    public void setHijoIzq(Nodo<E> hijoIzq) {
        if (hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }


    public Nodo<E> getHijoDer() {
        return hijoDer;
    }


    public void setHijoDer(Nodo<E> hijoDer) {
        if (hijoDer!=null){
            hijoDer.setPadre(this);
        }
        this.hijoDer = hijoDer;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }
    
    @Override
    public String toString() {
        String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
        String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
        return ((Comparable<E>)llave).toString()+ "("+HI+","+HD+")";
    }
    
    public int altura (Nodo<E> n){
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
    


}


class ArbolB<E extends Comparable<E>> {

    protected Nodo<E> raiz;
    
    public ArbolB() {
        this.raiz = null;
    }
    
    public ArbolB(Nodo<E> raiz) {
        super();
        this.raiz = raiz;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }    
    
    public void preorden(){
        preorden(raiz);
        System.out.println();
    }
    
    public void preorden(Nodo<E> r){
        if (r!=null){
            System.out.print(r.getLlave()+" ");
            preorden(r.getHijoIzq());
            preorden(r.getHijoDer());
        }    
    }
    
    
    public ArrayList<E> preordenList(){
        ArrayList<E> list=new ArrayList<E>();
        preordenList(raiz, list);
        return list;
    }
    
    public void preordenList(Nodo<E> r, ArrayList<E> list){
        if (r!=null){
            list.add(r.getLlave());
            preordenList(r.getHijoIzq(),list);
            preordenList(r.getHijoDer(),list);
        }    
    }
    
    
    public void inorden(){
        inorden(raiz);
    }
    
    public void inorden(Nodo<E> r){
        if (r!=null){
            inorden(r.getHijoIzq());
            System.out.print(r+ " ");
            inorden(r.getHijoDer());
        }    
    }
    
    public void postorden(){
        postorden(raiz);
    }
    
    public void postorden(Nodo<E> r){
        if (r!=null){
            postorden(r.getHijoIzq());
            postorden(r.getHijoDer());
            System.out.print(r.getLlave()+ " ");
        }    
    }
    
    public void insertNodo(Nodo<E> n) throws ExceptionNodoB{
        raiz=insertNodo(n, raiz);
    }

    protected Nodo<E> insertNodo(Nodo<E> n, Nodo<E> r) throws ExceptionNodoB {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insertNodo(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodoB("El nodo se repite");
        }
        return r;
        
    }
    
    public void printFE(){
        printFE(raiz);
    }
    
    public void printFE(Nodo<E> r){
        if (r!=null){
            printFE(r.getHijoIzq());
            System.out.print(r.FE()+ " ");
            printFE(r.getHijoDer());
        }    
    }
        
}
    


public class ArbolDesdeLista {
    ///////////////////////////////
    //Completar
    
    public static ArbolB<Integer> convertirListaAVL(ArrayList<Integer> lista) throws ExceptionNodoB{
        lista.sort(null);
        
        return new ArbolB<Integer>(crearArbol(lista, 0, lista.size()-1));
    }
    
    private static Nodo<Integer> crearArbol(ArrayList<Integer> nodos, int i, int j){
    	if(i > j) {
    		return null;
    	}
    	
    	int mid = (i+j)/2;
    	Nodo<Integer> root = new Nodo<Integer>(nodos.get(mid));
    	
    	root.setHijoIzq(crearArbol(nodos, i, mid-1));
    	root.setHijoDer(crearArbol(nodos, mid+1, j));
    	
    	return root;

    }
    
    

    public static void main(String[] args) {
            // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] n=line.split(",");
        ArrayList<Integer> lista=new ArrayList<Integer>();
        for (String s:n)
            lista.add(Integer.parseInt(s));
        try {
            ArbolB<Integer>arbol=convertirListaAVL(lista);
            System.out.println(arbol.getRaiz());
            arbol.inorden();
            System.out.println();
            arbol.printFE();
        } catch (ExceptionNodoB e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());;
        }
        in.close();
            
    }
}
