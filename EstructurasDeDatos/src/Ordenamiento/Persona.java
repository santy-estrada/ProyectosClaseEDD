package Ordenamiento;

public class Persona implements Comparable<Persona>{

	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad (int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return nombre + ", " + edad;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		//System.out.println("Actual: " + this);
		//System.out.println("Comparado con: " + o);
		
		/*
		//Comparar por nombre y entre nombres organizar por edad
		if(nombre.compareTo(o.getNombre()) == 0) {
			return edad - o.getEdad();
		}
		
		return nombre.compareTo(o.getNombre());
		*/
		
		/*//Comparar por edad y entre edades organizar por nombre
		if(edad-o.getEdad() == 0) {
			return nombre.compareTo(o.getNombre());
		}
		return edad - o.getEdad();*/
		
		return edad - o.getEdad();
		//return nombre.compareTo(o.getNombre());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Marcela", 21);
		Persona p2 = new Persona("Marcela", 24);
		Persona p3 = new Persona("Marcela", 20);
		Persona p4 = new Persona("Andrés", 26);
		Persona p5 = new Persona("Carlos", 30);
		Persona p6 = new Persona("Ana", 21);
		Persona p7 = new Persona("Nadia", 21);
		
		Persona personas[] = {p1,p2,p3,p4,p5,p6, p7};
		
		Ordenamiento.selectionSort(personas);
		
		Ordenamiento.printLista(personas);

	}
	


}
