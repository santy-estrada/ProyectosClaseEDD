package EEDD;

import java.util.ArrayList;
import java.util.ListIterator;

public class Genericos {
	
	public static <E> void printList(ArrayList<E>list) {
		for(E e: list) {
			System.out.println(e);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Pedro");
		lista.add("Olga");
		lista.add("Miguel");
		lista.add("Antonio");
		lista.add("Olga");
		lista.add("Olga");
		lista.add("Antonio");
		lista.add("Olga");
		
		printList(lista);
		
		ArrayList<String> lista1 = (ArrayList<String>)lista.clone();
		
		
		
		for(int i = 0; i < lista1.size(); i ++) {
			if(lista1.get(i).compareTo("Olga") == 0) {
				lista1.remove(i);
			}
		}
		
		printList(lista1);
		
		//Forma real para eliminar datos de una lista
		lista1 = (ArrayList<String>)lista.clone();
		ListIterator<String> it = lista1.listIterator();
		String e;
		while(it.hasNext()) {
			e = it.next();
			if(e.compareTo("Olga") == 0) {
				it.remove();
			}
		}
		
		printList(lista1);

	}

}
