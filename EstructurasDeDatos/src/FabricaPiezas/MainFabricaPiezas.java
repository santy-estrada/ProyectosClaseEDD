package FabricaPiezas;

public class MainFabricaPiezas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Metalica m = new Metalica(17.2,"hjk", "demetal");
		System.out.println(m.calcularCosto());
		
		Plastica p = new Plastica(17.2,"abc", "deplastico");
		System.out.println(p.calcularCosto());
		
		Pieza piezas[] = {p,m};
		
		Mixta mi = new Mixta(17.2,"def", "detodo", piezas);
		System.out.println(mi.calcularCosto());
		System.out.println("-----------------------------");
		
		FormaDePago  co = FormaDePago.valueOf("CO");
		FormaDePago  ce = FormaDePago.valueOf("CE");
		FormaDePago  cc = FormaDePago.valueOf("CC");
		FormaDePago  t = FormaDePago.valueOf("T");
		
		Cliente c1 = new Cliente("pqk", "cll 36", "carros sas", "carros@hotmail.com", co);
		Cliente c2 = new Cliente("123", "cll 50", "motos sas", "motos.com", t);

		c1.addSolicitud("1", m, 5);
		//c1.addSolicitud("2.1", "roc", 100);
		c1.addSolicitud("2", p, 14);
		c2.addSolicitud("3", mi, 74);
		System.out.println();

		try {
			System.out.println(c1.searchSolicitud("1"));
		} catch (ENotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		*/
		/*
		for(Solicitud s: c1.getSolicitudes()) {
			System.out.println(s.getCodigoPieza());
			System.out.println(s.getCantidadFabricar());
		}
		System.out.println();*/
		/*
		c1.modSolicitud("2", "", "abc", 15);
		c1.delSolicitud("2.1");
		
		for(Solicitud s: c1.getSolicitudes()) {
			System.out.println(s.getCodigoPieza());
			System.out.println(s.getCantidadFabricar());

		}
		System.out.println();
		*/
		
		//crear empresa
		Empresa e = new Empresa("Empresa sas", "calle 19");
		
		
		//añadir pieza
		e.addPieza('m', 17.2, "hjk", "demetal");
		e.addPieza('p', 17.2, "abc", "deplastico");
		
		//codigos de piezas
		String piezas[] = {"abc","hjk"};
		e.addPieza('i', 17.2, "pqr", "detodo", piezas);
		
		try {
			System.out.println("VIP: " + e.getVIP().getCodigo());
		} catch (ENoClients e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}	//Nuevo vip
		
		//añadir clientes
		e.addCliente("pqk", "cll 36", "carros sas", "carros@hotmail.com", FormaDePago.valueOf("CO"));
		e.addCliente("123", "cll 50", "motos sas", "motos.com", FormaDePago.valueOf("T"));
		e.addCliente("789", "cll 00", "Vcis sas", "vcis.com", FormaDePago.valueOf("CC"));

		try {
			System.out.println("VIP: " + e.getVIP().getCodigo());
		} catch (ENoClients e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}	//Nuevo vip
		
		
		//costos de cada pieza
		System.out.println(e.getCostoPieza("hjk"));
		System.out.println(e.getCostoPieza("abc"));
		System.out.println(e.getCostoPieza("pqr"));
		System.out.println();
		
		//Crear solicitud
		e.crearSolicitud("123", "##1", "pqr", 13);
		System.out.println(e.getCostoCliente("123"));	//Lo q paga el cliente
		//Otra solicitud
		e.crearSolicitud("123", "##2", "abc", 1);
		
		System.out.println(e.getCostoCliente("123"));	//Actualización de cobro
		e.crearSolicitud("123", "##4", "abc", -1);	//Solicitud imposible (cantidad <0)
		System.out.println();

		System.out.println(e.getCostoCliente("123"));	//No hay cambio de cobro
		
		e.crearSolicitud("pqk", "##3", "hjk", 12);		//Nueva solicitud a otro cliente
		System.out.println(e.getCostoCliente("pqk"));	//Su costo

		System.out.println();

		try {
			System.out.println("VIP: " + e.getVIP().getCodigo());
		} catch (ENoClients e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}	//Saca vip
		
	
		//Get cantidad de pizas
		try {
			for(int i: e.cantVendidaPieza()) {
				System.out.println(i);
			}
		} catch (ENotFound e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}catch (ENoPiezas e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		//Get pieza más vendida
		try {
			System.out.println(e.getPiezaVIP().getCodigo());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (ENotFound e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (ENoPiezas e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		System.out.println("---------------");
		
		e.modSolicitud("##1","" , "hjk", 3);	//Modifica la pieza y unidades de la solicitud 1
		//System.out.println(e.getCostoCliente("123"));	//Actualización de cobro
		System.out.println();
		
		//Get cantidad de piezas vendidas
		try {
			for(int i: e.cantVendidaPieza()) {
				System.out.println(i);
			}
		} catch (ENotFound e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}catch (ENoPiezas e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		//Get pieza más vendida
		try {
			System.out.println(e.getPiezaVIP().getCodigo());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (ENotFound e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (ENoPiezas e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		/*

		try {
			System.out.println("VIP: " + e.getVIP().getCodigo());
		} catch (ENoClients e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}	//Nuevo vip
		System.out.println();

		e.registrarEntrega("##1");		//Se registra cumplido
		System.out.println();

		e.delCliente("pqk");
		try {
			System.out.println("VIP: " + e.getVIP().getCodigo());
		} catch (ENoClients e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} catch (EMaxCero e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}	//Nuevo vip
		
		
		e.delPieza("hjk");	//Borrar una pieza
		
		e.crearSolicitud("pqk", "##5", "hjk", -5);		//Todas las excepciones (cliente, pieza, cantidad)
		System.out.println();
		
		//añadir solicitudes 
		e.crearSolicitud("789", "##12", "pqr", 10);
		e.crearSolicitud("789", "##13", "abc", 9);
		
		//Mostrar solicitudes por cliente
		for(Cliente c: e.getClientes()) {
			System.out.println("Cliente: " + c.getCodigo());
			for(Solicitud s: c.getSolicitudes()) {
				System.out.println("Solicitud: " + s.getCodigo());
				System.out.println("Costo: " + s.getCosto());
			}
			System.out.println("--");
		}
		//Eliminar solicitudes
		System.out.println();
		e.delSolicitud("##12");
		e.delSolicitud("##1");

		//Mostrar las nuevas solicitudes
		for(Cliente c: e.getClientes()) {
			System.out.println("Cliente: " + c.getCodigo());
			for(Solicitud s: c.getSolicitudes()) {
				System.out.println("Solicitud: " + s.getCodigo());
				System.out.println("Costo: " + s.getCosto());
			}
			System.out.println("--");
		}
		*/
	}
	
	

}
