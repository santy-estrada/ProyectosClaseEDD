package Recursividad;

public class Divisibles3DyV {
	
	public static int div3(int[] arr) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return div3DyV(arr, 0, arr.length-1, 0);
	}
	
	private static int div3DyV(int[] arr, int a, int b, int cant) {
		if(a == b) {	//Para cuando los índices son iguales
			//Si es divisible entre 3 y no es 0
			if(arr[a]%3 == 0 && arr[a] != 0) {
				cant++;	//Suma 1 a la cantidad de divisibles entre 3
			}
			return cant;	//Devuelve la cantidad de divisibles entre 3
		}
		int cantI = 0;		//Cantidad de divisibles entre 3 por izquierda
		int cantD = 0;		//Cantidad de divisibles entre 3 por derecha
		int mitad = (b-a)/2;	//La mitad del subarreglo a analizar
		
		cantI = div3DyV(arr, a, a+mitad, cant);		//Cant por izquierda 
		cantD = div3DyV(arr, a+mitad+1,b, cant);	//Cant por derecha
		
		return cantI + cantD;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0,2,-3,4,5,6,99};
		
		try {
			System.out.println(div3(arr));
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
