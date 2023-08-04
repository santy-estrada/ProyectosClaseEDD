package RepasoClases;
import java.util.Arrays;
public class Arreglos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {1,2,3,4};
		int[] d = {0,0,0,0,0,0};
		System.arraycopy(c, 2, d, 3, c.length-2);//Copia los elementos de c desde la posición 2 en d desde la posición 3. La canitadad de elemntos es longitud de c menos 2
		
		for(int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		System.out.println("______________");
		
		int[] y = new int[1];
		y[0]=4;
		System.out.println(y.length);
		y = Arrays.copyOf(y, y.length+1);
		System.out.println(y.length);
		System.out.println();
		
		for(int i =0; i<y.length; i++) {
			System.out.println(y[i]);
		}

	}

}
