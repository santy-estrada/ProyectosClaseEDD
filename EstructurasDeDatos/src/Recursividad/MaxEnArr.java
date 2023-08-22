package Recursividad;
//Divide y Venecer�s
public class MaxEnArr {

	public static int maximo(int arr[]) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return maxRec(arr, 0, arr.length-1);
	}
	
	private static int maxRec(int[] arr, int a, int b) {
		if(a == b) {
			return arr[a];
		}
		int medio =(b-a)/2;	//Mitad del arreglo
		int maxI = maxRec(arr, a, a + medio);	//Valor m�ximo por la izquierda (arreglo, posici�n inicial, posicion de la mitad del arreglo)
		int maxD = maxRec(arr, a+medio+1, b);//Valor m�ximo por la derecha (arreglo, 1+p�sici�n final anterior, posici�n final del arreglo)
		return Math.max(maxI, maxD);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,2,3,4,5};
		
		try {
			System.out.println(maximo(a));
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}

	}

}
