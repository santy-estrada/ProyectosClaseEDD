package Quiz1;

import java.util.Arrays;
import java.util.Scanner;

// Cree Exception NoEstudiante

class Persona{
    private String nombre;
    public Persona(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Crear clase Estudiante

class Estudiante extends Persona{

	private double notas[];
	public Estudiante(String nombre) {
		super(nombre);
	}
	
	public double promedioNotas() {
		double promedio =0;
		if(notas!= null) {
			for(double d: notas) {
				if(d >= 0) {
					promedio += d;
				}
			}
		}
		return promedio/notas.length;
	}

	
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	public double[] getNotas() {
		return notas;
	}

	
}

class NoEstudiante extends Exception{
	public NoEstudiante() {
		super("No hay estudiantes");
	}
}




class Universidad{
    private Persona[] personas;

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public double PromedioTotal() throws NoEstudiante{
        double promedio = 0;
        int nEstudiantes = 0;
        
        for(Persona p: personas) {
        	if(p instanceof Estudiante) {
        		promedio += ((Estudiante) p).promedioNotas();
        		nEstudiantes++;
        	}
        }
        
        if(nEstudiantes ==0) {throw new NoEstudiante();}
        
        return promedio/nEstudiantes;
    }
       
    
}

public class Solucion {

    public static void main(String[] args) {
        //leer Personas
        
        Scanner in = new Scanner(System.in);
        int cantidad= Integer.parseInt(in.nextLine());
        Persona[] personas=new Persona[cantidad];

        for (int i=0;i<cantidad;i++) {
            String tipo=in.nextLine();
            String nombre=in.nextLine();
            if (tipo.compareTo("Estudiante")==0){
                double[] notas=new double[0];
                String line="";
                while((line=in.nextLine()).compareTo("")!=0) {
                    notas=Arrays.copyOf(notas, notas.length+1);
                    notas[notas.length-1]=Double.parseDouble(line);
                }
                Estudiante e=new Estudiante(nombre);
                e.setNotas(notas);
                System.out.println(e.promedioNotas());
                personas[i]=e;
            }            
            else            
                personas[i]=new Persona(nombre);
        }       
        in.close();
        Universidad universidad=new Universidad();
        universidad.setPersonas(personas);
        try {
            System.out.print(universidad.PromedioTotal());
        } catch (NoEstudiante e) {
            System.out.print(e.getMessage());
        }
    }
}
