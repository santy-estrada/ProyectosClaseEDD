package Arboles;

public class NodoB <E extends Comparable <E>>	{

	protected E llave;
	protected NodoB <E> hijoI;
	protected NodoB<E>	hijoD;
	
	protected NodoB<E> padre;
	
	public NodoB(E llave) {
		this.llave = llave;
		padre = null;
		hijoI = null;
		hijoD = null;
	}
	
	public NodoB(E llave, NodoB<E> hijoI, NodoB<E> hijoD, NodoB<E> padre) {
		this.llave = llave;
		this.hijoD = hijoD;
		this.hijoI = hijoI;
		this.padre = padre;
	}
	
	
	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	public NodoB<E> getHijoI() {
		return hijoI;
	}

	public void setHijoI(NodoB<E> hijoI) {
		if(hijoI != null) {
			hijoI.setPadre(this);
		}
		this.hijoI = hijoI;
	}

	public NodoB<E> getHijoD() {
		return hijoD;
	}

	public void setHijoD(NodoB<E> hijoD) {
		if(hijoD != null) {
			hijoD.setPadre(this);
		}
		
		this.hijoD = hijoD;
	}


	public NodoB<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}
	
	public int altura() {
		return altura(this);
	}
	
	private int altura(NodoB<E> h) {
		if(h == null) {
			return -1;
		}
		
		int alturaI = 1 + altura(h.getHijoI());
		int alturaD = 1 + altura(h.getHijoD());
		
		return Math.max(alturaI, alturaD);
		
	}
	
	@Override
	public String toString() {
		return "NodoB [llave=" + llave + "]";
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
