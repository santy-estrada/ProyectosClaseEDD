package Ejercicios;

import java.util.Arrays;


public class ProyectosEmpresa {
	
	private String nombre;
	public final static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
									"Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};
	private double[] horas;		//Horas por mes por producto
	private static double[] Mhoras = new double[12];		//Horas totales por mes
	private double Phoras;			//Horas totales del proyecto
	private static double Thoras;	//Horas totales
	
	public ProyectosEmpresa(String nombre) {
		this.horas = new double[12];
		Arrays.fill(horas, -1);
		this.nombre = nombre;
	}
	
	public static double getThoras() {
		return Math.round(Thoras*100)/100.0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPhoras() {
		return Math.round(Phoras*100)/100.0;
	}
	
	public double getMhoras(String mes) {	
		int index = getMes(mes);

		return (index != -1)? Math.round(Mhoras[index]*100)/100.0: index;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	private int getMes(String mes) {
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
				Mhoras[index] += Math.round(hora*100)/100.0;
				Thoras += Math.round(hora*100)/100.0;
				Phoras += Math.round(hora*100)/100.0;

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
			Mhoras[index] -= horas[index];
			Thoras -= horas[index];
			Phoras -= horas[index];
			
			horas[index]=hora;
			Mhoras[index] += hora;
			Thoras += hora;
			Phoras += hora;

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
	
	public static void showMhoras() {
		System.out.println("-----------------");
		System.out.println("Total horas por mes");
		System.out.println("-----------------");

		for(int i = 0; i < meses.length; i++) {
			System.out.println(meses[i] + ": " + Math.round(Mhoras[i]*100)/100.0);
		}
		System.out.println("-----------------");
	}
	
	public static void showTproy(ProyectosEmpresa []proyectos) {
		System.out.println("-----------------");
		System.out.println("Total horas por proyecto");
		System.out.println("-----------------");

		for(int i = 0; i < proyectos.length; i++) {
			System.out.println(proyectos[i].getNombre() + ": " + proyectos[i].getPhoras());
		}
		System.out.println("-----------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProyectosEmpresa[] Proyectos = new ProyectosEmpresa[20];
		String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
		for(int i = 0; i < 20; i++) {
			ProyectosEmpresa p = new ProyectosEmpresa(abc[i]);
			Proyectos[i] = p;
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 12; j++) {
				Proyectos[i].addHoras(ProyectosEmpresa.meses[j],Math.round((Math.random()*100 + Math.random())*100)/100.0) ;
			}
		}
		
		Proyectos[3].showMhoras();
		Proyectos[3].showHoras();
		ProyectosEmpresa.showTproy(Proyectos);
		System.out.println("Horas totales: " + Proyectos[3].getThoras());
		System.out.println("Horas totales del proyecto " +  Proyectos[3].getNombre()+ ": " + Proyectos[3].getPhoras());
		System.out.println("Horas totales en diciembre: " + Proyectos[3].getMhoras("diciembre"));
		
		System.out.println();
		System.out.println();
		System.out.println("Cambio");
		System.out.println();
		System.out.println();

		Proyectos[3].setHora("Diciembre",10);
		
		ProyectosEmpresa.showMhoras();
		Proyectos[3].showHoras();
		ProyectosEmpresa.showTproy(Proyectos);
		System.out.println("Horas totales: " + Proyectos[3].getThoras());
		System.out.println("Horas totales del proyecto " +  Proyectos[3].getNombre()+ ": " + Proyectos[3].getPhoras());
		System.out.println("Horas totales en diciembre: " + Proyectos[3].getMhoras("diciembre"));
		System.out.println("-----------------");

		
		

		/*
		p2.addHoras("diciembre", 10);
		p2.addHoras("enero", 5);
		
		p1.addHoras("diciembre", 85.3);
		p1.addHoras("enero", -85.3);
		
		p1.showHoras();
		
		System.out.println(p1.getThoras());
		System.out.println(p1.getPhoras());
		System.out.println("-----------------");

		System.out.println(p2.getThoras());
		System.out.println(p2.getPhoras());
		System.out.println("-----------------");

		System.out.println(p2.getMhoras("octubre"));
		System.out.println(p2.getMhoras("diciembre"));
		
		p2.setHora("diciembre",96);
		p2.showHoras();
		
		System.out.println(p2.getThoras());
		
		p2.showMhoras();*/

	}

}
