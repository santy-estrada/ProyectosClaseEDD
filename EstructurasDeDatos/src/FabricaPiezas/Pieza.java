package FabricaPiezas;

public abstract class Pieza {
	protected double pesoU;
	protected String codigo;
	protected String descripcion;
	
	public Pieza(double pesoU, String codigo, String descripcion){
		this.pesoU = pesoU;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	protected abstract double calcularCosto();
	
	protected String getCodigo() {
		return codigo;
	}
	
	protected double getPesoU() {
		return pesoU;
	}
	
	protected String getDescripcion() {
		return descripcion;
	}
	
	
	
}
