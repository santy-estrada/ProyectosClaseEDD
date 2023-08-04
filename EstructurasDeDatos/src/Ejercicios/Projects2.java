package Ejercicios;

import java.util.Arrays;

class Empresa{
	
	private String nombre;
	private Projects2[] proyectos;
	

	public Empresa(String nombre, Projects2[] proyectos) {
		this.nombre = nombre;
		this.proyectos = proyectos;
	}
	
	
	
	public String getNombreEmpresa() {
		return nombre;
	}
	
	public Projects2[] getProyectos() {
		return proyectos;
	}
	
	public void setNombreEmpresa(String nombre) {
		this.nombre = nombre;
	}
	
	public double getHorasTrabajadas() {
		double horasTrabajadas = 0;
		double hora = 0;
		for(int i = 0; i < proyectos.length; i++) {
			hora = getHorasProyecto(proyectos[i].getNombre());
			if(hora !=-1) {
				horasTrabajadas += hora;
			}
		}
		return Math.round(horasTrabajadas*100)/100.0;
	}
	
	private int searchProyecto(String nombre) {
		int index = 0;
		
		while (index < proyectos.length && !proyectos[index].getNombre().equals(nombre)) {
			index++;
		}
		return (index < proyectos.length)? index: -1;
		
	}
	
	public double getHorasProyecto(String proyecto) {
		double horas = 0;
		int index = searchProyecto(proyecto);
		if(index != -1) {
			for(int i = 0; i < proyectos[index].getHora().length; i++) {
				horas += proyectos[index].getHora()[i];
			}
		}else {
			horas = index;
			System.out.println("No existe un proyecto con ese nombre");
		}
		return (horas != -1)? Math.round(horas*100)/100.0: -1;
	}
	
	
	public void setNombreProyecto(String nombreN, String nombreV) {
		int index = searchProyecto(nombreV);
		if(index != -1) {
			proyectos[index].setNombre(nombreN);
		}else {
			System.out.println("No existe un proyecto con ese nombre");
		}
	}
	
	
	public double getHorasTrabajadasMes(String mes) {
		double horas = 0;
		int index = Projects2.getMes(mes);
		if(index != -1) {
			for(int i = 0; i < proyectos.length; i++) {
				horas += proyectos[i].getHora()[index];
			}
		}else {
			System.out.println("No existe un mes con ese nombre");
			horas = -1;
		}
		
		return Math.round(horas*100)/100.0;
	}
	
	public void setHoraProyecto(String proyecto, String mes, double hora) {
		int index = searchProyecto(proyecto);
		if(index != -1) {
			proyectos[index].setHora(mes, hora);
		}else {
			System.out.println("El proyecto no existe");
		}
	}
	
	public double getHorasProyectoMes(String proyecto, String mes) {
		double horas = 0;
		int indexP = searchProyecto(proyecto);
		int indexM = Projects2.getMes(mes);
		if(indexP != -1 && indexM != -1) {
			horas = proyectos[indexP].getHora()[indexM];
		}else {
			System.out.println("El proyecto o el mes no existe");
			horas = -1;
		}
		
		return horas;
	}
	
	
	public void showHorasProyecto(String proyecto) {
		int index = searchProyecto(proyecto);
		if(index != -1) {
			proyectos[index].showHoras();
		}else {
			System.out.println("El proyecto no existe");
		}
	}
	
	public void showHorasTrabajadasMes() {
		System.out.println("-----------------");
		System.out.println("Total horas por mes");
		System.out.println("-----------------");

		for(int i = 0; i < Projects2.meses.length; i++) {
			System.out.println(Projects2.meses[i] + ": " + getHorasTrabajadasMes(Projects2.meses[i]));
		}
		System.out.println("-----------------");
	}
	
	public void showHorasTotalesProyecto() {
		System.out.println("-----------------");
		System.out.println("Total horas por proyecto");
		System.out.println("-----------------");

		for(int i = 0; i < proyectos.length; i++) {
			System.out.println(proyectos[i].getNombre() + ": " + getHorasProyecto(proyectos[i].getNombre()));
		}
		System.out.println("-----------------");
		
		
	}
	
	
}

public class Projects2 {
	
	public final static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};
	
	private String nombre;
	private double[] horas;		//Horas por mes por producto
	
	
	public Projects2(String nombre) {
		this.horas = new double[12];
		Arrays.fill(horas, -1);
		this.nombre = nombre;
	}
	
	public double[] getHora() {
		return horas;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public static int getMes(String mes) {
		int index = 0;
		while(index < meses.length && !meses[index].toLowerCase().equals(mes.toLowerCase())) {
			index++;
		}
		
		return (index < meses.length)? index: -1;
	}
	
	public void addHoras(String mes, double hora) {
		int index = getMes(mes);
		if(index != -1) {
			if(horas[index] == -1 && hora>-1) {
				horas[index]= Math.round(hora*100)/100.0;

			}else {
				System.out.println("Imposible de realizar la operación");	//Si no existe mes o ya tiene horas
			}
		}else {
			System.out.println("Mes inválido");
		}
		
	}
	
	
	public void setHora(String mes, double hora) {
		int index = getMes(mes);

		if(index != -1 && horas[index] != -1 && hora>-1) {
			
			horas[index]=hora;

		}else {
			System.out.println("Imposible de realizar la operación");	//Si no existe mes o no tiene horas
		}
	}
	
	public void showHoras() {
		System.out.println("-----------------");
		System.out.println(nombre);
		System.out.println("-----------------");

		for(int i = 0; i < meses.length; i++) {
			System.out.print(meses[i] + ": ");
			if(horas[i] == -1) {
				System.out.println(0.0);
			}else {
				System.out.println(horas[i]);
			}
		}
		System.out.println("-----------------");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Projects2[] Proyectos = new Projects2[20];
		String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
		for(int i = 0; i < 20; i++) {
			Projects2 p = new Projects2(abc[i]);
			Proyectos[i] = p;
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 12; j++) {
				Proyectos[i].addHoras(Projects2.meses[j],Math.round((Math.random()*100 + Math.random())*100)/100.0) ;
			}
		}
		
		Empresa e1 = new Empresa("Constructura SAS", Proyectos);
		
		e1.showHorasTrabajadasMes();
		e1.showHorasProyecto("D");
		e1.showHorasTotalesProyecto();
		System.out.println("Horas totales: " + e1.getHorasTrabajadas());
		System.out.println("Horas totales del proyecto D: " + e1.getHorasProyecto("D"));
		System.out.println("Horas totales en diciembre: " + e1.getHorasTrabajadasMes("diciembre"));
		
		System.out.println();
		System.out.println();
		System.out.println("Cambio");
		System.out.println();
		System.out.println();

		e1.setHoraProyecto("D","Diciembre",10);
		e1.setHoraProyecto("Z","Diciembre",10);
		e1.setHoraProyecto("A","lunes",10);
		System.out.println();
		System.out.println();
		
		e1.showHorasTrabajadasMes();
		e1.showHorasProyecto("D");
		e1.showHorasTotalesProyecto();
		System.out.println("Horas totales: " + e1.getHorasTrabajadas());
		System.out.println("Horas totales del proyecto D: " + e1.getHorasProyecto("D"));
		System.out.println("Horas totales en diciembre: " + e1.getHorasTrabajadasMes("diciembre"));
		System.out.println();
		System.out.println();
	
		
		System.out.println("Horas totales del proyecto D: " + e1.getHorasProyecto("Z"));
		System.out.println("Horas totales en diciembre: " + e1.getHorasTrabajadasMes("martes"));
		e1.showHorasProyecto("Z");
		System.out.println();
		System.out.println();
		
		
		e1.setNombreProyecto("Z", "D");
		System.out.println("Horas totales del proyecto Z: " + e1.getHorasProyecto("Z"));
		System.out.println();
		System.out.println();
		
		System.out.println("Horas de diciembre del proyecto Z: " + e1.getHorasProyectoMes("Z", "diciembre"));

	}

}
