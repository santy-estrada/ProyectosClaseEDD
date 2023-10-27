package Arboles;

import java.util.ArrayList;

public class ArbolB  <E extends Comparable<E>>{

	protected NodoB<E> raiz;
	
	public ArbolB(NodoB<E> raiz) {
		this.raiz = raiz;
	}

	public NodoB<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}
	
	public ArrayList<E> ListPreorden() {
		ArrayList <E> sol = new ArrayList<E>();
		
		return ListPreorden(raiz, sol);
	}
	
	private ArrayList<E> ListPreorden(NodoB<E> r, ArrayList <E> sol) {
		if(r != null) {
			sol.add(r.getLlave());
			ListPreorden(r.getHijoI(), sol);
			ListPreorden(r.getHijoD(), sol);
		}
		return sol;
	}
	
	public void preorden() {
		preorden(raiz);
		System.out.println();
	}
	
	private void preorden(NodoB<E> r) {
		if(r != null) {
			System.out.print(r.getLlave() + " ");
			preorden(r.getHijoI());
			preorden(r.getHijoD());
		}
	}
	
	public ArrayList<E> ListPosorden() {
		ArrayList <E> sol = new ArrayList<E>();
		
		return ListPosorden(raiz, sol);
	}
	
	private ArrayList<E> ListPosorden(NodoB<E> r, ArrayList <E> sol) {
		if(r != null) {
			ListPosorden(r.getHijoI(), sol);
			ListPosorden(r.getHijoD(), sol);
			sol.add(r.getLlave());
		}
		return sol;
	}
	
	
	public void posorden() {
		posorden(raiz);
		System.out.println();
	}
	
	private void posorden(NodoB<E> r) {
		if(r!= null) {
			posorden(r.getHijoI());
			posorden(r.getHijoD());
			System.out.print(r.getLlave() + " ");
		}
	}
	
	public ArrayList<E> ListInorden() {
		ArrayList <E> sol = new ArrayList<E>();
		
		return ListInorden(raiz, sol);
	}
	
	private ArrayList<E> ListInorden(NodoB<E> r, ArrayList <E> sol) {
		if(r != null) {
			ListInorden(r.getHijoI(), sol);
			sol.add(r.getLlave());
			ListInorden(r.getHijoD(), sol);
		}
		return sol;
	}
	
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	
	private void inorden(NodoB<E> r) {
		if(r != null) {
			inorden(r.getHijoI());
			//System.out.print(r.getLlave() + " ");
			System.out.print(r + " ");
			inorden(r.getHijoD());
		}
	}
	
	public int nHojas() {
		
		return nHojas(raiz, 0);
	}
	
	private int nHojas (NodoB<E> r, int cant) {
		if(r == null) {
			return 0;
		}
		
		if(r.getHijoD() == null && r.getHijoI() == null) {
			return 1;
		}
		
		int hojasD = cant + nHojas(r.getHijoD(), cant);
		int hojasI = cant + nHojas(r.getHijoI(), cant);
		
		return hojasD + hojasI;
	}
	
	public int nIntermedios() {
		
		return nIntermedios(raiz);
	}
	
	private int nIntermedios(NodoB<E> n) {
		int interD, interI;
		if(n == null || n.getHijoD() == null && n.getHijoI() == null) {
			return 0;
		}else if(n.getPadre() != null){
			interD = 1 + nIntermedios(n.getHijoD());
			interI = nIntermedios(n.getHijoI());
		}else {
			interD = nIntermedios(n.getHijoD());
			interI = nIntermedios(n.getHijoI());
		}
		
		
		return interD + interI;
		
	}
	
	public void print() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodoB<Integer> n1 = new NodoB<Integer>(1);
		NodoB<Integer> n2 = new NodoB<Integer>(2);
		NodoB<Integer> n3 = new NodoB<Integer>(3);
		NodoB<Integer> n4 = new NodoB<Integer>(4);
		NodoB<Integer> n5 = new NodoB<Integer>(5);
		NodoB<Integer> n6 = new NodoB<Integer>(6);
		NodoB<Integer> n20 = new NodoB<Integer>(20);
		
		n3.setHijoI(n6);
		n2.setHijoI(n4);
		n2.setHijoD(n5);
		n1.setHijoI(n2);
		n1.setHijoD(n3);
		n4.setHijoD(n20);
		
		ArbolB<Integer> a = new ArbolB<Integer>(n1);
		System.out.println("Número de hojas: " + a.nHojas());
		System.out.println();
		
		System.out.println("Número de nodos intermedios: " + a.nIntermedios());
		System.out.println();
		
		System.out.print("Preorden: ");
		a.preorden();
		System.out.println(a.ListPreorden());
		System.out.println();
		
		System.out.print("Posorden: ");
		a.posorden();
		System.out.println(a.ListPosorden());
		System.out.println();
		
		System.out.print("Inorden:  ");
		a.inorden();
		System.out.println(a.ListInorden());
		System.out.println();
		
		
		System.out.println("Altura de n20: " + n20.altura());
		System.out.println("Altura del árbol: " + a.getRaiz().altura());
		

	}

}
