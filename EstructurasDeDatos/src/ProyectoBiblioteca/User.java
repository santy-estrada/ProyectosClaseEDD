package ProyectoBiblioteca;

public class User {
	private String CC;
	private String Nombre;
	private boolean Mora;
	
	public User(String CC, String Nombre) {
		this.CC = CC;
		this.Nombre = Nombre;
		this.Mora = false;
	}
	
	
	public String getNombre(){
		return Nombre;
	}
	
	public String getCC() {
		return CC;
	}
	
	public boolean getMora() {
		return Mora;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setCC(String CC) {
		this.CC = CC;
	}
	
	public void setMora(boolean Mora) {
		this.Mora = Mora;
	}
}
