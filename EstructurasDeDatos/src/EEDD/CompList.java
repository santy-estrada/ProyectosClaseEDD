package EEDD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class CompList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 10000000;
		Integer p2 = 10;
		/*
		//ArrayList
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			aList.add(i);		//Añadir al final de la lista
		}
		
		long inicio = System.currentTimeMillis();
		aList.remove(10000);	//Remover
		//aList.get(10000);		//Obtener un dato
		long fin = System.currentTimeMillis();
		
		long time = fin-inicio;
		System.out.println("ArrayList: " + time);
		
		//LinkedList
		LinkedList<Integer> lList = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			lList.add(i);		//Añadir al final de la lista
		}	
		
		inicio = System.currentTimeMillis();
		lList.remove(5000000);
		//lList.get(10000);
		fin = System.currentTimeMillis();
		
		time = fin-inicio;
		System.out.println("LinkedList: " + time);
		
		//Queueueueue
		Queue<Integer> lQueue = new LinkedList<Integer>();
		//lQueue.add(p2);
		
		for(int i = 0; i < N; i++) {
			lQueue.add(i);		//Añadir al final de la cola
		}	
		
		inicio = System.currentTimeMillis();
		lQueue.poll();		//Quitar el primero
		//lQueue.get(10000);
		fin = System.currentTimeMillis();
		
		time = fin-inicio;
		System.out.println("Queueueueue: " + time);
		
		//Stack
		Stack<Integer> lStack = new Stack<Integer>();
		//lQueue.add(p2);
		
		for(int i = 0; i < N; i++) {
			lStack.push(i);		//Añadir al final del stack
		}	
		
		inicio = System.currentTimeMillis();
		lStack.pop();		//Quitar el primero
		//lQueue.get(10000);
		fin = System.currentTimeMillis();
		
		time = fin-inicio;
		System.out.println("Stack: " + time);
		*/
		Stack<Integer> sl = new Stack<Integer>();
		N = 10;
		
		for(int i = 0; i <N; i++) {
			sl.push(i);
		}
		
		ListIterator<Integer> index = sl.listIterator();	//Necesario para recorrer
		//Forma de recorrer una lista cualquiera
		while(index.hasNext()) {
			System.out.print(index.next() + ", ");
		}
		
		System.out.println();
		//Forma de vacear una pila
		while(!sl.empty()) {
			System.out.print(sl.pop() + ", ");
		}
		
		System.out.println();
		
	
	}

}
