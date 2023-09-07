package Estudio;

import java.math.BigInteger;

public class Parciales {

	public static void p2023_1(int[] a) {
		int cont = 0;
		int j = a.length/2;
		for(int i = 0; i<a.length; i++) {
			
			if(i == a.length/2) {
				while(j<a.length) {
					cont++;
					j++;
					
				}
				System.out.println(cont);
				return;
			}else {
				System.out.println(" ");
				
			}
		}
	}
	
	public static int p2022_1(String[] list) {
		int cont = 0;
		int acum=0;
		int l=list.length;
		for (int i=0;i<l;i+=2) {
			
			for (int j=0;j<2;j++) {
				
				int temp=0;
				if (j==0) {
					temp+=1;
					
				}else {
					
					int mod=j%2;
					if (mod==0) {
						
						temp+=10;
					}else {
						
						int t=l/2;
						temp+=t;
					}
				}
				cont ++;
				acum+=temp;
			}
			}
		return cont;
	}
	
	public static void y(int[] a) {
		for(int i = 0; i<a.length; i++) {
			int j = 0;
			while(j<a.length) {
				System.out.println("Este es el índice: " + j + "elemento: " + a[j]);
				j = j*10;
			}
			if(a[i] > 0) {
				System.out.println(a[j]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a= {0,1,2,3,4};
		p2023_1(a);
		
		String[] str = {"a", "b", "c", "d" , "b", "c"};
		System.out.println(p2022_1(str));
		
		BigInteger b = new BigInteger("6000009");
		BigInteger c = new BigInteger("5499994500000");
		System.out.println(b.add(c));
		
		y(a);
	}

}
