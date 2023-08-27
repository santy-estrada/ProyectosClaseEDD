package Recursividad;

import java.util.Arrays;

public class Pares {
	
	public static int cantPares(int[] arr) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return countPares(arr, 0, 0);
	}
	
	private static int countPares(int[] arr, int index, int cant) {
		if(arr[index] % 2 == 0) {
			cant ++;
		}
		if(index == arr.length -1) {
			return cant;
		}
		return countPares(arr, index+1, cant);
		
	}
	
	//Sin usar count pares
	public static int[] listPares(int arr[]) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return pares(arr, 0, new int[0]);
	}
	
	private static int[] pares(int[] arr, int index, int[] pares) {
		if(arr[index] % 2 == 0) {
			pares = Arrays.copyOf(pares, pares.length+1);
			pares[pares.length-1] = arr[index];
		}
		if(index == arr.length -1) {
			return pares;
		}
		return pares(arr, index+1, pares);
	}
	
	//Usando count pares
	public static int[] listPares2(int arr[]) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		
		return pares2(arr, 0, new int[cantPares(arr)], 0);
	}
	
	private static int[] pares2(int[] arr, int index, int[] pares, int pos) {
		if(arr[index] % 2 == 0) {
			pares[pos] = arr[index];
			pos++;
		}
		if(index == arr.length -1) {
			return pares;
		}
		return pares2(arr, index+1, pares, pos);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {16,1,3,1, 50, 368};
		
		try {
			int[] pares = listPares(arr);
			int[] pares2 = listPares2(arr);
			System.out.println("Cantidad de pares: " +cantPares(arr));
			System.out.println();
			for(int i: pares) {
				System.out.println(i);
			}
			System.out.println();
			for(int i: pares2) {
				System.out.println(i);
			}
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
