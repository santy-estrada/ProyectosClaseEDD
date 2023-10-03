package Arboles;

class ExceptionNodo extends Exception{
	public ExceptionNodo(String s) {
		super(s);
	}
}

public class ABB <E extends Comparable <E>> extends ArbolB<E>{

	public ABB(NodoB<E> raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
	
	public ABB() {
		super(null);
	}
	
	public NodoB<E>	buscar(E llave) throws ExceptionNodo{
		return buscar(llave, raiz);
	}
	
	private NodoB<E> buscar(E llave, NodoB<E> r) throws ExceptionNodo{
		if(r == null) {
			throw new ExceptionNodo("El nodo no existe");
		}
		if(llave.compareTo(r.getLlave()) < 0) {
			return buscar(llave, r.getHijoI());
		}
		if(llave.compareTo(r.getLlave()) > 0) {
			return buscar(llave, r.getHijoD());
		}
		
		return r;
	}
	
	
	
	public void insertNodo(E llave) throws ExceptionNodo {
		raiz = insertNodo(new NodoB<E>(llave), raiz);
	}
	
	public void insertNodo(NodoB<E> n) throws ExceptionNodo {
		raiz = insertNodo(n, raiz);
	}
	
	private NodoB<E> insertNodo(NodoB <E> n, NodoB<E> r) throws ExceptionNodo {
		if(r == null) {
			r = n;
		}else {
			if(n.getLlave().compareTo(r.getLlave())< 0) {
				r.setHijoI(insertNodo(n, r.getHijoI()));
			}
			if(n.getLlave().compareTo(r.getLlave())> 0) {
				r.setHijoD(insertNodo(n, r.getHijoD()));
			}
			if(n.getLlave().compareTo(r.getLlave()) == 0) {
				throw new ExceptionNodo("El nodo ya existe");
			}
		}
		
		return r;
	}
	
	public NodoB<E> buscarAntecesor(NodoB<E> n){
		return (n.getHijoI() == null)? null: buscarMax(n.getHijoI());
	}
	
	public NodoB<E> buscarMax(NodoB<E> n){
		return (n.getHijoD() == null)? n: buscarMax(n.getHijoD());
	}
	
	
	public int altura() {
		return (raiz != null)? raiz.altura(): -1;
	}
	
	public void deleteNodo(E llave) throws ExceptionNodo {
		raiz = deleteNodo(llave, raiz);
	}
	
	public NodoB<E> deleteNodo(E llave, NodoB<E> r) throws ExceptionNodo{
		if(r == null) {
			throw new ExceptionNodo("El nodo no existe");
		}else {
			if(llave.compareTo(r.getLlave()) < 0) {
				r.setHijoI(deleteNodo(llave, r.getHijoI()));
			}else {
				if(llave.compareTo(r.getLlave()) > 0) {
					r.setHijoD(deleteNodo(llave, r.getHijoD()));
				}else {
					//Caso 3
					if(r.getHijoD() != null && r.getHijoI() != null) {
						NodoB<E> antecesor = buscarAntecesor(r);
						r.setLlave(antecesor.getLlave());
						r.setHijoI(deleteNodo(antecesor.getLlave(), r.getHijoI()));
					}else {
						//Caso 2 o Caso 1
						if(r.getHijoD() != null) {
							r = r.getHijoD();
						}else {
							r = r.getHijoI();
						}
					}
				}
				
			}
		}
		
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NodoB<Integer> n1 = new NodoB<Integer>(1);
		NodoB<Integer> n2 = new NodoB<Integer>(2);
		NodoB<Integer> n3 = new NodoB<Integer>(3);
		NodoB<Integer> n4 = new NodoB<Integer>(4);
		NodoB<Integer> n5 = new NodoB<Integer>(5);
		NodoB<Integer> n6 = new NodoB<Integer>(6);
		NodoB<Integer> n7 = new NodoB<Integer>(7);
		NodoB<Integer> n8 = new NodoB<Integer>(8);
		NodoB<Integer> n9 = new NodoB<Integer>(9);
		NodoB<Integer> n10 = new NodoB<Integer>(10);
		NodoB<Integer> n11 = new NodoB<Integer>(11);
		NodoB<Integer> n12 = new NodoB<Integer>(12);
		NodoB<Integer> n13 = new NodoB<Integer>(13);
		NodoB<Integer> n14 = new NodoB<Integer>(14);
		NodoB<Integer> n15 = new NodoB<Integer>(15);
		NodoB<Integer> n16 = new NodoB<Integer>(16);
		ABB<Integer> a = new ABB<Integer>(n5);
		
		try {
			a.insertNodo(n2);
			a.insertNodo(n3);
			a.insertNodo(n1);
			a.insertNodo(n9);
			a.insertNodo(n7);
			a.insertNodo(n8);
			a.insertNodo(n6);
			a.insertNodo(n4);
			a.insertNodo(n10);
			a.insertNodo(n15);
			a.insertNodo(n16);
			
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		a.inorden();
		System.out.println("Número de nodos intermedios: " + a.nIntermedios());
		System.out.println(a.altura());
		
		try {
			System.out.println(a.buscar(4));
			System.out.println(a.buscar(12));

		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println("Número de hojas: " + a.nHojas());
		
		try {
			a.deleteNodo(7);
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		a.inorden();
		System.out.println("Número de nodos intermedios: " + a.nIntermedios());
	}

}
