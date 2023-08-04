package Ejercicios;

import java.util.Arrays;

public class Checarunicidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []Codigos = {"AAA", "BBB", "CCC"};
		String codigo = "ACC";
		int index = 0;
		
		while(index < Codigos.length && !Codigos[index].equals(codigo)) {
			index++;
		}
		
		if(index >= Codigos.length) {
			Codigos = Arrays.copyOf(Codigos, Codigos.length+1);
			Codigos[Codigos.length-1] = codigo;
			System.out.println("Unico");
		}else {
			System.out.println("Unicon't");
		}
		
		codigo = "ACC";
		index = 0;
		
		while(index < Codigos.length && !Codigos[index].equals(codigo)) {
			index++;
		}
		
		if(index >= Codigos.length) {
			Codigos = Arrays.copyOf(Codigos, Codigos.length+1);
			Codigos[Codigos.length-1] = codigo;
			System.out.println("Unico");
		}else {
			System.out.println("Unicon't");
		}
		
		
	}

}
