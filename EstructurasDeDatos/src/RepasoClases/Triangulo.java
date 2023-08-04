package RepasoClases;

public class Triangulo{
	private double L1 = 0;
	private double L2 = 0;
	private double L3 = 0;
	private double area = 0;
	private double per = 0;
	double s = 0;
	public Triangulo(double L1, double L2, double L3) {
		if(val(L1,L2,L3)) {
			this.L1 = L1;
			this.L2 = L2;
			this.L3 = L3;
		}else {
			System.out.println("Triángulo inválido");
		}
	}
	
	public double get1() {
		return L1;
	}
	
	public double get2() {
		return L2;
	}
	
	public double get3() {
		return L3;
	}
	
	public void set1(double a) {
		if(val(a,L2,L3)) {
			L1 = a;
		}else {
			System.out.println("Triángulo inválido");
		}
	}
	
	public void set2(double b) {
		if(val(L1,b,L3)) {
			L2 = b;
		}else {
			System.out.println("Triángulo inválido");
		}
	}
	
	public void set3(double c) {
		if(val(L1,L2,c)) {
			L3 = c;
		}else {
			System.out.println("Triángulo inválido");
		}
	}
	
	private boolean val(double a, double b, double c) {
		boolean v = true;
		if (a+b < c || a+c < b || b+c < a) {
			v = false;
		}
		return v;
	}
	
	public char get_tipo() {
		return (L1 == 0 || L2 ==0 || L3 ==0)? 'f':(L1 == L2 && L2 == L3)? 'q': (L1 == L2 || L1 == L3 || L2 == L3)? 'i': 'e';
	}
	
	public double get_per () {
		per = L1 + L2 + L3;
		return per;
	}
	
	public double get_area() {
		s = get_per()/2;
		area = Math.sqrt(s*(s-L1)*(s-L2)*(s-L3));
		return area;
	}
	
	
	public static void main(String[] args) {
		double a = 45;
		double b = 45;
		double c = 45;
		Triangulo t1 = new Triangulo(a,b,c);
		System.out.print("Perímetro: ");
		System.out.println(t1.get_per());
		
		System.out.print("Clasificación: ");
		System.out.println(t1.get_tipo());
			
		System.out.print("Área: ");
		System.out.println(t1.get_area());
		
		System.out.println("-----------------------");
		
		double d = 16;
		double e = 22;
		double f = 40;
		Triangulo t2 = new Triangulo(d,e,f);
		System.out.print("Perímetro: ");
		System.out.println(t2.get_per());
			
		System.out.print("Clasificación: ");
		System.out.println(t2.get_tipo());
			
		System.out.print("Área: ");
		System.out.println(t2.get_area());
	}
}