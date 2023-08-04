package ProyectoBiblioteca;

public class Ejemplar {
	private static int Codigo = 1;
	
	private int id;
	private String codigoL;
	private boolean Disponibilidad;
	private boolean Estado;
	
	public Ejemplar(String codigoL) {
		this.Disponibilidad = true;
		this.Estado = true;
		id = Codigo;
		Codigo ++;
		this.codigoL = codigoL + id;

	}
	
	public int getId() {
		return id;
	}
	
	public String getCodigoCompleto() {
		return codigoL;
	}
	
	public boolean getDisponilidad() {
		return Disponibilidad;
	}
	
	public boolean getEstado() {
		return Estado;
	}
	
	public void setEstado(boolean Estado) {
		this.Estado = Estado;
	}
	
	public void setDisponibilidad(boolean Disponibilidad) {
		this.Disponibilidad = Disponibilidad;
	}
}
