package Ejercicios;

public class igualarArrays {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr1 = {1,2,3};
		int []arr2 = {4,5,6,7};
		
		System.out.println(arr1[arr1.length-1]);
		
		arr1 = arr2;
		System.out.println(arr1[arr1.length-1]);
		
		Integer i = 1;
		int a = i;
		System.out.println(a);
		
		char c = 'h';
		
		switch(c) {
		case 'c':
			System.out.println(c);
			break;
		case 'd':
			System.out.println(a);
			break;
		default:
			System.out.println("no");

		}

	}
}
