package ProyectoBiblioteca;
import java.util.Date;

public class Prestamo {
	private static int Codigo = 1;
	
	private int id;
	private Ejemplar Ejemplar;
	private Date Fecha1;
	private Date Fecha2;
	private User Usuario;
	
	public Prestamo(Ejemplar Ejemplar, User Usuario) {
		this.Fecha1 = new Date();
		this.Ejemplar = Ejemplar;
		this.Usuario = Usuario;
		this.id = Codigo;
		Codigo++;
		Ejemplar.setDisponibilidad(false);
	}
	
	//set
	public void setEjemplar(Ejemplar Ejemplar) {
		this.Ejemplar = Ejemplar;
	}
	
	public void setUsuario(User Usuario) {
		this.Usuario = Usuario;
	}
	
	public void setFechaPrestamo(Date Fecha1) {
		this.Fecha1 = Fecha1;
	}
	
	public void setFechaEntrega(Date Fecha2) {
		this.Fecha2 = Fecha2;
	}
	
	//get
	public int getId() {
		return id;
	}
	
	public Ejemplar getEjemplar() {
		return Ejemplar;
	}
	
	public User getUsuario() {
		return Usuario;
	}
	
	public Date getFechaPrestamo() {
		return Fecha1;
	}
	
	public Date getFechaEntrega() {
		return Fecha2;
	}
	
}
