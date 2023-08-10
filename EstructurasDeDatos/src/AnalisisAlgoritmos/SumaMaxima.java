package AnalisisAlgoritmos;

public class SumaMaxima {

	public static int[] subsecuenciaSumaMaxima(int[]a) {
		
		int[] Vals = new int[3]; //Arrglo de valores: maxSuma, inicio, fin
		int aux = 0;	//maximo auxiliar
		boolean flag = true;	//Permite determinar el principio de la subsecuencia
 
        for (int i = 0; i < a.length; i++) {
        	
        	aux += a[i];	//acumula los valores
        
            if (Vals[0] < aux) {	//Si la sumaMax es menor que la suma auxiliar
            	if(flag) {			//Si va a empezar una subsecuencia
            		Vals[1] = i;			//Subsecuencia empieza en i
            		flag = false;	//ya empezó la subsecuencia

            	}
            	Vals[0] = aux;		//sumaMax toma el valor del auxiliar
            	Vals[2] = i;				//Marca que acaba la subsecuencia en la pos i
            	System.out.println("b");

            }
            
            if (aux < 0) {		//Si se acumuló un valor negativo
            	aux = 0;		//Reset
            	flag = true;	//Puede empezar una nueva secuencia 
            	System.out.println("a");
            }
            
        }

        return Vals;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,-2,3,-4,5,-6,7};
		for(int i: subsecuenciaSumaMaxima(a)) {
			System.out.println(i);

		}
	}
}
