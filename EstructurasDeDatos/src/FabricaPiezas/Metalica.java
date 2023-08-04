package FabricaPiezas;

public class Metalica extends Pieza{

	public Metalica(double pesoU, String codigo, String descripcion) {
		super(pesoU, codigo, descripcion);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularCosto() {
		return 2.8*pesoU+56;
	}


}
