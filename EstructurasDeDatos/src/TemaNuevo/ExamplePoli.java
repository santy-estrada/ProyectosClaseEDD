package TemaNuevo;

abstract class Cero{
	abstract public int suma();
	abstract public int multiplicacion();
}

class Uno extends Cero{
	
	protected int n1;
	protected int n2;
	
	public Uno(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public int suma() {
		// TODO Auto-generated method stub
		return n1+n2;
	}

	@Override
	public int multiplicacion() {
		// TODO Auto-generated method stub
		return n1*n2;
	}
	
	
}

class Dos extends Uno{
	
	private int n3;
	
	public Dos(int n1, int n2, int n3) {
		super(n1, n2);
		this.n3 = n3;
	}
 
	@Override
	public int suma() {
		// TODO Auto-generated method stub
		return n1+n2+n3;
	}
	
	
	public int calculararo() {
		return n3*2+n2*3;
	}
}


public class ExamplePoli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cero[] lista = new Cero[3];
		
		lista[0] = new Uno(3,2);
		
		lista[1] = new Uno(5,6);
		
		lista[2] = new Dos(1,4,7);

		
		System.out.println(lista[0].multiplicacion());
		System.out.println(lista[2].suma());
		System.out.println(((Dos)lista[2]).calculararo());
	}
	
	

}
