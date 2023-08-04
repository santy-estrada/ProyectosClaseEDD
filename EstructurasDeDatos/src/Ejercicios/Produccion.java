package Ejercicios;

import java.util.Arrays;

public class Produccion {
	private String nombre;
	private int cant;			//Cantidad producida por producto
	private int[] cantSemanal = new int[5];  // Cantidad producida por semana por producto
	private static int prod;	//Producción total
	private static int[] prodSemanal = new int[5];		//Producción total por día
	public final static String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
	
	public Produccion(String nombre) {
		this.nombre = nombre;
		Arrays.fill(cantSemanal, -1);
	}
	
	private int getDia(String dia) {
		
		int i = 0;
		while(i < dias.length && !dias[i].toLowerCase().equals(dia.toLowerCase())) {
			i++;
		}
		return (i < dias.length)? i: -1;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCant() {
		return cant;
	}
	
	public void setCant(String dia, int cant) {
		int index = getDia(dia);
		
		if(index != -1 && cantSemanal[index] != -1 && cant > -1) {
			prodSemanal[index] -= cantSemanal[index];
			prod -= cantSemanal[index];
			this.cant -= cantSemanal[index];
			
			cantSemanal[index] = cant;
			prodSemanal[index] += cant;
			prod += cant;
			this.cant += cant;
		}
	}
	
	public int getProd() {
		return prod;
	}
	
	public void addProd(String dia, int cant) {
		int index = getDia(dia);
		if(index != -1) {
			if(cantSemanal[index] == -1 && cant>-1) {
				cantSemanal[index]= cant;
				prodSemanal[index] += cant;
				prod += cant;
				this.cant += cant;

			}else {
				System.out.println("Imposible de realizar la operación");	//Si no existe mes o ya tiene horas
			}
		}else {
			System.out.println("Mes inválido");
		}
		
	}
	
	public int getProdSemanal(String dia) {
		int index = getDia(dia);
		
		return (index!=-1)? prodSemanal[index]: index;
	}

	
	public void showCantSemanal() {
		System.out.println("-----------------");
		System.out.println(nombre);
		System.out.println("-----------------");

		for(int i = 0; i < dias.length; i++) {
			System.out.print(dias[i] + ": ");
			if(cantSemanal[i] == -1) {
				System.out.println(0.0);
			}else {
				System.out.println(cantSemanal[i]);
			}
		}
		System.out.println("-----------------");

	}
	
	public static void showProdSemanal() {
		System.out.println("-----------------");
		System.out.println("Total producción por día");
		System.out.println("-----------------");

		for(int i = 0; i < dias.length; i++) {
			System.out.println(dias[i] + ": " + prodSemanal[i]);
		}
		System.out.println("-----------------");
	}
	
	public static void showTprod(Produccion []productos) {
		System.out.println("-----------------");
		System.out.println("Total producción por producto");
		System.out.println("-----------------");

		for(int i = 0; i < productos.length; i++) {
			System.out.println(productos[i].getNombre() + ": " + productos[i].getCant());
		}
		System.out.println("-----------------");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produccion[] Productos = new Produccion[10];
		String[] abc = {"A","B","C","D","E","F","G","H","I","J"};
		for(int i = 0; i < 10; i++) {
			Produccion p = new Produccion(abc[i]);
			Productos[i] = p;
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				Productos[i].addProd(Produccion.dias[j],(int) Math.round(Math.random()*1000)) ;
			}
		}
		
		Productos[3].showProdSemanal();
		Productos[3].showCantSemanal();
		Produccion.showTprod(Productos);
		System.out.println("Producción total: " + Productos[3].getProd());
		System.out.println("Producción total del producto " +  Productos[3].getNombre()+ ": " + Productos[3].getCant());
		System.out.println("Producción total el lunes: " + Productos[3].getProdSemanal("lunes"));
		
		System.out.println();
		System.out.println();
		System.out.println("Cambio");
		System.out.println();
		System.out.println();

		Productos[3].setCant("lunes",10);
		
		Produccion.showProdSemanal();
		Productos[3].showCantSemanal();
		Produccion.showTprod(Productos);
		System.out.println("Producción total: " + Productos[3].getProd());
		System.out.println("Producción total del producto " +  Productos[3].getNombre()+ ": " + Productos[3].getCant());
		System.out.println("Producción total el lunes: " + Productos[3].getProdSemanal("lunes"));
		

	}

}
