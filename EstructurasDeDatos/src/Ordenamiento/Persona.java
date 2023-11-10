package Ordenamiento;

public class Persona implements Comparable<Persona>{

	private static int orden = 0;
	private int arrived;
	private String nombre;
	private int edad;
	private boolean prego;
	private boolean imp;
	
	public Persona(String nombre, int edad, boolean prego, boolean imp) {
		this.edad = edad;
		this.nombre = nombre;
		this.prego = prego;
		this.imp = imp;
		this.arrived = orden;
		orden++;
	}
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
		this.prego = false;
		this.imp = false;
		this.arrived = orden;
		orden++;
	}
	
	public boolean getImp() {
		return imp;
	}
	
	public boolean getPrego() {
		return prego;
	}
	
	public int getArrived() {
		return arrived;
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
	public int compareTo(Persona o2) {
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
		
		//return edad - o.getEdad();
		//return nombre.compareTo(o.getNombre());
		
		
		if(imp && o2.getImp()) {
			return comparePregoEdadArrived(o2.getPrego(), o2.getEdad(), o2.getArrived());
		}else if(imp) {
			return -1;
		}else if(o2.getImp()) {
			return 1;
		}else {
			return comparePregoEdadArrived(o2.getPrego(), o2.getEdad(), o2.getArrived());
		}

	}
	
	private int comparePregoEdadArrived(boolean e, int edad2, int arrived2) {
		if(prego && e) {
			return compareEdadArrived(edad2, arrived2);
		}else if(prego) {
			return -1;
		}else if(e) {
			return 1;
		}else {
			return compareEdadArrived(edad2, arrived2);
		}
	}
	
	private int compareEdadArrived(int edad2, int arrived2) {
		if(edad > 60 && edad2 > 60) {
			return -arrived2 + arrived;
		}else if(edad > 60 || edad2 > 60) {
			return -edad + arrived2;
		}else {
			return -arrived2 + arrived;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Persona p1 = new Persona("Marcela", 21, true, false);
		Persona p2 = new Persona("Marcela", 24, true, true);
		Persona p3 = new Persona("Marcela", 20, false, true);
		Persona p4 = new Persona("Andrés", 26, false, false);
		Persona p5 = new Persona("Carlos", 30, false, true);
		Persona p6 = new Persona("Ana", 21, false, false);
		Persona p7 = new Persona("Nadia", 21, false, false);
		*/
		
		Persona p1 =new Persona("Juan1", 20, false, true);
		Persona p2 =new Persona("Juan2", 16, false, false);
		Persona p3 =new Persona("Abel1", 20, true, true);
		Persona p4 =new Persona("Ana", 20, true, false);
		Persona p5 =new Persona("Abel2", 75, false, false);
		
		System.out.println(p4.compareTo(p2));
		
		Persona personas[] = {p1,p2,p3,p4,p5};
		
		try {
			Ordenamiento.selectionSort(personas);
			Ordenamiento.printLista(personas);

		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	


}
