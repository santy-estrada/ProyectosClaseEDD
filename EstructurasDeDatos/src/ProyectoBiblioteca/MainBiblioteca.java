package ProyectoBiblioteca;

import java.util.Arrays;

public class MainBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//crear biblio
		Biblioteca b = new Biblioteca("LibrosYMás");
		String[] autores = {"Juan", "Federico"};
		String[] generos = {"comedia","drama"};
		
		//añadir libros
		b.addLibro("La Divina Tristeza",autores, 2, generos);
		b.addLibro("La Divina Comedia",autores, 5, generos);
		b.addLibro("El divino niño",autores, 3, generos);
		
		//añadir usuarios
		b.addUsuario("1001132827", "Santiago");
		b.addUsuario("1001132829", "Federico");
		b.addUsuario("1001132877", "Juan");


		//añadir más ejemplares
		b.addEjemplarLibro(0, 4);
		
		String cod = new String();
		Ejemplar[] ejem = new Ejemplar[0];
		Ejemplar ejemLibros[] = new Ejemplar[0];
		boolean flag = true;
		
		System.out.println();
		//ciclo para mostrar libros que coinciden y sus ejemplares disponibles
		for(Libro L: b.searchLibro('t', "Divina")) {
			System.out.println("Codigo: " + L.getCodigo());
			System.out.println("Titulo: " + L.getTitulo());
			System.out.println("Número de Ejemplares: " + L.countEjemplares());
			
			ejemLibros = b.searchEjemplaresDisponiblesLibro(L);
		
			for(int i = 0; i < ejemLibros.length; i++ ){
				System.out.println("Codigo Ejemplar Disponible: " + ejemLibros[i].getCodigoCompleto());		
				System.out.println("Estado de Disponibilidad: " + ejemLibros[i].getDisponilidad());
				
				ejem = Arrays.copyOf(ejem, ejem.length+1);
				ejem[i] = ejemLibros[i];
				System.out.println();
			}
			System.out.println();
			
			if(flag) {
				cod = L.getCodigo();
				flag = false;
			}
		}
		
		//borra el primer libro
		b.delLibro(cod);
		System.out.println();

		//Crea prestamo
		b.crearPrestamo(ejem[0], "1001132827");
		System.out.println("--");
		b.crearPrestamo(ejem[0], "1001132829");	//Libro prestado
		b.crearPrestamo(ejem[1], "1001132827");	//Usuario en mora
		b.crearPrestamo(ejem[1], "1001132820");	//Usuario inexistente
		System.out.println("--");
		
		b.setEstadoEjemplar(ejem[1].getCodigoCompleto(), false);	//Pone el libro en matenimiento
		b.crearPrestamo(ejem[1], "1001132829");	//Libro en matenimiento
		b.setEstadoEjemplar(ejem[1].getCodigoCompleto(), true);	//Sale de mantenimiento
		b.crearPrestamo(ejem[1], "1001132829");	//Libro prestado


		System.out.println("--");

		String codigoBorrar = ejem[2].getCodigoCompleto();	//se va a borrar el 2
		System.out.println(codigoBorrar);
		System.out.println(b.searchEjemplar(codigoBorrar)[1]);	//Posición en el libro
		b.delEjemplarLibro(codigoBorrar);	//Borra el libro
		System.out.println(b.searchEjemplar(codigoBorrar)[1]);	//Ya no existe el libro

		System.out.println("--");

		System.out.println(b.searchUsuario("1001132877"));	//busca usuario
		b.delUsuario("1001132877");	//borra usuario
		System.out.println(b.searchUsuario("1001132877"));	//Negativo para usuario
		System.out.println("--");

		
		System.out.println();

		//Ya sólo existe un libro
		for(Libro L: b.searchLibro('t', "Divina")) {
			System.out.println("Codigo: " + L.getCodigo());
			System.out.println("Titulo: " + L.getTitulo());
			System.out.println("Número de Ejemplares: " + L.countEjemplares());
			System.out.println();
		}
		
		b.registrarDevolucion(ejem[0].getCodigoCompleto());	//Registra devolución
		System.out.println("--");
		b.crearPrestamo(ejem[3], "1001132827");		//Ya sí permite préstamo
		
		System.out.println(b.searchPrestamo('i', "", 2));	//Prestamo 2
		b.delPrestamo(2);	//Borra el prestamo
		System.out.println(b.searchPrestamo('i', "", 2));	//Negativo para prestamo
		System.out.println();
		System.out.println("--");
		

	}

}
