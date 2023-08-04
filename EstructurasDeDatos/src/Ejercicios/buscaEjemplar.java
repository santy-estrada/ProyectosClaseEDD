package Ejercicios;

public class buscaEjemplar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String codigo = "AAAAAAB12";
		
		int id = Integer.parseInt(codigo.substring(7));
		String code = codigo.substring(0,7);
		
		System.out.println(code);
		System.out.println(id==12);
		

	}

}
