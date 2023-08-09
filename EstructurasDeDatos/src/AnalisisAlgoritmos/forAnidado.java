package AnalisisAlgoritmos;

public class forAnidado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 0;
		for(int i = 0; i < 5; i++) {
			//System.out.println(1);
			for(int j = i; j < 5; j++) {
				//System.out.println(2);
				for (int k = i; k <= j; k++) {
					cont++;
				}
			}
		}
		System.out.println(cont);
	}

}
