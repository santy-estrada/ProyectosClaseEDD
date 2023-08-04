package TemaNuevo;

public class TestTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Trabajador t = new Trabajador ("Juan Gonzalez", 400,23);
		
		System.out.println("El salario es: " + t.salario());
		
		Trabajador l = new EmpLimpieza("Maria Linares",250,19,50,40);		
		//Crear un objeto desde la clase padre permite crear un arreglo tipo padre con todos los objetos
		
		System.out.println("El salario es: " + l.salario());
		*/
		
		Trabajador[] listaTrabajadores = new Trabajador[3];
		
		listaTrabajadores[0] = new Trabajador("Juan Pérez", 5000000, 20);
		listaTrabajadores[1] = new EmpLimpieza("Ana Hdez", 2000000, 24,20,10);
		listaTrabajadores[2] = new Trabajador("Pedro Pérez", 600000, 24);
		
		
		for(Trabajador t: listaTrabajadores) {
			if(t instanceof EmpLimpieza) {
				System.out.println("Empleado de limpieza: " +t.salario());
			}else {
				System.out.println("Trabajador: " + t.salario());
			}
		}

	}

}
