package Recursividad;

public class MaximoRecursivo {

	private static int maxR(int arr[], int n) {
		if(n == arr.length-1) {
			return arr[arr.length-1];
		}
		
		return Math.max(arr[n], maxR(arr, n+1));
	}
	
	public static int maxN(int arr[]) throws EListaVacia {
		if(arr == null || arr.length == 0) {
			throw new EListaVacia();
		}
		return maxR(arr, 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {100,-98,-1,500};
		
		try {
			System.out.println(maxN(a));
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
