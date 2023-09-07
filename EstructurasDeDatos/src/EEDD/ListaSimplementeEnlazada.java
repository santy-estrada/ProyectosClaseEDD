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
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int length() {
		int l = 0;
		NodoL<E> temp = head;
		
		while(temp != null) {
			temp = temp.getNext();
			l++;
		}
		
		return l;
	}
	
	public void addFirst(E x) {
		NodoL<E> newNodo = null;
		
		if(head != null) {
			newNodo = new NodoL <E> (head.getInfo());
			newNodo.setNext(head.getNext());
			head.setInfo(x);
		}else {
			head = new NodoL<E>(x);
		}
		head.setNext(newNodo);
	}
	
	public void printList() {
		NodoL<E> temp = head;
		
		while(temp != null) {
			System.out.print(temp + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public int getIndex(E x) {
		int index = 0;
		NodoL<E> temp = head;
		while(temp != null && temp.getInfo().compareTo(x) != 0) {
			index++;
			temp = temp.getNext();
		}
		
		return (temp == null)? -1: index;
	}
	
	public NodoL<E> getNodo(int index) throws ExceptionNodo{
		if(index < 0) {
			throw new ExceptionNodo("No puede tener un índice negativo");
		}
		NodoL<E> temp = head;
		int i = 0;
		while(temp != null && i != index) {
			i++;
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	public void insertNodo(E x, int pos) throws ExceptionNodo {
		if(pos < 0) {
			throw new ExceptionNodo("No puede tener un índice negativo");
		}
		if(pos == 0) {
			addFirst(x);
			return;
		}
		int index = 0;
		NodoL<E> anterior = head;
		NodoL<E> nuevo = new NodoL<E> (x);
		while(anterior != null && pos-1 > index) {
			index++;
			anterior = anterior.getNext();
		}
		
		if(anterior == null) {
			throw new ExceptionNodo("No se puede insertar en el nodo pedido");
		}
		nuevo.setNext(anterior.getNext());
		anterior.setNext(nuevo);;
		
	}
	
	public boolean deleteNodo(E x) {
		if(head.getInfo().compareTo(x) == 0) {
			setHead(head.getNext());
			return true;
		}
		
		int index = 0;
		NodoL<E> anterior = head;
		
		
		while(anterior.getNext() != null) {
			if(anterior.getNext().getInfo().compareTo(x) == 0) {
				anterior.setNext(anterior.getNext().getNext());
				return true;
			}
			anterior = anterior.getNext();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaSimplementeEnlazada l = new ListaSimplementeEnlazada();
		l.addFirst(5);
		l.addFirst(1);
		l.addFirst(2);
		l.addFirst(3);
		l.addFirst(4);
		
		l.printList();
		System.out.println(l.getIndex(3));
		try {
			System.out.println(l.getNodo(2));
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			l.insertNodo(10, 1);
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.printList();
		
		l.deleteNodo(4);
		l.printList();

	}

}
