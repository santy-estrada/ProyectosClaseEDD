package FabricaPiezas;
import java.util.Arrays;


public class Mixta extends Pieza{
	
	private Pieza piezas[];
	
	public Mixta(double pesoU, String codigo, String descripcion, Pieza piezas[]) {
		super(pesoU, codigo, descripcion);
		// TODO Auto-generated constructor stub
		if(piezas != null) {
			this.piezas=piezas;
		}else {
			this.piezas = new Pieza[0];
		}
	}
	
	public Mixta(double pesoU, String codigo, String descripcion) {
		super(pesoU, codigo, descripcion);
		//piezas = new Pieza[0];
	}
	
	public void addPieza(Pieza p) {
		if(piezas == null) {
			piezas = new Pieza[1];
		}else {
			piezas = Arrays.copyOf(piezas, piezas.length+1);
		}
		
		piezas[piezas.length-1] = p;
		
	}
	
	public double calcularCosto() {
		double costo;
		if(piezas.length != 0 && piezas != null) {
			costo = 0;
			for(Pieza p: piezas) {
				costo += p.calcularCosto();
			}
		}else {costo = -1;}
		
		return costo;
	}

}
