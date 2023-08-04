package RepasoClases;

public class Main1 {
	public static void main(String[] args) {
		double a = 45;
		double b = 45;
		double c = 45;
		if (a+b <= c || a+c <= b || b+c <= a) {
			System.out.println("Triángulo inválido");
		}else {
			Triangulo t1 = new Triangulo(a,b,c);
			System.out.print("Perímetro: ");
			System.out.println(t1.get_per());
			
			System.out.print("Clasificación: ");
			System.out.println(t1.get_tipo());
			
			System.out.print("Área: ");
			System.out.println(t1.get_area());
		}
	}
}
