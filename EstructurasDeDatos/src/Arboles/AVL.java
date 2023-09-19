package Arboles;

public class AVL <E extends Comparable<E>> extends ABB<E>{

	public AVL(NodoB raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insertNodo(NodoB<E> n ) throws ExceptionNodo {
		super.insertNodo(n);
		balancear(n);
	}
	
	private void balancear(NodoB<E> n) {
		NodoB<E> desb = desbalance(n);
		if(desb != null) {
			NodoB<E> p = desb.getPadre();
			if(desb.FE() > 0) {
				if(desb.getHijoD().FE() >= 0) {	//Caso simpleIzq FE + e Hijo Derecha +
					desb = balanceSimpleIzq(desb);	
				}else {	//Caso dobleIzq FE +  e hijo Derecha -
					desb = balanceDobleIzq(desb);
				}
			}else {
				if(desb.FE() < 0) {	//Caso simpleDer DE - e hijo Izquierda -
					if(desb.getHijoI().FE() <= 0) {
						desb = balanceSimpleDer(desb);
					}else {	//Caso dobleDer FE - e Hijo Izquierda +
						desb = balanceDobleDer(desb);
					}
				}
			}
			
			if(p == null) {
				raiz = desb;
			}else {
				if(desb.getLlave().compareTo(p.getLlave()) > 0) {
					p.setHijoD(desb);
				}else {
					p.setHijoI(desb);
				}
			}
		}
	}
	
	private NodoB <E> desbalance(NodoB<E> n){
		NodoB<E> nodo = n;
		while(nodo != null && Math.abs(nodo.FE()) <= 1){
			nodo = nodo.getPadre();
		}
		
		return nodo;
	}
	
	private NodoB <E> balanceSimpleIzq(NodoB <E> n){
		NodoB<E> der = n.getHijoD(); //Tomar hijo de la derecha del desbalanceado
		der.setPadre(n.getPadre());	//Padre del hijo de la derecha ahora es el padre de n
		n.setHijoD(der.getHijoI());	//Nuevo hijo de la derecha de n es el hijo de la izquierda de der
		der.setHijoI(n);
	
		return der;
	}
	
	private NodoB <E> balanceSimpleDer(NodoB <E> n){
		NodoB<E> izq = n.getHijoI(); //Tomar hijo de la izquierda del desbalanceado
		izq.setPadre(n.getPadre());	//Padre del hijo de la izquierda ahora es el padre de n
		n.setHijoI(izq.getHijoD());	//Nuevo hijo de la izquierda de n es el hijo de la derecha de izq
		izq.setHijoD(n);
	
		return izq;
	}
	
	private NodoB<E> balanceDobleDer(NodoB<E> n){
		n.setHijoI(balanceSimpleIzq(n.getHijoI()));	//El hijo de la izquierda debe balancearse hacia la izquierda
		
		return balanceSimpleDer(n);		//El nuevo n se debe balancear a la derecha
	}
	
	private NodoB<E> balanceDobleIzq(NodoB<E> n){
		n.setHijoD(balanceSimpleDer(n.getHijoD()));	//El hijo de la derecha debe balancearse hacia la derecha
		
		return balanceSimpleIzq(n);		//El nuevo n debe balancearse a la izquierda
	}
	
	@Override
	public void deleteNodo(E llave) throws ExceptionNodo {
		NodoB<E> n = buscar(llave);
		NodoB<E> padre;
	
		if(n.getHijoD() != null && n.getHijoI() != null) {
			padre = buscarAntecesor(n).getPadre();
		}else {
			padre = n.getPadre();
		}
		
		super.deleteNodo(llave);
		
		if(padre == null) {
			balancear(raiz);
		}else {
			while(padre != null) {
				balancear(padre);
				padre = padre.getPadre();
			}
		}
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
		AVL<Integer> a = new AVL<Integer>(n8);
		
		try {
			a.insertNodo(n10);
			a.insertNodo(n12);
			a.insertNodo(n14);
			a.insertNodo(n13);
			a.inorden();
			a.insertNodo(n5);
			a.insertNodo(n7);
			a.inorden();
			System.out.println("Eliminaciones:");
			a.deleteNodo(8);
			a.inorden();
			a.deleteNodo(7);
			a.inorden();
			a.deleteNodo(10);
			a.inorden();
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

}
