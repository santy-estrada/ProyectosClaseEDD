package Recursividad;

public class Hanoi {
	public static void hanoi(int n) {
		if (n == 0) {
			System.out.println("No se puede");
		}else {
			hanoiR(n, 'A', 'C', 'B');
		}
	}
	
	private static void hanoiR(int nDisco, char origen, char destino, char aux) {
		if(nDisco == 1) {	//Caso base cuando se quiere organizar el último disco
			System.out.println("Mover disco " + nDisco + " desde " + origen + " hasta " + destino);
			//Este puede ocurrir cuando el objetivo es el destino o el auxiliar
		}else {
			hanoiR(nDisco-1, origen, aux, destino);// Mueve la pila inferior desde el origen al auxiliar
			//El primer objetivo es pasar todos los discos menos el último al auxiliar
			System.out.println("Mover disco " + nDisco + " desde " + origen + " hasta " + destino);//Movimiento intermedio
			//Moviemintos intermedios para llegar al objetivo
			hanoiR(nDisco-1, aux, destino, origen); //Mueve  la pila desde auxiliar a C
			//El segundo objetivo es pasar del auxiliar a la última torre
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hanoi(3);
	}

}
