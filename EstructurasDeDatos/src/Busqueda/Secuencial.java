package Busqueda;

public class Secuencial {
	
	public static int busqueda(Comparable[] ps, Comparable p3) {
		int i = 0;
		while(i<ps.length && ps[i].compareTo(p3) != 0) i++;
		
		return(i == ps.length)? -1: i;
	}
	
	public static int searchIndex(Comparable[] a, Comparable e, int index) throws EIndexImposible{
		if(index >= a.length) {
			throw new EIndexImposible();
		}
		
		while(index < a.length && a[index].compareTo(e) != 0) index++;
		
		return(index == a.length)? -1: index;
	}
	
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
		System.out.println(busquedaBinariaI(arr, 5));
		System.out.println(binarySearch(arr, 5));
	}

}
