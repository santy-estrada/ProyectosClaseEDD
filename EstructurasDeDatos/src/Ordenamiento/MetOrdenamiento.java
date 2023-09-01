package Ordenamiento;

import java.util.Arrays;
import java.util.Random;

public class MetOrdenamiento {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = 100000;
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for(int i = 0; i <N; i++) {
			lista[i] = r.nextInt(2*N);		//Aleatorios
			//lista[i] = N - i;	//Menor a mayor
			//lista[i] = i;	//Ordenados
		}
		
		Integer[] listaTemp = Arrays.copyOf(lista, lista.length);
		long timeInicio;
		long timeFin;
		
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.bubbleSort(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("BubbleSort: " + (timeFin-timeInicio));
		
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.shortBubble(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("Short bubble sort: " + (timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.selectionSort(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("Selection sort: " + (timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.insertSort(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("Insert sort: " + (timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.quickSort(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("Quick sort: " + (timeFin-timeInicio));
		
		listaTemp = Arrays.copyOf(lista, lista.length);
		timeInicio = System.currentTimeMillis();
		try {
			Ordenamiento.mergeSort(listaTemp);
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeFin = System.currentTimeMillis();
		System.out.println("Merge sort: " + (timeFin-timeInicio));
	}

}
