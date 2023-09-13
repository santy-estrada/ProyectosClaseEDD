package EEDD;
import java.util.Comparator;
import java.util.PriorityQueue;

import Ordenamiento.Persona;

//Comparator para aplicar prioridades personalizadas en un priorityqueue
class CompEdad implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		return o1.getEdad() - o2.getEdad();
	}
	
}

class CompNom implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}
	
}

class CompChoose implements Comparator<Persona>{

	private String tipo;
	
	public CompChoose(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		if(tipo.compareTo("nombre") == 0) {
			return o1.getNombre().compareTo(o2.getNombre());
		}else {
			return o1.getEdad() - o2.getEdad();
		}
		
	}
	
}

class Inclusives implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		if(o1.getImp() && !o2.getImp()) {
			return -1;
		}else if(!o1.getImp() && o2.getImp()) {
			return 1;
		}else {
			return comparePregoEdadArrived(o2.getPrego(), o2.getEdad(), o2.getArrived(), o1.getPrego(), o1.getEdad(), o1.getArrived());
		}

	}
	
	private int comparePregoEdadArrived(boolean e, int edad2, int arrived2, boolean prego, int edad, int arrived) {
		if(prego && !e) {
			return -1;
		}else if(!prego && e) {
			return 1;
		}else {
			return compareEdadArrived(edad2, arrived2, edad, arrived);
		}
	}
	
	private int compareEdadArrived(int edad2, int arrived2, int edad, int arrived) {
		if((edad > 60 && edad2 <= 60) || (edad <= 60 && edad2 > 60)) {
			return -edad + arrived2;
		}else {
			return -arrived2 + arrived;
		}
	}


	
}

public class EjPriorityQ {
	
	public static void main(String[] args) {
		PriorityQueue<Persona> pq = new PriorityQueue<Persona>(new Inclusives());
		/*PriorityQueue<Persona> pq = new PriorityQueue<Persona>( new Comparator<Persona>(){
		 * 		public int compare(Persona o1, Persona o2) {
					return o1.getEdad() - o2.getEdad();
				}
		 * });
		 */
		pq.add(new Persona("Juan1", 20, false, true));
		pq.add(new Persona("Juan2", 16, false, false));
		pq.add(new Persona("Abel1", 20, true, true));
		pq.add(new Persona("Ana", 20, true, false));
		pq.add(new Persona("Abel2", 75, false, false));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}

}
