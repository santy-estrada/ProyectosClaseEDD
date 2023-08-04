package Ejercicios;

import java.util.Random;

public class RandomString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		
		String codigo = new String();
	    Random random = new Random();

	    // longitud de código
	    int l = 7;
	    int index;
	    for(int i = 0; i < l; i++) {
	      // generate random index number
	      index = random.nextInt(abc.length());

	      // get character specified by index
	      // from the string
	      char seleccion = abc.charAt(index);

	      // append the character to string builder
	     codigo += seleccion;
	    }
	    codigo += 5;
	    System.out.println(codigo.substring(7));
	}

}
