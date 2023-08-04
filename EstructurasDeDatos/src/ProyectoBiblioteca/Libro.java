package ProyectoBiblioteca;

import java.util.Arrays;

public class Libro {
	private String Titulo;
	private String[] Autores;
	private String[] Genero;
	private Ejemplar[] Ejemplares;
	private String Codigo;
	
	public Libro(String Titulo, String[] Autores, String Genero[], int Ejemplares, String Codigo) {
		this.Titulo = Titulo;
		this.Autores = Autores;
		this.Genero = Genero;
		this.Codigo = Codigo;
		this.Ejemplares = new Ejemplar[0];
		addEjemplares(Ejemplares);
	}
	//Get
	public String getTitulo() {
		return Titulo;
	}
	
	public String[] getAutores() {
		return Autores;
	}
	
	public String[] getGenero() {
		return Genero;
	}
	
	public Ejemplar[] getEjemplares() {
		return Ejemplares;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	
	//Set
	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}
	
	public void setAutores(String[] Autores) {
		this.Autores = Autores;
	}
	
	public void setGenero(String Genero[]) {
		this.Genero = Genero;
	}
	
	public void setEjemplares(Ejemplar[] ejemplares) {
		this.Ejemplares = ejemplares;
	}

	
	//Add
	private void addEjemplar() {
		Ejemplar e = new Ejemplar(Codigo);
		this.Ejemplares = Arrays.copyOf(this.Ejemplares, this.Ejemplares.length+1);
		this.Ejemplares[this.Ejemplares.length-1] = e;
	}
	
	public void addEjemplares(int cant) {
		for(int i = 0; i < cant; i++) {
			addEjemplar();
		}
		System.out.println("Ejemplar(es) a�adido correctamente");
	}

	
	//Search
	public boolean searchAutor(String Autor) {
		int index = 0;
		
		while(index < Autores.length && !Autor.toLowerCase().equals(Autores[index].toLowerCase())) {
			index++;
		}		
		return (index < Autores.length)? true: false;
	}
	
	public boolean searchGenero(String Genero) {
		int index = 0;
		
		while(index < this.Genero.length && !Genero.equalsIgnoreCase(this.Genero[index])) {
			index++;
		}
		
		return (index < this.Genero.length)? true: false;
	}
	
	public int searchEjemplar(int id) { //Busca dado un id
		int index = 0;
		
		while(index < Ejemplares.length && id != Ejemplares[index].getId()) {
			index++;
		}
		
		return (index < Ejemplares.length)? index: -1;
	}
	
	public Ejemplar[] searchEjemplaresDisponibles() { //Busca ejemplares disponibles
		Ejemplar[] disponibles = new Ejemplar[0];
		for(Ejemplar e: Ejemplares){
			if(e.getDisponilidad() && e.getEstado()) {
				disponibles = Arrays.copyOf(disponibles, disponibles.length+1);
				disponibles[disponibles.length-1] = e;
			}
		}
		
		return disponibles;
	}
	
	
	//Del
	public void delEjemplar(int id) {
		int index = searchEjemplar(id);
		if(index !=-1) {	//Si s� existe el ejemplar
			if(index == 0) {// Si est� en la primera posici�n
				Ejemplar[] aux = new Ejemplar[this.Ejemplares.length-1];
				
				System.arraycopy(this.Ejemplares, 1, aux, 0, aux.length);//aux es this.Ejemplares excepto el primer ejemplar
				this.Ejemplares = Arrays.copyOf(aux, aux.length);	//this.Ejemplares se convierte en aux
				
			}else if (index == this.Ejemplares.length-1) {	//Si est� en la �ltima posici�n
				
				this.Ejemplares = Arrays.copyOf(this.Ejemplares, this.Ejemplares.length-1);
				///this.Ejemplares es s� mismo menos la �litma posici�n
				
			}else {// Si est� entre la primera y �ltima posic�on
				
				Ejemplar[] aux1 = new Ejemplar[index]; //aux1 con posiciones igual al �ndice
				Ejemplar[] aux2 = new Ejemplar[this.Ejemplares.length-index-1];
				//aux2 con posiciones de this.Ejemplares menos el �nidce y menos 1 posici�n
				//total de posiciones = this.Ejemplares.length-1
				
				System.arraycopy(this.Ejemplares, 0, aux1, 0, aux1.length);
				//aux1 son todos los Ejemplares de this.Ejemplares hasta el que se quiere eliminar (sin incluir)
				System.arraycopy(this.Ejemplares, index+1, aux2, 0, aux2.length);
				//aux2 son todos los Ejemplares de this.Ejemplares desde el que se quiere eliminar (sin incluir)
				
				this.Ejemplares = Arrays.copyOf(this.Ejemplares, this.Ejemplares.length-1); //Quitar una posici�n
				
				System.arraycopy(aux1, 0, this.Ejemplares, 0, aux1.length);
				//this.Ejemplares toma los valores de aux1 desde 0
				System.arraycopy(aux2, 0, this.Ejemplares, index, aux2.length);
				//this.Ejemplares toma los valores de aux2 desde el indice del elemento que se quer�a eliminar
			}

		}else {
			System.out.println("El ejemplar no existe");
		}
	}
	
	
	public int countEjemplares() {
		return Ejemplares.length;
	}
	
	
}
