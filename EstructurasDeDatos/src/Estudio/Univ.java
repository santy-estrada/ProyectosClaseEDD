package Estudio;

import java.util.*;
/*
class ExceptionEstudiante extends Exception{
	public ExceptionEstudiante() {
		super("No hay estudiantes con notas por debajo de 3");
	}
}

class Curso{
    private String codigo;
    private String nombre;
    private double[] porcientosnotas;
    public Curso(String codigo, String nombre, double[] porcientosnotas) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcientosnotas = porcientosnotas;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public double[] getPorcientosnotas() {
        return porcientosnotas;
    }
    
}

class Notas_Curso{
    private String codigoCurso;
    private double[] notas;
    public Notas_Curso(String codigoCurso, double[] notas) {
        super();
        this.codigoCurso = codigoCurso;
        this.notas = notas;
    }
    public String getCodigoCurso() {
        return codigoCurso;
    }
    public double[] getNotas() {
        return notas;
    }
    public double getPromedio() {
    	double sum = 0;
    	for(double d: notas) {
    		sum += d;
    	}
    	
    	return sum/notas.length;
    }
    
    
}

class Estudiante{
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String carrera;
    private Notas_Curso[] notas;
    public Estudiante(String tipoDocumento, String numeroDocumento, String nombre, String carrera, Notas_Curso[] notas) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.carrera = carrera;
        this.notas = notas;
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }


    public Notas_Curso[] getNotas() {
        return notas;
    }
    
    public boolean bajo3() {
    	int index = 0;
    	while(index < notas.length) {
    		if(notas[index].getPromedio() < 3) {
    			return true;
    		}
    		index++;
    	}
    	
    	return false;
    }
    
    
}

public class Univ {
    private Estudiante[] estudiantes;    
    
    public Univ(Estudiante[] estudiantes) {
        super();
        this.estudiantes = estudiantes;
    }

	//Implemente RECURSIVO
    public Estudiante[] estudiantesNotaM3() throws ExceptionEstudiante {
    	return getM2(new Estudiante[0], 0);
    }
    
    private Estudiante[] getM2(Estudiante[] malos, int index) throws ExceptionEstudiante {
    	if(index >= estudiantes.length) {
    		if(malos.length == 0) {
    			throw new ExceptionEstudiante();
    		}
    		return malos;
    	}
    	
    	if(estudiantes[index].bajo3()) {
    		malos = Arrays.copyOf(malos, malos.length+1);
    		malos[malos.length-1] = estudiantes[index];
    	}
    	
    	return getM2(malos, index+1);
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countEst=Integer.parseInt(in.nextLine());
        Estudiante[] estudiantes=new Estudiante[countEst];
        for(int i=0;i<estudiantes.length;i++) {
            String[] nl=in.nextLine().split(";");
            int countMat=Integer.parseInt(nl[4]);
            Notas_Curso[] notascurso=new Notas_Curso[countMat];
            for (int j=0;j<countMat;j++) {
                String[] nest=nl[5+j].split(",");
                double[] notasl=new double[nest.length-1];
                for(int k=1;k<nest.length;k++)
                    notasl[k-1]=Double.parseDouble(nest[k]);
                notascurso[j]=new Notas_Curso(nest[0],notasl);
            }
            estudiantes[i]=new Estudiante(nl[0], nl[1], nl[2], nl[3], notascurso);
        }
        
        Univ u=new Univ(estudiantes);
        Estudiante[] est;
        try {
			est = u.estudiantesNotaM3();
			 for (Estudiante e:est)
		            System.out.println(e.getNumeroDocumento());    
		} catch (ExceptionEstudiante e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
           
        
        in.close();

    }

}
*/