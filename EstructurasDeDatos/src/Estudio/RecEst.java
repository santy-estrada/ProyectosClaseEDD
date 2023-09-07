package Estudio;

import java.util.Arrays;
import java.util.Scanner;


class Estudiante{
    private String nombres;
    private String apellidos;
    private int edad;
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Estudiante(String nombres, String apellidos, int edad) {
        super();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
}

class EVacia extends Exception{
	public EVacia() {
		super("La lista no tiene estudiantes");
	}
}

public class RecEst {


    public static String[] cantidadMayoresEdad(Estudiante[] listaEstudiantes) throws EVacia{
        
        String estudiantes[] = mayoresR(listaEstudiantes, new String [0], 0);
        if(estudiantes.length == 0) {
        	throw new EVacia();
        }
        
        return estudiantes;
    }  
    
    private static String[] mayoresR(Estudiante[] lista, String[] sol, int index) {
    	if(index == lista.length) {
    		return sol;
    	}
    	
    	if(lista[index].getEdad() >= 18) {
    		String nYa = lista[index].getNombres() + " " + lista[index].getApellidos();
    		sol = Arrays.copyOf(sol, sol.length+1);
    		sol[sol.length-1] = nYa;
    	}
    	
    	return mayoresR(lista, sol, index+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String l=in.nextLine();
        int t=0;
        if (l.compareTo("")!=0)
            t= Integer.parseInt(l);
        Estudiante[] listE=new Estudiante[t];
        for(int i=0;i<t;i++){
            l=in.nextLine();
            String[] a=l.split(" ");
            Estudiante e=new Estudiante(a[0], a[1],Integer.parseInt(a[2]));
            listE[i]=e;
        }        
        in.close();
        String[] nombres;
		try {
			nombres = RecEst.cantidadMayoresEdad(listE);
			for (String n:nombres)
		           System.out.println(n);
		} catch (EVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
    }

}
