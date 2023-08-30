package Recursividad;

public class SumaMatriz {
	
	public static int sumaMatriz(int[][] matriz) throws EListaVacia {
		if(matriz == null) {
			throw new EListaVacia();
		}
		
		return sumaMatrizRecursiva(matriz, 0, matriz.length, 0, matriz[0].length);
	}
	
	//a y b son para filas; i y j son para columnas
	//a es índice en filas, i es índice en columnas
	private static int sumaMatrizRecursiva(int[][] matriz, int a, int b, int i, int j) {
	
		if ( b== 1 && j == 1) {	//Cuando la longitud de la matriz se redujo a 1x1
	        return matriz[a][i];	//Devolver el valor correspondiente
		}
		int medioColumnas = j/2;	// Mitad de la longitud de columnas (cant de columnas)
		int medioFilas = b/2;		// Mitad de la longitud de filas (cant de filas)
		
		//Primero se dividirá la matriz en sus filas
	    if (b == 1) {	//Cuando la matriz sólo tiene una fila
	    	//Dividir la fila a la mitad
	    	//Primer sumando: Divide el arreglo hasta la mitad de su longitud con b = 1, a = pos de fila, i = posición columna, j = mitad del arreglo
	    	// Segundo sumando: mantiene b = 1 y a pos de la fila. i = posición den la columna que debe empezar donde terminó la anterior, j = longitud original del arreglo - mitad
	    	return sumaMatrizRecursiva(matriz, a, b, i, medioColumnas) + sumaMatrizRecursiva(matriz, a, b, i + medioColumnas, j - medioColumnas);
	    
	    } else {
	    	//Dividir la matriz en filas
	    	//Primer sumando: toma las filas desde a hasta la mitad de filas
	    	//Segundo sumando: toma las filas despúes del primer sumando. b es el # de filas que quedan
	        return sumaMatrizRecursiva(matriz, a, medioFilas, i, j) + sumaMatrizRecursiva(matriz, a + medioFilas, b - medioFilas, i, j);
	    }
	}
	
	public static int sumaMatrizIndex(int[][] matriz) {
		return sumaMitIndex(matriz, 0, 0, 0);
	}
	
	private static int sumaMitIndex(int matriz[][], int i, int j, int totalSum) {
		if(i == matriz.length-1) {
			if(j == matriz[0].length-1) {
				return matriz[i][j];
			}
			return matriz[i][j] + sumaMitIndex(matriz, 0, j+1, totalSum);
		}
		
		return matriz[i][j] + sumaMitIndex(matriz, i+1, j, totalSum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matriz[][] = {{1,2,3,9},{1,2,3,7}};

		try {
			System.out.println(sumaMatriz(matriz));
			System.out.println(sumaMatrizIndex(matriz));
		} catch (EListaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
