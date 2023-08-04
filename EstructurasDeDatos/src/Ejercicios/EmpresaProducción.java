package Ejercicios;

import java.util.Arrays;

enum dias{
	// Enumerador de días laborales
	LUN("Lunes"),
	MAR("Martes"),
	MI("Miércoles"),
	JU("Jueves"),
	VI("Viernes");
	// Se le pasa el nombre largo
	private String Dia;
	
	private dias(String Dia){
		this.Dia = Dia;
	}
	
	private String getDia() {
		return this.Dia;
	}
	// Método para obtener el índice del día
	public static int getInDia(String dia) {
		int index = 0;
		
		while(index < values().length && !values()[index].getDia().equalsIgnoreCase(dia)) {
			index ++;
		}
		
		return (index < values().length)? index: -1;
		
	}
	//Método para obtener el nombre de un día dado su indice
	public static String getNomDia(int i) {
		return values()[i].getDia();
	}
	
}



class Producto{
	private String nombre;
	private int produccion[];
	
	public Producto(String nombre) {
		this.nombre = nombre;
		this.produccion = new int[5];		//Arreglo con una posición por cada día laboral
		Arrays.fill(produccion, -1);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int[] getProduccion() {
		return produccion;
	}
	//Añade producción si la casilla no ha sido modificada
	public void addProduccion(String dia, int produccion) {
		int index = dias.getInDia(dia);
		
		if(index != -1 && produccion > -1 && this.produccion[index] == -1) {this.produccion[index] = produccion;}
		else {System.out.println("Día o producción inválida");}
		
	}
	//Modifica la producción de un día dado
	public void setProduccion(String dia, int produccion) {
		int index = dias.getInDia(dia);
		
		if(index !=-1 && produccion > -1 && this.produccion[index] != -1) {this.produccion[index] = produccion; }
		else { System.out.println("Día o producción inválida");}
	}
	// Suma la producción total
	public int getProduccionTotal() {
		int produccionTotal = 0;
		for(int c:this.produccion) {
			produccionTotal += (c!=-1)? c: 0;		//Suma la producción de cada día si es diferente a -1
		}
		
		return produccionTotal;
	}
	
	//Muestra la producción semanal del producto
	public void showProduccionSemanal() {
		System.out.println("-----------------");
		System.out.println(nombre);
		System.out.println("-----------------");

		for(int i = 0; i < dias.values().length; i++) {
			System.out.print(dias.getNomDia(i) + ": ");
			if(this.produccion[i] == -1) { // Si no se ha modificado se toma como 0
				System.out.println(0.0);
			}else {
				System.out.println(this.produccion[i]);
			}
		}
		System.out.println("-----------------");

	}
	
	
}

public class EmpresaProducción {
	
	private String nombre;
	private Producto[] productos;			
	
	public EmpresaProducción(String nombre, Producto[] productos) {
		
		this.nombre = nombre;
		this.productos = productos;
		if(!checkUnicidad(productos)) {System.out.println("Existen productos repetidos");}
	
	}
	
	private boolean checkChange(String nombre) {
		Producto p = new Producto(nombre);	
		Producto[] aux = new Producto[productos.length+1]; //Vector de productos auxiliar
		
		System.arraycopy(productos, 0, aux, 0, productos.length);
		aux[productos.length] = p;
		//aux es this.productos + p
		
		return checkUnicidad(aux);	//Envía el nuevo vector para chequear que todos sean únicos
	}
	
	//Chequea que cada producto sea único
	private boolean checkUnicidad(Producto[] productos) {
		boolean flag = true;				//Bandera de unicidad (true -> es único)
		Producto[] aux = new Producto[0];	//Vector auxiliar de productos
		int index = 0;						//Indice para productos
		int cont = 0;						//Indice para aux
		
		do {
			if(productos.length == 0 || productos[0] == null) {return true;}//Si no hay productos es único
			
			cont = 0;
			while(cont < aux.length && !aux[cont].getNombre().equals(productos[index].getNombre())) {
				cont ++;	//Suma cont si el nombre en la posición cont en aux es diferente al de productos en index
			}
			if(cont < aux.length) {flag = false;}	//Si salió del ciclo y sigue cumpliendo cont<aux.length, hay un match

			aux = Arrays.copyOf(aux, aux.length+1);	
			aux[index] = productos[index];	//A aux se le añade el producto que se está verificando
			
			index ++;			
			
		}while(index<productos.length && flag);//Mientras no haya match ni se hayan recorrido todos los productos
		
		
		return flag;
	}
	
	//Añade un producto al arreglo en la última posición
	
	public void addProducto(String nombre) {
		if(checkChange(nombre)) {
			this.productos = Arrays.copyOf(this.productos, this.productos.length+1);
			Producto p = new Producto(nombre);
			this.productos[this.productos.length-1] = p;
		}else {
			System.out.println("Un producto con ese nombre ya existe");
		}
	}
	
	//Elimina un producto dado su nombre
	public void delProducto(String nombre) {
		int index = searchProducto(nombre);
		if(index !=-1) {	//Si sí existe el producto
			if(index == 0) {// Si está en la primera posición
				Producto[] aux = new Producto[this.productos.length-1];
				
				System.arraycopy(this.productos, 1, aux, 0, aux.length);//aux es this.productos excepto el primer producto
				this.productos = Arrays.copyOf(aux, aux.length);	//this.productos se convierte en aux
				
			}else if (index == productos.length-1) {	//Si está en la última posición
				
				this.productos = Arrays.copyOf(this.productos, this.productos.length-1);
				///this.productos es sí mismo menos la úlitma posición
				
			}else {// Si está entre la primera y última posicíon
				
				Producto[] aux1 = new Producto[index]; //aux1 con posiciones igual al índice
				Producto[] aux2 = new Producto[this.productos.length-index-1];
				//aux2 con posiciones de this.productos menos el ínidce y menos 1 posición
				//total de posiciones = this.productos.length-1
				
				System.arraycopy(this.productos, 0, aux1, 0, aux1.length);
				//aux1 son todos los productos de this.productos hasta el que se quiere eliminar (sin incluir)
				System.arraycopy(this.productos, index+1, aux2, 0, aux2.length);
				//aux2 son todos los productos de this.productos desde el que se quiere eliminar (sin incluir)
				
				this.productos = Arrays.copyOf(this.productos, this.productos.length-1); //Quitar una posición
				
				System.arraycopy(aux1, 0, this.productos, 0, aux1.length);
				//this.productos toma los valores de aux1 desde 0
				System.arraycopy(aux2, 0, this.productos, index, aux2.length);
				//this.productos toma los valores de aux2 desde el indice del elemento que se quería eliminar
				
			}

		}else {
			System.out.println("El producto no existe");
		}
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//Suma la producción de cada producto
	public int getProduccionTotalEmpresa() {
		int prod = 0;
		for(Producto p: productos) {	//P itera sobre los productos del arreglo
			prod += p.getProduccionTotal();
		}
		return prod;
	}
	//Arreglo de todas las producciones acumuladas en cada posición
	private int[] getProduccionSemanal() {
		int ProdSemanal[] = new int[5];
		for(Producto p: productos) {
			for(int i = 0; i < p.getProduccion().length; i++) {
				ProdSemanal[i] += (p.getProduccion()[i] != -1)? p.getProduccion()[i]:0;
				}//Suma la producción si es diferente de -1
			
		}
		
		return ProdSemanal;
	}
	//Dado un día, entrega la producción total de la empresa ese día
	public int getProduccionDiaEmpresa(String dia) {
		int index = dias.getInDia(dia);
		int prodSemanal = 0;
		if(index != -1) { prodSemanal = getProduccionSemanal()[index];}
		else {System.out.println("Día inválido");}
	
		return prodSemanal;
	}

	//Muestra la producción semanal de la empresa
	public void showProdSemanal() {
		System.out.println("-----------------");
		System.out.println("Total producción por día");
		System.out.println("-----------------");

		for(int i = 0; i < dias.values().length; i++) {
			System.out.println(dias.getNomDia(i) + ": " + getProduccionSemanal()[i]);
		}
		System.out.println("-----------------");
	}
	// Muestra el total de producción de cada producto
	public void showTprod() {
		System.out.println("-----------------");
		System.out.println("Total producción por producto");
		System.out.println("-----------------");

		for(int i = 0; i < productos.length; i++) {
			System.out.println(productos[i].getNombre() + ": " + productos[i].getProduccionTotal());
		}
		System.out.println("-----------------");
	}
	
	//Dado un producto y un día, da la producción correspondiente
	public int getProduccionDiaProducto(String producto, String dia) {
		int indexP = searchProducto(producto);
		int indexD = dias.getInDia(dia);
		if(indexP != -1 && indexD != -1 && productos[indexP].getProduccion()[indexD] == -1) {
			System.out.println("No se ha modificado este día");
		}
		return (indexP !=-1 && indexD !=-1)? productos[indexP].getProduccion()[indexD]:-1;
	}
	//Busca si existe un producto con el nombre enviado y devuelve su índice
	private int searchProducto(String producto) {
		int index = 0;
		
		while(index < productos.length && !productos[index].getNombre().equals(producto)) {
			index++;
		}
		
		return (index < productos.length)? index: -1;
	}
	//Cambia nombre de producto
	public void setNombreProducto(String nombreN, String nombreV) {
		int index = searchProducto(nombreV);
		if(index !=-1 && checkChange(nombreN)) {productos[index].setNombre(nombreN);}
		else {System.out.println("El producto no existe o ya otro tiene el nombre nuevo");}
	}
	
	//Obtiene la producción total de un producto dado su nombre
	public int getProduccionTotalProducto(String producto) {
		int index = searchProducto(producto);
		
		return (index != -1)? productos[index].getProduccionTotal():-1;
	}
	
	//Cambia la produccion de un día de un producto
	public void setProduccionProducto(String producto, String dia, int produccion) {
		int index = searchProducto(producto);
		if(index!=-1) {productos[index].setProduccion(dia, produccion);}
		else {System.out.println("No existe el producto");}
	}
	
	//Añade una producción en un día a un producto
	public void addProduccionProducto(String producto, String dia, int produccion) {
		int index = searchProducto(producto);
		if(index!=-1) {productos[index].addProduccion(dia, produccion);	}
	}
	
	//Llama al método del producto correspondiente para mostrar su producción semanal
	public void showProduccionSemanalProducto(String producto) {
		int index = searchProducto(producto);
		if(index != -1) {productos[index].showProduccionSemanal();}
		else {System.out.println("El producto no existe");}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		Producto p1 = new Producto("A");
		Producto p2 = new Producto("B");
		Producto p3 = new Producto("B");
		Producto p4 = new Producto("D");


		Producto[] prueba = {p1,p2,p3,p4};
		
		EmpresaProducción E = new EmpresaProducción("Empresa", prueba);
		
		E.showTprod();
		
		E.setNombreProducto("A", "D");
		
		E.setNombreProducto("Z", "D");
		E.showTprod();
		*/

		
		Producto[] Productos = new Producto[10];
		String[] abc = {"A","B","C","D","E","F","G","H","I","J"};
		for(int i = 0; i < 10; i++) {
			Producto p = new Producto(abc[i]);
			Productos[i] = p;
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				Productos[i].addProduccion(dias.getNomDia(j),(int) Math.round(Math.random()*1000)) ;
			}
		}
		
		EmpresaProducción e = new EmpresaProducción("EmpresaReal SAS", Productos);
		
		e.showProdSemanal();
		e.showProduccionSemanalProducto("D");
		e.showTprod();
		System.out.println("Producción total: " + e.getProduccionTotalEmpresa());
		System.out.println("Producción total del producto D: " + e.getProduccionTotalProducto("D"));
		System.out.println("Producción total el lunes: " + e.getProduccionDiaEmpresa("lunes"));
		
		System.out.println();
		System.out.println();
		System.out.println("Cambio");
		System.out.println();
		System.out.println();

		e.setProduccionProducto("D", "lunes", 10);
		e.setProduccionProducto("Z", "lunes", 10);
		e.setProduccionProducto("D", "diciembre", 10);
		System.out.println();
		System.out.println();
		
		e.showProdSemanal();
		e.showProduccionSemanalProducto("D");
		e.showTprod();
		System.out.println("Producción total: " + e.getProduccionTotalEmpresa());
		System.out.println("Producción total del producto D: " + e.getProduccionTotalProducto("D"));
		System.out.println("Producción total el lunes: " + e.getProduccionDiaEmpresa("lunes"));
		System.out.println();
		System.out.println();
		
		//Pruebas
		System.out.println("Producción total del producto Z: " + e.getProduccionTotalProducto("Z"));
		System.out.println("Producción total el diciembre: " + e.getProduccionDiaEmpresa("diciembre"));
		e.showProduccionSemanalProducto("Z");
		System.out.println();
		System.out.println();
		
		
		e.setNombreProducto("Z", "D");
		System.out.println("Producción total del producto Z: " + e.getProduccionTotalProducto("Z"));
		System.out.println("Producción del producto Z el lunes: " + e.getProduccionDiaProducto("Z", "lunes"));
		System.out.println();
		System.out.println();
		
		e.delProducto("A");
		e.delProducto("F");
		e.delProducto("J");
		e.showTprod();
		System.out.println("Producción total: " + e.getProduccionTotalEmpresa());
		System.out.println();
		System.out.println();
		
		e.addProducto("Arroz");		
		e.addProduccionProducto("Arroz", "luNes", 96);
		e.showTprod();
		e.showProduccionSemanalProducto("Arroz");

	}

}
