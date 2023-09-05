package Busqueda;

public class Secuencial {
	
	//Búsqueda lineal
	public static int busqueda(Comparable[] ps, Comparable p3) {
		int i = 0;
		while(i<ps.length && ps[i].compareTo(p3) != 0) i++;
		
		return(i == ps.length)? -1: i;
	}
	
	//Búsqueda a partir de un índice
	public static int searchIndex(Comparable[] a, Comparable e, int index) throws EIndexImposible{
		if(index >= a.length) {
			throw new EIndexImposible();
		}
		
		while(index < a.length && a[index].compareTo(e) != 0) index++;
		
		return(index == a.length)? -1: index;
	}
	
	//Búsqueda del más cercano a partir de un índice
	public static int searchIndexClosest(int[] a, int e, int index) throws EIndexImposible{
		if(index >= a.length) {
			throw new EIndexImposible();
		}
		int auxI = index;
		while(index < a.length && a[index] != e) {
			if(Math.abs(a[index]-e) < Math.abs(a[auxI]-e)) {
					auxI = index;
			}
			
			if(Math.abs(a[index]-e) == Math.abs(a[auxI]-e) && a[index] < a[auxI]) {
				auxI = index;
			}
			
			index++;
		}
		return (index == a.length)? auxI: index;
	}
	
	//Búsqueda del más cercano recursivamente
	private static int searchClosestR(int a[], int e, int aux, int index, int i, int j) {
		if(i > j) {
			return aux;
		}
		
		if(a[index] == e) {
			return index;
		}
		
		if(Math.abs(a[index]-e) < Math.abs(a[aux]-e)) {
			aux = index;
		}
	
		if(Math.abs(a[index]-e) == Math.abs(a[aux]-e) && a[index] < a[aux]) {
			aux = index;
		}
		
		//Tomar mitdad inferior
		if(a[index] > e) {
			j = index -1;
			return searchClosestR(a, e, aux, (j-i)/2, i, j);
		}else {
			i = index +1;
			return searchClosestR(a, e, aux, (j+i)/2, i, j);
		}
		
	}
	
	public static int searchClosest(int a[], int e) {
		int j = a.length-1;
		return searchClosestR(a, e, 0, j/2,0,j);
	}
	
	//Búsqueda binaria iterativa
	public static int busquedaBinariaI(Comparable[] a, Comparable e) {
		int i = 0;
		int j = a.length -1;
		int index = (j-i)/2;
		int result = -1;
		while(i <= j && result == -1) {
			if(a[index].compareTo(e) > 0) {
				j = index -1;
				index = (j-i)/2;
			}else if(a[index].compareTo(e) < 0){
				i = index +1;
				index = (j+i)/2;
			}else {
				result = index;
			}
		}
		
		return result;
	}

	//Búsqueda binaria recursiva
	private static int busquedaBinariaR(Comparable[]a, Comparable e, int index, int i, int j) {
		if(a[index].compareTo(e) == 0) {
			return index;
		}
		if(i > j) {
			return -1;
		}
		
		if(a[index].compareTo(e) > 0) {
			j = index -1;
			return busquedaBinariaR(a, e, (j-i)/2, i, j);
		}else {
			i = index +1;
			return busquedaBinariaR(a, e, (j+i)/2, i, j);
		}
	}
	
	public static int binarySearch(Comparable[] a, Comparable e) {
		int j = a.length-1;
		return busquedaBinariaR(a, e,j/2,0,j);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = {0,1,2,3};

		//Búsqueda binaria
		System.out.println(busquedaBinariaI(arr, 5));
		System.out.println(binarySearch(arr, 5));
		
		//Búsqueda con índice
		try {
			System.out.println(searchIndex(arr, 0,1));
		} catch (EIndexImposible e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//Búsqueda del más cercano
		int a[] = {1,6,9,8,0,3,4};
		try {
			System.out.println(searchIndexClosest(a, 10, 0));
		} catch (EIndexImposible e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int b[] = {0,1,3,4,6,8,9, 400};
		System.out.println(searchClosest(b, 400));
	
	}

}
