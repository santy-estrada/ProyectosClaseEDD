package Grafos;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Grafo <E extends Comparable<E>>{
	
	private LinkedList<Vertice<E>> vertices;
	
	public Grafo(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;	
		
	}
	
	public Grafo() {
		this.vertices = new LinkedList<Vertice<E>>();
	}
	
	

	public LinkedList<Vertice<E>> getVertices() {
		return vertices;
	}

	public void setVertices(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
	
	public void inicializarVertices() {
		ListIterator<Vertice<E>> list = vertices.listIterator();
		while(list.hasNext()) {
			Vertice<E> v = list.next();
			v.setAnterior(null);
			v.setDistance(Double.POSITIVE_INFINITY);
		}
	}
	
	public Stack<Vertice<E>> MenorCaminoSinPesos(Vertice<E> inicio, Vertice<E> destino){
		inicializarVertices();	//Inicializar los anteriores y distancias antes de recorrer el camino
		
		//Cola auxiliar
		Queue<Vertice<E>> q = new LinkedList<Vertice<E>>();
		inicio.setDistance(0);
		q.add(inicio);
	
		//Hasta que q esté vacío
		while(!q.isEmpty()) {
			//v es el primer valor de q
			Vertice<E> v = q.peek();
			//Lista con todos los adyacentes de v
			LinkedList<Arista<E>> adyacentes = v.getAdyacentes();
			ListIterator<Arista<E>> list = adyacentes.listIterator();
			//Ciclo para revisar todos los adyacentes de v
			while(list.hasNext()) {
				//Arista que tiene el vértice adyacente
				Arista<E> a = list.next();
				//Vertice siguiente (adyacente en revisión)
				Vertice<E> siguiente = a.getDestino();
				
				//Añade el vertice adyacente si no se ha visitado
				if(siguiente.getAnterior() == null) {
					//Pone el anterior como el vertice anterior analizado
					siguiente.setAnterior(v);
					//Pone la distancia como la distancia del vertica anterior + 1
					siguiente.setDistance(v.getDistance()+1);
					//Añade siguiente
					q.add(siguiente);
				}
			}
			//Saca el vértice que se está analizando para pasar con el siguiente
			q.poll();
		}
		
		Stack<Vertice<E>> camino = new Stack<Vertice<E>>();
		Vertice<E> v = destino;
		while(v != null) {
			camino.push(v);
			v = v.getAnterior();
		}
		
		return camino;
	}
	
	public Stack<Vertice<E>> MenorCaminoConPesos (Vertice<E> inicio, Vertice<E> destino){
		inicializarVertices();	//Inicializar los anteriores y distancias antes de recorrer el camino

		//Cola auxiliar con prioridad para distancias más cortas para actulizar menos nodos
		PriorityQueue<Vertice<E>> q = new PriorityQueue<Vertice<E>>();
		inicio.setDistance(0);
		q.add(inicio);
	
		//Hasta que q esté vacío
		while(!q.isEmpty()) {
			//v es el primer valor de q
			Vertice<E> v = q.peek();
			//Lista con todos los adyacentes de v
			LinkedList<Arista<E>> adyacentes = v.getAdyacentes();
			ListIterator<Arista<E>> list = adyacentes.listIterator();
			//Ciclo para revisar todos los adyacentes de v
			while(list.hasNext()) {
				//Arista que tiene el vértice adyacente
				Arista<E> a = list.next();
				//Vertice siguiente (adyacente en revisión)
				Vertice<E> siguiente = a.getDestino();
				
				double distancia = v.getDistance()+a.getPeso();
				//Añade el vertice adyacente si tiene otra distancia más corta
				if(distancia < siguiente.getDistance()) {
					//Pone el anterior como el vertice anterior analizado
					siguiente.setAnterior(v);
					//Pone la distancia como la distancia del vertica anterior + 1
					siguiente.setDistance(distancia);
					//Añade siguiente si no estaba ya añadido
					if(!q.contains(siguiente)) {
						q.add(siguiente);
					}
				}
			}
			//Saca el vértice que se está analizando para pasar con el siguiente
			q.poll();
		}
		
		Stack<Vertice<E>> camino = new Stack<Vertice<E>>();
		Vertice<E> v = destino;
		while(v != null) {
			camino.push(v);
			v = v.getAnterior();
		}
		
		return camino;
	}
	
	public void printCamino(Stack<Vertice<E>> s) {
		while(!s.isEmpty()) {
			System.out.print(s.pop().getInfo() + " ");
		}

		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vertice<Integer> v1= new Vertice<Integer>(1);

		 Vertice<Integer> v2= new Vertice<Integer>(2);

		 Vertice<Integer> v3= new Vertice<Integer>(3);

		 Vertice<Integer> v4= new Vertice<Integer>(4);

		 Vertice<Integer> v5= new Vertice<Integer>(5);

		 Vertice<Integer> v6= new Vertice<Integer>(6);

		 Vertice<Integer> v7= new Vertice<Integer>(7);

		 Vertice<Integer> v8= new Vertice<Integer>(8);

		 Arista<Integer> a12= new Arista<Integer>(v2, 3);

		 Arista<Integer> a13= new Arista<Integer>(v3, 10);

		 Arista<Integer> a14= new Arista<Integer>(v4, 7);

		 Arista<Integer> a25= new Arista<Integer>(v5, 8);

		 Arista<Integer> a24= new Arista<Integer>(v4, 2);

		 Arista<Integer> a36= new Arista<Integer>(v6, 5);

		 Arista<Integer> a47= new Arista<Integer>(v7, 3);

		 Arista<Integer> a57= new Arista<Integer>(v7, 1);

		 Arista<Integer> a67= new Arista<Integer>(v7, 1);

		 Arista<Integer> a46= new Arista<Integer>(v6, 1);

		 Arista<Integer> a82= new Arista<Integer>(v2, 1);

		 Arista<Integer> a87= new Arista<Integer>(v7, 1);

		 v1.getAdyacentes().add(a12);
		 v1.getAdyacentes().add(a14);
		 v1.getAdyacentes().add(a13);
		 v2.getAdyacentes().add(a25);
		 v2.getAdyacentes().add(a24);
		 v3.getAdyacentes().add(a36);
		 v4.getAdyacentes().add(a47);
		 v4.getAdyacentes().add(a46);
		 v5.getAdyacentes().add(a57);
		 v6.getAdyacentes().add(a67);
		 v8.getAdyacentes().add(a82);
		 v8.getAdyacentes().add(a87);

		 Grafo<Integer> grafo= new Grafo<Integer>();

		 grafo.getVertices().add(v1);

		 grafo.getVertices().add(v2);

		 grafo.getVertices().add(v3);

		 grafo.getVertices().add(v4);

		 grafo.getVertices().add(v5);

		 grafo.getVertices().add(v6);

		 grafo.getVertices().add(v7);

		 grafo.getVertices().add(v8);
		 
		 grafo.printCamino(grafo.MenorCaminoSinPesos(v1,v7));
		 grafo.printCamino(grafo.MenorCaminoConPesos(v1,v7));
		 
		 grafo.printCamino(grafo.MenorCaminoSinPesos(v4,v7));
		 grafo.printCamino(grafo.MenorCaminoConPesos(v4,v7));
		 
		 grafo.printCamino(grafo.MenorCaminoSinPesos(v1,v4));
		 grafo.printCamino(grafo.MenorCaminoConPesos(v1,v4));


	}

}
