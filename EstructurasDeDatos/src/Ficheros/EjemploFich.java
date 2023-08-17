package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploFich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter b = null;
		String fichero ="C:\\Users\\santy\\git\\ClaseEstructurasDeDatos\\EstructurasDeDatos\\src\\Ficheros\\Prueba";
		
		try {
			fw = new FileWriter(fichero);
			b = new BufferedWriter(fw);
			b.write("Prueba");
			b.newLine();
			b.write("Prueba2");
			
		}catch (FileNotFoundException e) {
			System.out.println("No se pudo encontrar el fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo escribir en el fichero");
		}
		finally {
			if(fw != null) {
				try {
					b.close();
					fw.close();
				}catch(IOException e) {
					System.out.println("No se pudo cerrar el fichero");
				}
			}
		}
		
		File f = new File("C:\\Users\\santy\\git\\ClaseEstructurasDeDatos\\EstructurasDeDatos\\src\\Ficheros\\Prueba");
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			
			while((linea=br.readLine()) != null) {
				System.out.println(linea);
			}
		}catch (FileNotFoundException e){
			System.out.println("No se pudo econtrar el fichero");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo escribir en el fichero");
		}finally {
			if(fw != null) {
				try {
					b.close();
					fw.close();
				}catch(IOException e) {
					System.out.println("No se pudo cerrar el fichero");
				}
			}
		}
		
		

	}

}
