package ProyectoBiblioteca;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Biblioteca {
	
	private static String abc= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	
	private String Nombre;
	private Libro Libros[];
	private User Usuarios[];
	private Prestamo Prestamos[];

	
	public Biblioteca(String Nombre) {
		this.Nombre = Nombre;
		Libros = new Libro[0];
		Usuarios = new User[0];
		Prestamos = new Prestamo[0];
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	//get
	public String getNombre() {
		return Nombre;
	}
	
	public Libro[] getLibros() {
		return Libros;
	}
	
	public User[] getUsuarios() {
		return Usuarios;
	}
	
	public Prestamo[] getPrestamos() {
		return Prestamos;
	}
	
	//Generar código
	private String generarCodigo() {
	    Random random = new Random();
	    
	    int l = 7;// longitud de código
	    int index;
	    String codigo = new String();
	    
	    for(int i = 0; i < l; i++) {
	      
	      index = random.nextInt(abc.length()); //indice aleatorio

	      char caracter = abc.charAt(index); //Caracter de indice aleatorio
	      codigo += caracter;		//Codigo resultante
	    }
	    
	    return codigo;

	}
	//Asegurar unicidad de código
	private boolean checkUnicidad(String codigo) {
		int index = 0;
		
		while(index < Libros.length && Libros[index] != null && !Libros[index].getCodigo().equals(codigo)) {
			index++;
		}
		
		return (index <= Libros.length)? true: false;	
	}
	
	//Add
	public void addLibro(String titulo, String[] autores, int cant, String[] genero) {
		Libros = Arrays.copyOf(Libros, Libros.length+1);
		String codigo = new String();
		
		do {
			codigo = generarCodigo();
		}while(!checkUnicidad(codigo));
		
		Libro l = new Libro(titulo, autores, genero, cant, codigo);
		Libros[Libros.length-1] = l;
		System.out.println("Libro añadido correctamente");
		
	}
	
	public void addUsuario(String cc, String nombre) {
		if(searchUsuario(cc) ==-1) {
			User u = new User(cc, nombre);
			Usuarios = Arrays.copyOf(Usuarios, Usuarios.length+1);
			Usuarios[Usuarios.length-1] = u;
			System.out.println("Usuario registrado correctamente");
		}else {
			System.out.println("La cédula ya está registrada");
		}
	}
	
	public void addEjemplarLibro(int indexL, int cant) {
		Libros[indexL].addEjemplares(cant);
	}
	
	//del
	public void delLibro(String codigo) {
		int index = searchLibroCodigo(codigo);

		if(index !=-1) {	//Si sí existe el libro
			System.out.println("Usted va a borrar los " + Libros[index].countEjemplares() + " ejemplares de este libro");
			if(index == 0) {// Si está en la primera posición
				Libro[] aux = new Libro[this.Libros.length-1];
				
				System.arraycopy(this.Libros, 1, aux, 0, aux.length);//aux es this.Libros excepto el primer libro
				this.Libros = Arrays.copyOf(aux, aux.length);	//this.Libros se convierte en aux
				
			}else if (index == Libros.length-1) {	//Si está en la última posición
				
				this.Libros = Arrays.copyOf(this.Libros, this.Libros.length-1);
				///this.Libros es sí mismo menos la úlitma posición
				
			}else {// Si está entre la primera y última posicíon
				
				Libro[] aux1 = new Libro[index]; //aux1 con posiciones igual al índice
				Libro[] aux2 = new Libro[this.Libros.length-index-1];
				//aux2 con posiciones de this.Libros menos el ínidce y menos 1 posición
				//total de posiciones = this.Libros.length-1
				
				System.arraycopy(this.Libros, 0, aux1, 0, aux1.length);
				//aux1 son todos los autores de this.Libros hasta el que se quiere eliminar (sin incluir)
				System.arraycopy(this.Libros, index+1, aux2, 0, aux2.length);
				//aux2 son todos los autores de this.Libros desde el que se quiere eliminar (sin incluir)
				
				this.Libros = Arrays.copyOf(this.Libros, this.Libros.length-1); //Quitar una posición
				
				System.arraycopy(aux1, 0, this.Libros, 0, aux1.length);
				//this.Autores toma los valores de aux1 desde 0
				System.arraycopy(aux2, 0, this.Libros, index, aux2.length);
				//this.Libros toma los valores de aux2 desde el indice del elemento que se quería eliminar
			}

		}else {
			System.out.println("El libro no existe");
		}
	}
	
	public void delUsuario(String cc) {
		int index = searchUsuario(cc);
		if(index !=-1) {	//Si sí existe el usuario
			if(index == 0) {// Si está en la primera posición
				User[] aux = new User[this.Usuarios.length-1];
				
				System.arraycopy(this.Usuarios, 1, aux, 0, aux.length);//aux es this.Usuarios excepto el primer usuario
				this.Usuarios = Arrays.copyOf(aux, aux.length);	//this.Usuarios se convierte en aux
				
			}else if (index == Usuarios.length-1) {	//Si está en la última posición
				
				this.Usuarios = Arrays.copyOf(this.Usuarios, this.Usuarios.length-1);
				///this.Usuarios es sí mismo menos la úlitma posición
				
			}else {// Si está entre la primera y última posicíon
				
				User[] aux1 = new User[index]; //aux1 con posiciones igual al índice
				User[] aux2 = new User[this.Usuarios.length-index-1];
				//aux2 con posiciones de this.Usuarios menos el ínidce y menos 1 posición
				//total de posiciones = this.Usuarios.length-1
				
				System.arraycopy(this.Usuarios, 0, aux1, 0, aux1.length);
				//aux1 son todos los usuarios de this.Usuarios hasta el que se quiere eliminar (sin incluir)
				System.arraycopy(this.Usuarios, index+1, aux2, 0, aux2.length);
				//aux2 son todos los Usuarios de this.Usuarios desde el que se quiere eliminar (sin incluir)
				
				this.Usuarios = Arrays.copyOf(this.Usuarios, this.Usuarios.length-1); //Quitar una posición
				
				System.arraycopy(aux1, 0, this.Usuarios, 0, aux1.length);
				//this.Usuarios toma los valores de aux1 desde 0
				System.arraycopy(aux2, 0, this.Usuarios, index, aux2.length);
				//this.Usuarios toma los valores de aux2 desde el indice del elemento que se quería eliminar
			}
			

		}else {
			System.out.println("El usuario no existe");
		}
	}
	
	public void delPrestamo(int id) {
		int index = searchPrestamoId(id);
		if(index !=-1) {	//Si sí existe el prestamo
			if(index == 0) {// Si está en la primera posición
				Prestamo[] aux = new Prestamo[this.Prestamos.length-1];
				
				System.arraycopy(this.Prestamos, 1, aux, 0, aux.length);//aux es this.Prestamos excepto el primer Prestamo
				this.Prestamos = Arrays.copyOf(aux, aux.length);	//this.Prestamos se convierte en aux
				
			}else if (index == Prestamos.length-1) {	//Si está en la última posición
				
				this.Prestamos = Arrays.copyOf(this.Prestamos, this.Prestamos.length-1);
				///this.Prestamos es sí mismo menos la úlitma posición
				
			}else {// Si está entre la primera y última posicíon
				
				Prestamo[] aux1 = new Prestamo[index]; //aux1 con posiciones igual al índice
				Prestamo[] aux2 = new Prestamo[this.Prestamos.length-index-1];
				//aux2 con posiciones de this.Prestamos menos el ínidce y menos 1 posición
				//total de posiciones = this.Prestamos.length-1
				
				System.arraycopy(this.Prestamos, 0, aux1, 0, aux1.length);
				//aux1 son todos los Prestamo de this.Prestamos hasta el que se quiere eliminar (sin incluir)
				System.arraycopy(this.Prestamos, index+1, aux2, 0, aux2.length);
				//aux2 son todos los Prestamos de this.Prestamos desde el que se quiere eliminar (sin incluir)
				
				this.Prestamos = Arrays.copyOf(this.Prestamos, this.Prestamos.length-1); //Quitar una posición
				
				System.arraycopy(aux1, 0, this.Prestamos, 0, aux1.length);
				//this.Prestamos toma los valores de aux1 desde 0
				System.arraycopy(aux2, 0, this.Prestamos, index, aux2.length);
				//this.Prestamos toma los valores de aux2 desde el indice del elemento que se quería eliminar
			}
			
		}else {
			System.out.println("El prestamo no existe");
		}
	}
	
	public void delEjemplarLibro(String codigo) {
		int[] index = searchEjemplar(codigo);
		int id = Integer.parseInt(codigo.substring(7));

		if(index[0] !=-1 && index[1] != -1) {	//Si sí existe el ejemplar
			
			Libros[index[0]].delEjemplar(id);
			
		}else {
			System.out.println("El libro o ejemplar no existe");
		}
	}
	
	//Change
	public void changeLibro(Libro libro, String titulo, String[] autores, Integer cant, String[] genero) {
		if(!titulo.equals("")) {libro.setTitulo(titulo);}
		if(autores[0] != null) {libro.setAutores(autores);}
		if(genero[0] != null) {libro.setGenero(genero);}
		if(cant != null) {libro.addEjemplares(cant);}
	}
	
	public void changeUsuario(User usuario, String cc, String nombre, Boolean mora) {
		if(!cc.equals("")) {usuario.setCC(cc);}
		if(!nombre.equals("")) {usuario.setNombre(nombre);}
		if(mora != null) {usuario.setMora(mora);}
	}
	
	public void changePrestamo(Prestamo p, String Ejemplar, User Usuario, Date Fecha1, Date Fecha2) {
		int[] index = searchEjemplar(Ejemplar);
		
		if(index[0] != -1) {p.setEjemplar(Libros[index[0]].getEjemplares()[index[1]]);}
		if(Usuario != null) {p.setUsuario(Usuario);}
		if(Fecha1 != null) {p.setFechaPrestamo(Fecha1);}
		if(Fecha2 != null) {p.setFechaEntrega(Fecha2);}
	}
	
	
	//Search
	public int searchUsuario(String cc) {
		int index = 0;
		
		while(index < Usuarios.length && !cc.equals(Usuarios[index].getCC())) {
			index ++;
		}
		
		return (index < Usuarios.length)? index: -1;
	}
	
	public int searchPrestamo(char opcion, String codigoL, int id) {
		int index = -1;
		
		switch (opcion) {
		case 'c':
			index = searchPrestamoCodigoEjemplar(codigoL);
		break;
		
		case 'i':
			index = searchPrestamoId(id);
		break;
		}
		
		return index;
		
	}
	
	//busca prestamo dado su id
	private int searchPrestamoId(int id) {
		int index = 0;
		while(index < Prestamos.length && id != Prestamos[index].getId()) {
			index++;
		}
		return (index < Prestamos.length)? index: -1;
	}
	//Busca prestamo dado el codigo del libro
	private int searchPrestamoCodigoEjemplar(String codigoL) {
		int index = 0;
		while(index < Prestamos.length && !codigoL.equals(Prestamos[index].getEjemplar().getCodigoCompleto())) {
			index++;
		}
		return (index < Prestamos.length)? index: -1;

	}
	
	
	//Index[0] libro en Libros, Index[1] ejemplar en libro
	public int[] searchEjemplar(String codigo) {
		int id = Integer.parseInt(codigo.substring(7));
		String codigoLibro = codigo.substring(0,7);
		int indexL = searchLibroCodigo(codigoLibro);
		
		int[] index = new int[2];
		
		if(indexL != -1) {
			index[0] = indexL;
			index[1] = Libros[indexL].searchEjemplar(id);;
		}else {
			System.out.println("El libro no está registrado");
		}
		
		return index;
	}
	
	//Busca los ejemplares disponibles de un libro
	public Ejemplar[] searchEjemplaresDisponiblesLibro(Libro l) {
		return l.searchEjemplaresDisponibles();
	}
	
	//Buscar libros
	public Libro[] searchLibro(char opcion, String infoLibro) {
		Libro[] l = new Libro [0];
		
		switch(opcion) {
		case 'a':
			l = searchLibroAutor(infoLibro);
			break;
			
		case 'g':
			l = searchLibroGenero(infoLibro);
			break;
			
		case 't':
			l = searchLibroTitulo(infoLibro);
			break;
		}
		
		return l;
	}
	
	private Libro[] searchLibroAutor(String autor) {
		Libro[] libros = new Libro[0];
		for(Libro l: Libros) {
			
			if(l.searchAutor(autor)) {
				libros = Arrays.copyOf(libros, libros.length+1);
				libros[libros.length-1] = l;
			}
		}
		
		return libros;
	}
	
	private Libro[] searchLibroGenero(String genero) {
		Libro[] libros = new Libro[0];
		for(Libro l: Libros) {
			if(l.searchGenero(genero)) {
				libros = Arrays.copyOf(libros, libros.length+1);
				libros[libros.length-1] = l;
			}
		}
		
		return libros;
	}
	
	private Libro[] searchLibroTitulo(String titulo) {
		Libro[] libros = new Libro[0];
		for(Libro l: Libros) {
			if(l.getTitulo().toLowerCase().indexOf(titulo.toLowerCase()) != -1) {
				libros = Arrays.copyOf(libros, libros.length+1);
				libros[libros.length-1] = l;
			}
		}
		
		return libros;
	}
	
	public int searchLibroCodigo(String codigo) {
		int index = 0;
		String codigoLibro = codigo.substring(0,7);

		while(index < Libros.length && !codigoLibro.equals(Libros[index].getCodigo())) {
			index++;
		}
		
		return (index < Libros.length)? index: -1;
	}
	
	//Crea prestamo (Problema: codigo es cLibro+cEjemplar: acceder a él)
	public void crearPrestamo(Ejemplar e, String cc) {
		int indexU = searchUsuario(cc);
		
		if(indexU != -1) {
	
			if(!checkMora(Usuarios[indexU])) {
				if(e.getEstado()) {
					if(e.getDisponilidad()) {
						Prestamo p = new Prestamo(e, Usuarios[indexU]);
						Usuarios[indexU].setMora(true);
						Prestamos = Arrays.copyOf(Prestamos, Prestamos.length+1);
						Prestamos[Prestamos.length-1] = p;
						
						System.out.println("Prestamo registrado correctamente con id: " + p.getId());
						System.out.println("Codigo del ejemplar prestado: " + p.getEjemplar().getCodigoCompleto());
						System.out.println("Al usuario: " + p.getUsuario().getCC());
						
					}else {System.out.println("Libro prestado");}
					
				}else {System.out.println("Libro en mantenimiento");}
				
			}else {System.out.println("Usuario en mora");}
			
		}else {System.out.println("Usuario no registrado");}
		
	}
	
	//Revisa si hay mora
	private boolean checkMora(User usuario) {
		return usuario.getMora();
	}
		
	//Registrar devolución
	public void registrarDevolucion(String codigoEjemplar) {
		int index[] = searchEjemplar(codigoEjemplar);
		int indexP = searchPrestamoCodigoEjemplar(codigoEjemplar);
		Date fecha2 = new Date();
		
		if(index[0] !=-1 && index[1] !=-1) {
			if(Libros[index[0]].getEjemplares()[index[1]].getDisponilidad()) {
				System.out.println("Ejemplar no fue prestado");
				
			}else {
				Libros[index[0]].getEjemplares()[index[1]].setDisponibilidad(true);
				Prestamos[indexP].setFechaEntrega(fecha2);
				Prestamos[indexP].getUsuario().setMora(false);
				System.out.println("Devolución registada con éxito");
			}
			
		}else {
			System.out.println("Ejemplar no resgistrado");
		}
	}
	
	
	//Cambiar estado de mantenimiento de ejemplar
	public void setEstadoEjemplar(String codigoC, boolean Estado) {
		int index[] = searchEjemplar(codigoC);
		
		if(index[0] != -1 && index[1] !=-1) {
			Libros[index[0]].getEjemplares()[index[1]].setEstado(Estado);
			if(Estado) {System.out.println("El libro ahora está fuera de mantenimiento");}
			else {System.out.println("El libro ahora está en mantenimiento");}
		}
	}
	

}
