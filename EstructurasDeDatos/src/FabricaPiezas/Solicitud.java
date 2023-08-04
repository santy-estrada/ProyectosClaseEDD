package FabricaPiezas;

import java.util.Date;

public class Solicitud {
	private String codigo;
	private Pieza pieza;
	private Date fechaSolicitud;
	private int cantidadFabricar;
	private boolean cumplida;
	
	public Solicitud(String codigo, Pieza pieza, int cantidadFabricar) throws ECantidadImposible{
		this.codigo = codigo;
		this.pieza = pieza;
		this.cumplida = false;
		this.fechaSolicitud = new Date();
		
		if (cantidadFabricar < 1) {
			throw new ECantidadImposible("La cantidad a fabricar debe ser mayor a 0");
		}else {
			this.cantidadFabricar = cantidadFabricar;
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Pieza getCodigoPieza() {
		return pieza;
	}
	
	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	
	public int getCantidadFabricar() {
		return cantidadFabricar;
	}
	
	public boolean getCumplida() {
		return cumplida;
	}
	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	
	
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public void setCantidadFabricar(int cantidadFabricar) throws ECantidadImposible{
		if(cantidadFabricar > 0) {
			this.cantidadFabricar = cantidadFabricar;
		}else {
			throw new ECantidadImposible("La cantidad a fabricar debe ser mayor a 0");
		}
	}
	
	public void setCumplida(boolean cumplida) {
		this.cumplida = cumplida;
	}	
	
	public double getCosto() {
		return pieza.calcularCosto()*cantidadFabricar;
	}

	
	
}
