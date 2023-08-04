package TemaNuevo;

public interface FiguraGeometrica {
	public double area();
	public double perimetro();
}


class Circulo implements FiguraGeometrica{
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void serRadio(double radio) {
		this.radio = radio;
	}
	
	public double area() {
		return Math.pow(radio,2)*Math.PI;
	}
	
	public double perimetro() {
		return 2*Math.PI*radio;
	}
	
	public String toString() {
		return "Circulo de radio: " + radio;
	}
	
}
