package RepasoClases;

public class Main1 {
	public static void main(String[] args) {
		double a = 45;
		double b = 45;
		double c = 45;
		if (a+b <= c || a+c <= b || b+c <= a) {
			System.out.println("Tri�ngulo inv�lido");
		}else {
			Triangulo t1 = new Triangulo(a,b,c);
			System.out.print("Per�metro: ");
			System.out.println(t1.get_per());
			
			System.out.print("Clasificaci�n: ");
			System.out.println(t1.get_tipo());
			
			System.out.print("�rea: ");
			System.out.println(t1.get_area());
		}
	}
}
