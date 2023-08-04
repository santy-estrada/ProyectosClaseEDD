package FabricaPiezas;
import java.util.Arrays;

public class Empresa {

	private Pieza piezas[];
	private String nombre;
	private String direccion;
	private Cliente clientes[];
	
	public Empresa(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.piezas = new Pieza[0];
		this.clientes = new Cliente[0];
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Pieza[] getPiezas() {
		return piezas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}
	
	
	public void addPieza(char tipo, double pesoU, String codigo, String descripcion) {
		this.piezas = Arrays.copyOf(this.piezas, this.piezas.length+1);
		
		switch(tipo) {
			case 'm':
				Metalica m = new Metalica(pesoU, codigo, descripcion);
				this.piezas[this.piezas.length-1] = m;
				
				break;
			
			case 'p':
				Plastica p = new Plastica(pesoU, codigo, descripcion);
				this.piezas[this.piezas.length-1] = p;
				break;
				
			case 'i':
				System.out.println("No indic� las piezas que componen la pieza mixta");
				break;
				
			default:
				System.out.println("No existe el tipo de pieza");

		}
	}
	
	public void addPieza(char tipo, double pesoU, String codigo, String descripcion, String[] Cpiezas) {
		
		if(tipo == 'i') {
			Pieza p[] = new Pieza[0];
			
			for(String s: Cpiezas) {
				int index = 0;
				try {
					index = searchPieza(s);
				} catch (ENotFound e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				p = Arrays.copyOf(p, p.length+1);
				p[p.length-1] = this.piezas[index];
				
			}
			
			this.piezas = Arrays.copyOf(this.piezas, this.piezas.length+1);
			Mixta m = new Mixta(pesoU, codigo, descripcion, p);
			this.piezas[this.piezas.length-1] = m;
			
		}else {
			System.out.println("No existe el tipo de pieza");

		}
	}
	
	public void addCliente(String codigo, String direccion, String nombre, String correo, FormaDePago fp) {
		
		clientes = Arrays.copyOf(clientes, clientes.length+1);
		Cliente c = new Cliente(codigo, direccion, nombre, correo, fp);
		clientes[clientes.length-1] = c;
				
	}
	
	public void crearSolicitud(String codigoC, String codigoS, String codigoPieza, int cantidadFabricar) {
		int indexC = 0;
		try {
			indexC = searchCliente(codigoC);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
		}
		
		int indexP = 0;
		try {
			indexP = searchPieza(codigoPieza);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			clientes[indexC].addSolicitud(codigoS, piezas[indexP], cantidadFabricar);
		} catch (ECantidadImposible e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
			
	
	}
	
	
	public int searchPieza(String codigo) throws ENotFound{
		int index = 0;
		while(index < piezas.length && !piezas[index].getCodigo().equals(codigo)) {
			index++;
		}
		
		if(index >= piezas.length) {
			throw new ENotFound("La pieza no existe");
		}
		return index;
	}
	
	public int searchCliente(String codigo) throws ENotFound{
		int index = 0;
		while(index < clientes.length && !clientes[index].getCodigo().equals(codigo)) {
			index++;
		}
		
		if(index >= clientes.length) {
			throw new ENotFound("No existe el cliente");
		}
		
		return index;
	}
	
	public int[] searchSolicitud(String codigo) throws ENotFound{
		int[] index = new int[2];
		int indexC = 0;
		boolean flag = true;
		while(indexC < clientes.length && flag) {
			if(clientes[indexC].searchSolicitud(codigo, true) != -1) {
				flag = false;
				index[0] = indexC;
				index[1] = clientes[indexC].searchSolicitud(codigo, true);
			}
			indexC++;
		}
		
		if(indexC >= clientes.length && flag) {
			throw new ENotFound("La solicitud no est� registrada a ning�n cliente");
		}
		
		return index;

	}
	
	public void delSolicitud(String codigo) {
		
		int index[] = {0,0};
		
		try {
			index = searchSolicitud(codigo);
			
			try {
				clientes[index[0]].delSolicitud(codigo);
			} catch (ENotFound e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
	
		
	}
	
	public void delPieza(String codigo) {
		int index = 0;
		try {
			index = searchPieza(codigo);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		if(index == 0) {// Si est� en la primera posici�n
			Pieza[] aux = new Pieza[this.piezas.length-1];
			
			System.arraycopy(this.piezas, 1, aux, 0, aux.length);//aux es arreglo excepto el primero
			this.piezas = Arrays.copyOf(aux, aux.length);	//se convierte en aux
			
		}else if (index == piezas.length-1) {	//Si est� en la �ltima posici�n
			
			this.piezas = Arrays.copyOf(this.piezas, this.piezas.length-1);
			///Es s� mismo menos la �litma posici�n
			
		}else {// Si est� entre la primera y �ltima posic�on
			
			Pieza[] aux1 = new Pieza[index]; //aux1 con posiciones igual al �ndice
			Pieza[] aux2 = new Pieza[this.piezas.length-index-1];
			//aux2 con posiciones de arreglo atributo menos el �nidce y menos 1 posici�n
			//total de posiciones = arregloAtributo.length-1
			
			System.arraycopy(this.piezas, 0, aux1, 0, aux1.length);
			//aux1 son todos los elementos del arreglo hasta el que se quiere eliminar (sin incluir)
			System.arraycopy(this.piezas, index+1, aux2, 0, aux2.length);
			//aux2 son todos los autores del arreglo desde el que se quiere eliminar (sin incluir)
			
			this.piezas = Arrays.copyOf(this.piezas, this.piezas.length-1); //Quitar una posici�n
			
			System.arraycopy(aux1, 0, this.piezas, 0, aux1.length);
			//el arreglo atributo toma los valores de aux1 desde 0
			System.arraycopy(aux2, 0, this.piezas, index, aux2.length);
			//el arreglo atributo toma los valores de aux2 desde el indice del elemento que se quer�a eliminar
		}

		
	}
	
	public void delCliente(String codigo) {
		int index = 0;
		try {
			index = searchCliente(codigo);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				
		if(index == 0) {// Si est� en la primera posici�n
			Cliente[] aux = new Cliente[this.clientes.length-1];
			
			System.arraycopy(this.clientes, 1, aux, 0, aux.length);//aux es arreglo excepto el primero
			this.clientes = Arrays.copyOf(aux, aux.length);	//se convierte en aux
			
		}else if (index == clientes.length-1) {	//Si est� en la �ltima posici�n
			
			this.clientes = Arrays.copyOf(this.clientes, this.clientes.length-1);
			///Es s� mismo menos la �litma posici�n
			
		}else {// Si est� entre la primera y �ltima posic�on
			
			Cliente[] aux1 = new Cliente[index]; //aux1 con posiciones igual al �ndice
			Cliente[] aux2 = new Cliente[this.clientes.length-index-1];
			//aux2 con posiciones de arreglo atributo menos el �nidce y menos 1 posici�n
			//total de posiciones = arregloAtributo.length-1
			
			System.arraycopy(this.clientes, 0, aux1, 0, aux1.length);
			//aux1 son todos los elementos del arreglo hasta el que se quiere eliminar (sin incluir)
			System.arraycopy(this.clientes, index+1, aux2, 0, aux2.length);
			//aux2 son todos los autores del arreglo desde el que se quiere eliminar (sin incluir)
			
			this.clientes = Arrays.copyOf(this.clientes, this.clientes.length-1); //Quitar una posici�n
			
			System.arraycopy(aux1, 0, this.clientes, 0, aux1.length);
			//el arreglo atributo toma los valores de aux1 desde 0
			System.arraycopy(aux2, 0, this.clientes, index, aux2.length);
			//el arreglo atributo toma los valores de aux2 desde el indice del elemento que se quer�a eliminar
		}

	
	}
	
	public void modSolicitud(String codigoSV, String codigoSN, String codigoP, int cantidadFabricar) {
		int index[] = {0,0};
		try {
			index = searchSolicitud(codigoSV);
			Pieza p = null;
			
			if(!codigoP.equals("")) {
				int indexP = 0;
				try {
					indexP = searchPieza(codigoP);
					p = piezas[indexP];
				} catch (ENotFound e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		
			try {
				clientes[index[0]].modSolicitud(codigoSV, codigoSN, p, cantidadFabricar);
			} catch (ENotFound e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ECantidadImposible e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
	
	}
	
	public void registrarEntrega(String codigo) {
		int index[] = {0,0};
		try {
			index = searchSolicitud(codigo);
			
			try {
				clientes[index[0]].registrarEntrega(codigo);
			} catch (ENotFound e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
	
	
		
	}

	public double getCostoPieza(String codigo) {
		int index = 0;
		try {
			index = searchPieza(codigo);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return piezas[index].calcularCosto();
	}
	
	public double getCostoCliente(String codigo) {
		int index = 0;
		try {
			index = searchCliente(codigo);
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		double costo;
		
		if(clientes[index].getSolicitudes().length != 0) {
			
			costo = clientes[index].getCostoTotal();
			
		}else {costo = -1;}
		
		return costo;
	}
	
	
	public Cliente getVIP() throws ENoClients, EMaxCero{
		
		if(clientes == null || clientes.length == 0) {throw new ENoClients();}
		
		Cliente vip = clientes[0];
		
		for(Cliente c: clientes) {
			if(c.getCostoTotal() > vip.getCostoTotal()) {
				vip = c;
			}
		}
		
		if(vip.getCostoTotal() == 0) {throw new EMaxCero();}
		
		return vip;
		
	}
	
	public int[] cantVendidaPieza() throws ENotFound, ENoPiezas {
		
		if(piezas.length == 0) {throw new ENoPiezas();}
		
		int cantVendidaPieza[] = new int[piezas.length];
		
		for(Cliente c: clientes) {
			for(Solicitud s: c.getSolicitudes()) {
				int indexP = searchPieza(s.getCodigoPieza());
				cantVendidaPieza[indexP] += s.getCantidadFabricar();
			}
		}
		
		return cantVendidaPieza;
		
	}
	
	public Pieza getPiezaVIP() throws EMaxCero, ENotFound, ENoPiezas {
		int [] cantVendidaPieza = cantVendidaPieza();
		int max = 0;
		int maxIn = 0;
		for(int i = 0; i < cantVendidaPieza.length; i++) {
			if(max < cantVendidaPieza[i]) {
				max =  cantVendidaPieza[i];
				maxIn = i;
			}
		}
		
		if(max == 0) {throw new EMaxCero();}
		
		return piezas[maxIn];
		
	}
	/*
	public Pieza[] getPiezasVIP() {
		
	}*/
	
	
}
