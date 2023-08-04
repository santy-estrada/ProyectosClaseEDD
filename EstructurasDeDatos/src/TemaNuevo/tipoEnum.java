package TemaNuevo;

public class tipoEnum {
	//Enum básico
	public enum Precio{
		BARATO, MEDIO, CARO;
	}
	//Enum desarrollado
	public enum PrecioRango{
		
		BARATOS(0,10000), MEDIOS(10000,100000), CAROS(100000,1000000);
		
		private double min;
		private double max;
		
		private PrecioRango(double min, double max) {
			this.min = min;
			this.max = max;
		}
		
		public double getMin() {
			return min;
		}
		
		public void setMin(double min) {
			this.min = min;
		}
		
		public double getMax(){
			return max;
		}
		
		public void setMax(double max) {
			this.max = max;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear una variable tipo enum a partir de un string
		Precio precio = Precio.valueOf("CARO");
		
		switch(precio) {
		case BARATO:
			System.out.println("Es barato");
		break;
		case MEDIO:
			System.out.println("Es medio");
		break;
		case CARO:
			System.out.println("Es caro");
		break;
			
		}
		
		System.out.println();
		//Recorre todos los valores de precio e imprime su posición
		for( Precio pr: Precio.values()) {
			System.out.println(pr.name()+ " " + pr.ordinal());

		}

		System.out.println("----------------");
		
		PrecioRango p = PrecioRango.valueOf("CAROS");
		
		System.out.println(p.ordinal());
		System.out.println(p.getMin());
		System.out.println(p.getMax());
		
		System.out.println("----------------");

		//Prueba un valor que no existe en precios
		try {
			Precio.valueOf("X");
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("Valor no válido");

		}


	}

}
