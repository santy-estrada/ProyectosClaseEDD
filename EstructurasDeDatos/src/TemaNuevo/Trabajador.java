package TemaNuevo;

public class Trabajador {
	protected String nombre;
	protected float sb;			//salario básico
	protected int dt;			//días trabajados
	
	public Trabajador(String nombre, float sb, int dt) {
		this.nombre = nombre;
		this.sb = sb;
		this.dt = dt;
	}
	
	public float salario() {
		return sb*dt/24;
	}
}

class EmpLimpieza extends Trabajador{
	private float norma;
	private float cump;
	
	public EmpLimpieza(String nombre, float sb, int dt, float norma, float cump) {
		super(nombre, sb, dt);
		this.norma = norma;
		this.cump = cump;
	}
	
	public float salario() {
		return super.salario()+super.salario()*(float)0.1*cump/norma;
	}
}