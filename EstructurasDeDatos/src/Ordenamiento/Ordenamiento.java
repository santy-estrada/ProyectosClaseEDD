package Ordenamiento;


public class Ordenamiento {
	
	public static void shortBubble(Comparable[] a) {
		//Bandera para indicar si hacer o no otra iteración
		boolean flag = true;
		int len = a.length-1;
		while(len > 0 && flag) {
			flag = false;	//Se marca de una que ya no van a haber más iteraciones
			for(int i = 0; i < len; i++) {
				if(a[i].compareTo(a[i+1]) > 0) {
					flag = true;	//Si hubo al menos un cambio, hace otra iteración
					Comparable temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			len--;
		}
		
	}
	public static void bubbleSort(int[] a) {
		for(int i = 0; i<a.length-1; i++) {
			for(int j=0; j < a.length-1-i; j++) {
				if(a[j+1] < a[j]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort(Comparable[] a) {
		for(int i = 0; i < a.length-1; i++) {
			for(int j = 0; j<a.length-1-i; j++) {
				if(a[j+1].compareTo(a[j]) < 0) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void printLista(Comparable[] lista) {
		if(lista != null) {
			for(Comparable p : lista) {
				System.out.println(p + " ");
			}
			System.out.println();
		}
	}
	
	public static void selectionSort(Comparable[] a) {
		for(int i = 0; i <a.length-1; i++) {
			int im = i;
			for(int j = i+1; j<a.length; j++) {
				if(a[j].compareTo(a[im]) < 0) {
					im = j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
	}
	
	public static void insertSort(Comparable[] a) {
		for(int i = 1; i<a.length; i++) {
			Comparable temp = a[i];		//Valor a insertar
			int j = i;
			while(j> 0 && temp.compareTo(a[j-1])<0) {
				a[j] =a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] e = {5,2,3,4};
		String[] str = {"Juan", "Felipe", "Santiago", "Ana", "Anastasia"};
		
		shortBubble(e);
		shortBubble(str);
		
		printLista(e);
		printLista(str);

	}

}
