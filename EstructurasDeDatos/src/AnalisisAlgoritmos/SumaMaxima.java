package AnalisisAlgoritmos;

public class SumaMaxima {

	public static int subsecuenciaSumaMaxima(int[]a) {
		
		int sumaMax = 0;	//Valor máximo
		int aux = 0;	//maximo auxiliar
		int b = 0;	//beginning
		int e = 0;	//end
		boolean flag = true;	//Permite determinar el principio de la subsecuencia
 
        for (int i = 0; i < a.length; i++) {
        	
        	aux += a[i];	//acumula los valores
        
            if (sumaMax < aux) {	//Si la sumaMax es menor que la suma auxiliar
            	if(flag) {			//Si va a empezar una subsecuencia
            		b = i;			//Subsecuencia empieza en i
            		flag = false;	//ya empezó la subsecuencia
            	}
            	sumaMax = aux;		//sumaMax toma el valor del auxiliar
            	e = i;				//Marca que acaba la subsecuencia en la pos i
            }
            
            if (aux < 0) {		//Si se acumuló un valor negativo
            	aux = 0;		//Reset
            	flag = true;	//Puede empezar una nueva secuencia 
            }
            
        }
        System.out.println(b);
        System.out.println(e);

        return sumaMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1,-21,-3,4,-5,6};
		System.out.println(subsecuenciaSumaMaxima(a));
	}
}
