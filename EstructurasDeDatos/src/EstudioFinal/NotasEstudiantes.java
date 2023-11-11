package EstudioFinal;

import java.util.*;


class Nota{
	private String materia;
    private double nota;
	public Nota(String materia, double nota) {
		super();
		this.materia = materia;
		this.nota = nota;
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
    
    
    
}

class Estudiante{
    private String nombre;
    private String cedula;
    private LinkedList<Nota> notas;
    public Estudiante(String nombre, String cedula, LinkedList<Nota> notas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.notas = notas;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LinkedList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(LinkedList<Nota> notas) {
		this.notas = notas;
	}

	public double promedio() {
    	double sum = 0;
    	for(int i = 0; i < notas.size(); i++) {
    		sum+=notas.get(i).getNota();
    	}
    	
    	return sum/notas.size();
    }
    
    public int bajo3() {
    	int cont = 0;
    	for(int i = 0; i < notas.size(); i++) {
    		if(notas.get(i).getNota() <3) {
    			cont++;
    		}
    	}
    	
    	return cont;
    }
  
}

class EEstudiante extends Exception{
	public EEstudiante(String s) {
		super (s);
	}
}

class ListaEstudintes{
    private ArrayList<Estudiante> estudiantes;


	public ListaEstudintes(ArrayList<Estudiante> estudiantes) {
		super();
		this.estudiantes = estudiantes;
	}
	
	
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public Estudiante searchStudent (String cedula) throws EEstudiante {
		int i = 0;
		while(i < estudiantes.size() && !cedula.equals(estudiantes.get(i).getCedula())) {
			i++;
		}
		
		if(i >= estudiantes.size()) {
			throw new EEstudiante("El estudiante " + cedula + " no existe");
		}
		
		return estudiantes.get(i);
	}


	// Completar
    public void imprimirNotas(String cedula) throws EEstudiante {
    	Estudiante e = searchStudent(cedula);
    	System.out.println(e.promedio() + "," + e.bajo3());
    }
}

public class NotasEstudiantes {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		String line= in.nextLine();
		String[] listEst=line.split(",");
		
		ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
		while ((line=in.nextLine()).compareTo("")!=0) {
			String[] datos=line.split(",");
			LinkedList<Nota> notas=new LinkedList<Nota>();			
			for (int i=2;i<datos.length;i+=2)
				notas.add(new Nota(datos[i],Double.parseDouble(datos[i+1])));
			estudiantes.add(new Estudiante(datos[0],datos[1],notas));
		}
		ListaEstudintes lista=new ListaEstudintes(estudiantes);
		for (String c:listEst) {	
			try {
				lista.imprimirNotas(c);
			} catch (EEstudiante e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());;
			}
		}			
		in.close();

    }

}
