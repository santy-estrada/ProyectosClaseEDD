package Ordenamiento;


public class Ordenamiento {
	
	public static void shortBubble(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
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
	public static void bubbleSort(int[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
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
	
	public static void bubbleSort(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
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
	
	public static void printLista(Comparable[] lista) throws EListaVacia {
		if(lista == null || lista.length == 0) {
			throw new EListaVacia();
		}
		if(lista != null) {
			for(Comparable p : lista) {
				System.out.println(p + " ");
			}
			System.out.println();
		}
	}
	
	public static void selectionSort(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
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
	
	public static void insertSort(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
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
	
	public static void quickSort(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
		quick(a, 0, a.length-1);
	}
	
	private static void quick(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return;
		}
		else {
			Comparable pivote = a[fin];
			int i = inicio -1;
			int j = fin;
			Comparable temp;
			while(i < j) {
				//busca un elemento mayor que pivote, si no para en el pivote (el úlitmo)
				while(a[++i].compareTo(pivote) < 0);
				
				//Se busca un elemento menor que el pivote. Si no lo hay, para en el primero
				while(j > inicio && pivote.compareTo(a[--j]) < 0);
				
				if(i < j) {	//Intercambiar elementos
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}	
				
			}
			/*
			 * Se sale del cliclo cuando la i >= j. Si se cruzan los índices en la i, hay un
			 * elemento mayor que el pivote, la posición correcta del pivote es i, deben
			 * intercambiarse
			 */
			temp = a[i];
			a[i] = a[fin];
			a[fin] = temp;
			
			int partition = i;
			
			quick(a, inicio, partition - 1);
			quick(a, partition + 1, fin);
			
		}
	}
	
	public static Comparable[] mergeSort(Comparable[] a) throws EListaVacia {
		if(a == null || a.length == 0) {
			throw new EListaVacia();
		}
		return mergeSort(0, a.length-1, a);
	}
	
	private static Comparable[] mergeSort(int inicio, int fin, Comparable[] a) {
		if(inicio == fin) {
			return new Comparable[] {a[inicio]};
		}
		int mitad = (fin-inicio)/2;
		Comparable[] izquierda = mergeSort(inicio, inicio+mitad, a);
		Comparable[] derecha = mergeSort(inicio+mitad+1, fin, a);
		
		return merge(izquierda, derecha);
	}
	
	private static Comparable[] merge(Comparable[] a, Comparable[] b) {
		Comparable merged[] = new Comparable[a.length+b.length];
		int contA = 0;
		int contB = 0;
		int cont = 0;
		while(contA < a.length && contB < b.length) {
			if(a[contA].compareTo(b[contB]) <0) {
				merged[cont] = a[contA];
				cont++;
				contA++;
			}else if(a[contA].compareTo(b[contB]) > 0){
				merged[cont] = b[contB];
				cont++;
				contB++;
			} else {
				merged[cont] = a[contA];
				merged[cont+1] = b[contB];
				cont += 2;
				contB++;
				contA++;
			}
		}
		if(contA >= a.length && contB < b.length) {
			for(int i = contB; cont < merged.length; i++) {
				merged[cont] = b[i];
				cont++;
			}
		}
		
		if(contB >= b.length && contA < a.length) {
			for(int i = contA; cont < merged.length; i++) {
				merged[cont] = a[i];
				cont++;
			}
		}
		
		return merged;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] e = {5,2,3,4};
		String[] str = {"Juan", "Felipe", "Santiago", "Ana", "Anastasia"};
		
		try {
			printLista(mergeSort(e));
			printLista(mergeSort(str));

		} catch (EListaVacia e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
