package Recursividad;

public class Div3R {
	public static boolean div3(int n) {
		if(n == 0) {	//De una 0 no es divisible entre 3
			return false;
		}
		//Si n es positivo, se le tendr� que restar 3. Si n es negativo, se le restar� -3
		int fact = (n <0)? -3: 3;
		
		return div3r(n, fact);
	}

	private static boolean div3r(int n, int factor) {
		if(n == 0) {	//Si se lleg� a 0, es divisible entre 3
			return true;
		}
		if(n > 0 && factor == -3) {
			//Si su factor fue -3, n original era negativo. Si ahora es positivo, se pas�
			return false;
		}
		if(n < 0 && factor == 3) {
			//Si su factor fue 3, n original era positivo. Si ahora es negativo, se pas�
			return false;
		}
		
		return div3r(n-factor, factor);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(div3(9));
	}

}
