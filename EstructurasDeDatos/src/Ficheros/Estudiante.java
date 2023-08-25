package Ficheros;
import java.io.*;
import java.util.Arrays;

class correo implements Serializable{
	private String mail;
	public correo(String mail) {
		this.mail = mail;
	}
	public String getCorreo() {
		return mail;
	}
	
}
public class Estudiante implements Serializable {
	private static int num;
	private int id;
	private String[] materias;
	private double[][] notas;
	String nombre;
	correo c;
	public Estudiante(String nombre, String[] materias) {
		num++;
		this.id = num;
		this.materias = materias;
		this.notas = new double[materias.length][];
		this.nombre = nombre;
		c = new correo(nombre + "@");
	}
	
	//Guardar el estudiante en archivo
	public void saveEstudiante() throws IOException {
		//Crea un file con el path que quiero para la carpeta de estudiantes
		File f = new File("C:\\Users\\santy\\git\\ClaseEstructurasDeDatos\\EstructurasDeDatos\\src\\Ficheros\\Estudiantes");
		if(f.exists() || (!f.exists() && f.mkdir())) {	// si existe o si no existe y se puede crear
			FileOutputStream fs = new FileOutputStream( "C:\\Users\\santy\\git\\ClaseEstructurasDeDatos\\EstructurasDeDatos\\src\\Ficheros\\Estudiantes" +"\\"+this.nombre+".javaObj");
			ObjectOutputStream os= new ObjectOutputStream(fs);
			
			os.writeObject(this);		//Escriba el objeto con toda la información
			os.close();
			fs.close();
		}
	
	}
	

	public double getPromedioGeneral() {
		double prom = 0;
		String materia;
		for(int i =0; i < materias.length; i++) {	//Número de materias
			materia = materias[i];					
			prom += getPromedio(materia);			//Acumula el promedio de todas las materias
		}
		
		return prom/materias.length;
	}
	
	public double getPromedio(String materia) {
		double prom = 0;
		int index = getMateria(materia);		//Toma el índice de la materia buscada
		
		if (index!=-1) {
			if(notas[index] != null) {
				for(int i = 0; i < notas[index].length; i++) { //Recorre el arreglo que corresponde a la materia dentro de notas
					prom+=notas[index][i];
				}
			}else {
				return 0;
			}
		}else {
			System.out.println("La materia no existe");
			return -1;
		}
		
		return prom/notas[index].length;
	}
	
	
	public void showNotas() {
		System.out.println(this.nombre);
		System.out.println("-----------------");
		for(int i = 0; i < materias.length; i++) {		//materias.length es número de materias
			System.out.print(materias[i] + ": ");		//materia
			if(notas[i] == null) {						//revisa que sí hayan notas
				System.out.print("No hay notas");
			}else {
				for(int j = 0; j < notas[i].length; j++) {	//Recorre el arreglo dentro de notas que corresponde a la materia
					System.out.print(notas[i][j] + "  ");
				}
			}

			System.out.println("");
			System.out.println(c.getCorreo());
		}
		System.out.println("-----------------");
	}
	
	public void addNota(String materia, double nota) {
		int i = getMateria(materia);
		
		if (i != -1 && nota >= 0 && nota <= 5) {		//Si sí existe la materia y la nota es mayor a 0
			if(notas[i] == null) {		//Revisa si existe ya una nota
				notas[i] = new double[1];		//Crea el arreglo de espacio 1
			}else {
				notas[i] = Arrays.copyOf(notas[i], notas[i].length+1);
			}
			notas[i][notas[i].length-1] = nota;
		}else {
			System.out.println("La clase no existe o la nota es inválida");
		}
	}
	
	
	private int getMateria(String materia) {
		int index = 0;
		
		while(index < materias.length && !materia.equals(materias[index])) {
			index++;
		}
		
		return (index < materias.length)? index: -1;
	}
	
	
	public static int getNum() {
		return num;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
		String materias[] = {"Cálculo", "Estructuras de datos", "Física de ondas", "Dinámica"};
		Estudiante e1 = new Estudiante("Santiago", materias);
		Estudiante e2 = new Estudiante("Sara", materias);
		
		e1.addNota("Física de ondas",4.5);
		e1.addNota("Cálculo",2);
		e1.addNota("Estructuras de datos",2);
		e1.addNota("Estructuras de datos",5);
		e1.addNota("Dinámica",5);
		
		e2.addNota("Física de ondas",2.3);
		e2.addNota("Cálculo",4.7);
		e2.addNota("Estructuras de datos",1.5);
		e2.addNota("Estructuras de datos",3.5);
		e2.addNota("Dinámica",4.8);
		
		/*
		e1.addNota("Dinámica",5.5);
		e1.addNota("Estructuras de datos",-1);
		e1.addNota("Administración",3.5);
		*/
		
		e1.showNotas();
		e2.showNotas();
		/*
		System.out.println(e1.getPromedio("Física de ondas"));
		System.out.println("-----------------");
		System.out.println(e1.getPromedioGeneral());
		*/
		
		try {
			e1.saveEstudiante();
			e2.saveEstudiante();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

