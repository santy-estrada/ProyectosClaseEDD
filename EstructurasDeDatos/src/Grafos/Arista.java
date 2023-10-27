package Grafos;

public class Arista  <E extends Comparable<E>>{

	private Vertice<E> destino;
	private double peso;
	
	public Arista(Vertice<E> destino, double peso) {
		super();
		this.destino = destino;
		this.peso = peso;
	}
	
	public Vertice<E> getDestino() {
		return destino;
	}
	
	public void setDestino(Vertice<E> destino) {
		this.destino = destino;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
