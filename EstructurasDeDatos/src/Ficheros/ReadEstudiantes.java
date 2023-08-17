package Ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadEstudiantes {

	private Estudiante estudiantes[];
	
	public ReadEstudiantes() throws ClassNotFoundException, IOException {
		estudiantes = readEstudiante();
	}
	
	//Leer de los objetos existentes
	private Estudiante[] readEstudiante() throws IOException, ClassNotFoundException{
		File f = new File("C:\\Users\\santy\\git\\ClaseEstructurasDeDatos\\EstructurasDeDatos\\src\\Ficheros\\Estudiantes");
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		File files[] = f.listFiles();		//Arreglo con todos los archivos de la carpeta
		Estudiante estudiantes[] = new Estudiante[0];
		
		for(int i = 0; i < files.length; i++) {
			fi = new FileInputStream(files[i].getPath());
			oi = new ObjectInputStream(fi);
			estudiantes = Arrays.copyOf(estudiantes, estudiantes.length+1);
			estudiantes[i] = (Estudiante) oi.readObject();	//Se guarda el estudiante
		}
		
		if(fi != null && oi != null) {
			oi.close();
			fi.close();
		}
	
		return estudiantes;
	}
	
	public Estudiante[] geEstudiantes(){
		return this.estudiantes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadEstudiantes rw;
		try {
			rw = new ReadEstudiantes();
			for(Estudiante e: rw.geEstudiantes()) {
				e.showNotas();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
