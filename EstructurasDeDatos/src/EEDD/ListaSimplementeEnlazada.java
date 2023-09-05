package EEDD;

class ExceptionNodo extends Exception{
	public ExceptionNodo(String s) {
		super(s);
	}
}

class NodoL<E>{
	private E info;
	private NodoL<E> next;
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public NodoL<E>	getNext(){
		return next;
	}
	
	public void setNext(NodoL<E> next) {
		this.next = next;
	}
	
	public NodoL(E info) {
		this.info = info;
		next = null;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}
}

public class ListaSimplementeEnlazada <E extends Comparable<E>> {

	private NodoL<E> head;
	
	public NodoL<E>	getHead(){
		return head;
	}
	
	public void setHead(NodoL<E> head) {
		this.head = head;
	}
	
	public ListaSimplementeEnlazada (NodoL<E> head) {
		this.head = head;
	}
	
	public ListaSimplementeEnlazada () {
		this.head = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
