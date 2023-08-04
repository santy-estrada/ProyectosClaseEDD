package FabricaPiezas;

public class Plastica extends Pieza{

	public Plastica(double pesoU, String codigo, String descripcion) {
		super(pesoU, codigo, descripcion);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularCosto() {
		return 1.3*pesoU+30;
	}

}
