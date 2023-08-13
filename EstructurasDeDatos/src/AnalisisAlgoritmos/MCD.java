package AnalisisAlgoritmos;

public class MCD {
	
	public static int mcd(int m, int n) {
		int i = m+1;
		int cont = 0;
		do {
			i--;
			cont ++;
		}while(m%i != 0 || n%i != 0);
		
		return cont;
	}
	
	public static int euclides(int m, int n) {
		int r;
		int cont = 0;
		while(m >0) {
			r = n%m;
			n = m;
			m = r;
			cont ++;
		}
		
		return cont;
	}
	
	public static int fin(int a, int b, int n) {
		int cont = 0;
		for(int i = 1;i<n;i++) {
			if(i%2 != 0) {
				cont ++;
				for(int j = i+1; j<n; j=j+2) {
					//cont ++;

					if(j%2==0) {
						

					}
				}
			}
		}
		return cont;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(mcd(17,15265286));
		//System.out.println(euclides(17,43));
		System.out.println(fin(17,43,6));

	


	}

}
