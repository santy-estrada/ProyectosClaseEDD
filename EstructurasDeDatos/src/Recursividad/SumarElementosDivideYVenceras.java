package Recursividad;

public class SumarElementosDivideYVenceras {
	
	public static int suma(int[] arr) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return sumaDV(arr, 0, arr.length-1);
	}

	private static int sumaDV(int arr[], int a, int b) {
		if(a == b) {
			return arr[a];
		}
		int sumaI = 0;	//Suma por izquierda
		int sumaD = 0;	//Suma por derecha
		int medio = (b-a)/2;	//Mitad de arreglo
		sumaI = sumaDV(arr, a, a + medio);	//Derecha
		sumaD = sumaDV(arr, a+medio + 1, b);	//Izquierda
		
		return sumaI + sumaD;	//Devuelve suma de izquierda y derecha
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] e = {11,8,2,5,10};
		
		try {
			System.out.println(suma(e));
		} catch (EListaVacia e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
