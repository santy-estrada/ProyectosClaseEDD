package EstudioFinal;

import java.util.*;

enum Element{DOCUMENT,PRIVATEDOCUMENT,MONEY,OTHER}
enum Shipping{LOCAL,NATIONAL,INTERNATIONAL}
enum PriorityType{HIGH, MEDIUM, LOW}

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
    
    public void insert(NodoB<E> n){
        raiz=insert(n, raiz);
    }
    
    protected NodoB<E> insert(NodoB<E> n, NodoB<E> r){
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<=0)
                r.setHijoIzq(insert(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insert(n,r.getHijoDer()));
        }
        return r;        
    }
    
    public void insertNodo(NodoB<E> n){
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
    
    public void inorden(){
        inorden(raiz);
        System.out.println();
    }
    
    public void inorden(NodoB<E> r){
        if (r!=null){
            inorden(r.getHijoIzq());
            System.out.println(r.getLlave());
            inorden(r.getHijoDer());
        }    
    }
}

class ElementType{
    private Element type;
    private int count;
    public ElementType(Element type, int count) {
        super();
        this.type = type;
        this.count = count;
    }
    public Element getType() {
        return type;
    }
    public void setType(Element type) {
        this.type = type;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }    
}

class Package implements Comparable<Package>{
	protected static int turno = 0;
	protected int llegada;
    protected double weight; // peso en kgs
    protected double volume; // volumen en cms3
    protected Shipping shipping_type;
    protected ElementType[] content;
    protected double price;
    protected double extraprice; 
    public Package(double weight, double volume, Shipping shipping_type,
            ElementType[] content, double price,double extraprice) {
        super();
        this.weight = weight;
        this.volume = volume;
        this.shipping_type = shipping_type;
        this.content = content;
        this.price=price;
        this.extraprice=extraprice;
        llegada = turno;
        turno++;
        
    }
    public int getLlegada() {
    	return llegada;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public Shipping getShipping_type() {
        return shipping_type;
    }
    public void setShipping_type(Shipping shipping_type) {
        this.shipping_type = shipping_type;
    }
    public ElementType[] getContent() {
        return content;
    }
    public void setContent(ElementType[] content) {
        this.content = content;
    }
    
        
    @Override
    public String toString() {
        return totalPrice()+", weight=" + weight + ", volume=" + volume + ", shipping_type=" + shipping_type + ", price="
                + price + ", extraprice=" + extraprice;
    }
    // b) Complete
    public double totalPrice() {
        return price+extraprice;
    }
	@Override
	
	public int compareTo(Package o) {
		// TODO Auto-generated method stub
		return (int) (o.totalPrice()-totalPrice());
	}

}

// a) Complete la clase
class PackageExpress extends Package{
	private PriorityType priority;
	private double priceExpress;
    public PackageExpress(double weight, double volume, Shipping shipping_type, ElementType[] content, double price,
			double extraprice, PriorityType priority, double priceExpress) {
		super(weight, volume, shipping_type, content, price, extraprice);
		this.priority = priority;
		this.priceExpress = priceExpress;
		// TODO Auto-generated constructor stub
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}

	public double getPriceExpress() {
		return priceExpress;
	}

	public void setPriceExpress(double priceExpress) {
		this.priceExpress = priceExpress;
	}

	@Override
	public double totalPrice() {
        return super.totalPrice() + priceExpress;
    }


}

// Complete e)
class PackageComparator implements Comparator<Package> {
    @Override
    public int compare(Package pkg1, Package pkg2) {
    	if(!(pkg1 instanceof PackageExpress) && !(pkg2 instanceof PackageExpress)) {
    		return pkg1.getLlegada() - pkg2.getLlegada();
    	}else if(pkg1 instanceof PackageExpress && pkg2 instanceof PackageExpress) {
    		if(((PackageExpress) pkg1).getPriority().ordinal() == ((PackageExpress) pkg2).getPriority().ordinal()) {
        		return pkg1.getLlegada() - pkg2.getLlegada();
    		}else {
    			if(((PackageExpress) pkg1).getPriority().ordinal() == 0){
        			return -1;
        		}else if(((PackageExpress) pkg2).getPriority().ordinal() == 0) {
        			return 1;
        		}else if(((PackageExpress) pkg1).getPriority().ordinal() == 1){
        			return -1;
        		}else {
        			return 1;
        		}
    		}
    		
    	}else if(pkg1 instanceof PackageExpress) {
    		return -1;
    	}else {
    		return 1;
    	}
    	
    }
}

public class ExTree {

	private ArrayList<Package> packages=new ArrayList<Package>();
    
    // Complete d)
    public ArrayList<Package> firstPackages(NodoB<Package> raiz,double maxVol, double maxW){
    	Queue<Package> list = new LinkedList<Package>();
    	list = ListInorden(raiz, list);
    	ArrayList<Package> sol = new ArrayList<Package>();
    	double peso = 0;
    	double vol = 0;
    	Package aux;
    	
    	while(!list.isEmpty() && peso < maxW && vol < maxVol) {
    		aux = list.poll();
    		peso += aux.getWeight();
    		vol += aux.getVolume();
    		sol.add(aux);
    	}
    	
    	if(peso > maxW || vol > maxVol) {
    		sol.remove(sol.size()-1);
    	}
       return sol; 
    }
    
    private Queue<Package> ListInorden(NodoB<Package> r, Queue <Package> sol) {
		if(r != null) {
			ListInorden(r.getHijoIzq(), sol);
			sol.add(r.getLlave());
			ListInorden(r.getHijoDer(), sol);
		}
		return sol;
	}
    
    // Complete e)
	public PriorityQueue<Package> sortPackages() {
		PriorityQueue<Package> pq = new PriorityQueue<Package>(new PackageComparator());
		for(Package p: packages) {
			pq.add(p);
		}
        return pq;
    }
    
     // Complete f)
    public ArrayList<Package> firstPackagesBack(NodoB<Package> raiz,double maxVol, double maxW){
      	Queue<Package> list = new LinkedList<Package>();
    	list = ListInorden(raiz, list);
    	ArrayList<Package> sol = new ArrayList<Package>();
    	double peso = 0;
    	double vol = 0;
    	Package aux;
    	
    	while(!list.isEmpty() && peso < maxW && vol < maxVol) {
    		aux = list.poll();
    		peso += aux.getWeight();
    		vol += aux.getVolume();
    		
    		if(peso > maxW || vol > maxVol) {
    			peso -= aux.getWeight();
        		vol -= aux.getVolume();
        	}else {
        		sol.add(aux);

        	}
    		
    	}
    	
    	
       return sol; 
    }
    
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        int section=Integer.parseInt(line);
        line=in.nextLine();
        double maxW=Double.parseDouble(line);
        line=in.nextLine();
        double maxV=Double.parseDouble(line);
        ArrayList<Package> arrL=new ArrayList<Package>();
        AVL<Package> tree=new AVL<Package>();
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            Package p=null;
            int count=Integer.parseInt(lineSplit[4]);
        	ElementType[] et=new ElementType[count];
        	for(int i=0;i<et.length;i++)
        		et[i]=new ElementType(Element.valueOf(lineSplit[5+i*2]), Integer.parseInt(lineSplit[5+i*2+1]));
            p=(Integer.parseInt(lineSplit[0])==0)?new Package(Double.parseDouble(lineSplit[1]), 
            		Double.parseDouble(lineSplit[2]),Shipping.valueOf(lineSplit[3]),et,Double.parseDouble(lineSplit[lineSplit.length-2]),Double.parseDouble(lineSplit[lineSplit.length-1])):
            				new PackageExpress(Double.parseDouble(lineSplit[1]), Double.parseDouble(lineSplit[2]),Shipping.valueOf(lineSplit[3]),et,
            						Double.parseDouble(lineSplit[lineSplit.length-4]),Double.parseDouble(lineSplit[lineSplit.length-3]),PriorityType.valueOf(lineSplit[lineSplit.length-2]),Double.parseDouble(lineSplit[lineSplit.length-1]));
            arrL.add(p);
            NodoB<Package> nodo=new NodoB<Package>(p);
            tree.insertNodo(nodo);   
        }
        if(section==1) { // Inciso a y b
        	ListIterator<Package> it= arrL.listIterator();
    		while(it.hasNext()) {
    			Package pack= it.next();
    			System.out.println(pack.totalPrice());
    		}
        }        
        if(section==2) { 
        	tree.inorden();
        }
        ExTree avl=new ExTree();
        if(section==3) {
        	ArrayList<Package> a=avl.firstPackages(tree.getRaiz(),maxV,maxW);
    		ListIterator<Package> it= a.listIterator();
    		while(it.hasNext()) {
    			Package pack= it.next();
    			System.out.println(pack);
    		}
        }
        if(section==4) {
        	avl.packages=arrL;
        	PriorityQueue<Package> pq=avl.sortPackages();
    		while (!pq.isEmpty()) {
    			Package pack=pq.poll();
    			String init="";
    			if(pack instanceof PackageExpress)
    				init=((PackageExpress)pack).getPriority().toString()+"_";
    			System.out.println(init+pack.getWeight()+"_"+pack.getVolume());
    	    }
        }
        
        if(section==5) {
        	ArrayList<Package> a=avl.firstPackagesBack(tree.getRaiz(),maxV,maxW);
    		ListIterator<Package> it= a.listIterator();
    		while(it.hasNext()) {
    			Package pack= it.next();
    			System.out.println(pack);
    		}
        }
        in.close();
    }
}