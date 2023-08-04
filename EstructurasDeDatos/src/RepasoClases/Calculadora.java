package RepasoClases;

public class Calculadora {
	
	
	public static int mcd(int a, int b) {
		while(a!=b) {
			if(a>b) {
				a-=b;
			}else {
				b-=a;
			}
		}
		return a;
	}
	
	public static int fact(int n) {
		if(n < 0) {
			System.out.println("No existe factorial de un negativo");
			return n;
		}else {
			int r = 1;
			for(int i = 2; i<=n; i++) {
				r*=i;
			}
			return r;
		}
	}
	
	
	
    public static void main(String[] args) {
        System.out.println(Calculadora.mcd(3,15));
        System.out.println(Calculadora.fact(-2));
    }
    
    
    
    
    
}



