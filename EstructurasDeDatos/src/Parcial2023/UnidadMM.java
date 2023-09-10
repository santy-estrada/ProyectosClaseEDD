package Parcial2023;

import java.util.*;


enum Cond_Salud {HERIDO, MUERTO, SIN_AFECTACION};
enum Cond_Vivienda{DERRUMBE_TOTAL, PARCIAL,SIN_AFECTACION}
enum Role{JEFE, INGENIERO, RESCATE}

class EMuertos extends Exception{
	
	public EMuertos() {
		super ("No ha habido eventos con muertos");
	}
}

class Persona{
    protected String nombre;
    protected String tipoID;
    protected String ID;
    public Persona(String nombre, String tipoID, String iD) {
        super();
        this.nombre = nombre;
        this.tipoID = tipoID;
        ID = iD;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoID() {
        return tipoID;
    }
    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    
}

class Personal extends Persona{
    private String centroTrab;
    private String cargo;
    public Personal(String nombre, String tipoID, String iD, String centroTrab, String cargo) {
        super(nombre, tipoID, iD);
        this.centroTrab = centroTrab;
        this.cargo = cargo;
    }
    public String getCentroTrab() {
        return centroTrab;
    }
    public void setCentroTrab(String centroTrab) {
        this.centroTrab = centroTrab;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}

class PersonaAfectada extends Persona{
    private int edad;
    private Cond_Salud salud;
    private Cond_Vivienda vivienda;
    
    public PersonaAfectada(String nombre, String tipoID, String iD, int edad, Cond_Salud salud,
            Cond_Vivienda vivienda) {
        super(nombre, tipoID, iD);
        this.edad = edad;
        this.salud = salud;
        this.vivienda = vivienda;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Cond_Salud getSalud() {
        return salud;
    }
    public void setSalud(Cond_Salud salud) {
        this.salud = salud;
    }
    public Cond_Vivienda getVivienda() {
        return vivienda;
    }
    public void setVivienda(Cond_Vivienda vivienda) {
        this.vivienda = vivienda;
    }
    
}

class PersonalEvento{
    private Personal personalPart;
    private Role role;
    public PersonalEvento(Personal personalPart, Role role) {
        super();
        this.personalPart = personalPart;
        this.role = role;
    }
    public Personal getPersonalPart() {
        return personalPart;
    }
    public void setPersonalPart(Personal personalPart) {
        this.personalPart = personalPart;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
}

class MM{
	private String tipo;
	private String direccion;
	private PersonalEvento[] personalPart;
	private PersonaAfectada[] personasAfectadas;
	
	public MM(String tipo, String direccion, PersonalEvento[] personalPart, PersonaAfectada[] personasAfectadas) {
		this.tipo = tipo;
		this.direccion = direccion;
		this.personalPart = personalPart;
		this.personasAfectadas = personasAfectadas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public PersonalEvento[] getPersonalPart() {
		return personalPart;
	}
	public void setPersonalPart(PersonalEvento[] personalPart) {
		this.personalPart = personalPart;
	}
	public PersonaAfectada[] getPersonasAfectadas() {
		return personasAfectadas;
	}
	public void setPersonasAfectadas(PersonaAfectada[] personasAfectadas) {
		this.personasAfectadas = personasAfectadas;
	}
	
	
	public int muertos() {
		int cont = 0;
		for(PersonaAfectada a: personasAfectadas) {
			if(a.getSalud() == Cond_Salud.valueOf("MUERTO")) {
				cont++;
			}
		}
		
		return cont;
	}
	

 
    
}

class DobleRole{
    private PersonalEvento persona;
    private int Evento;
    private Cond_Salud salud;
    private Cond_Vivienda vivienda;
    
    public PersonalEvento getPersona() {
        return persona;
    }
    public Cond_Salud getSalud() {
        return salud;
    }
    public Cond_Vivienda getVivienda() {
        return vivienda;
    }
    public int getEvento() {
        return Evento;
    }
    public DobleRole(PersonalEvento persona, int evento, Cond_Salud salud, Cond_Vivienda vivienda) {
        super();
        this.persona = persona;
        Evento = evento;
        this.salud = salud;
        this.vivienda = vivienda;
    }

    
}



public class UnidadMM {
    private MM[] eventos;
    
    public UnidadMM(MM[] eventos) {
        super();
        this.eventos = eventos;
    }

    // Evento que mas muertos tuvo, que devuelva un arreglo de dos posiciones donde la primera es el indice del evento y la segunda es la cantidad de muertos en ese evento
    // Si ninguno tiene muertos que devuelva una excepcion diciendo "No ha habido eventos con muertos"
    public int[] masMuertos() throws EMuertos {
    	int max = 0;
    	int index = 0;
    	int muertos;
    	for(int i = 0; i < eventos.length; i++) {
    		muertos = eventos[i].muertos();
    		if(muertos > max) {
    			max = muertos;
    			index = i;
    		}
    	}
    	
    	if(max == 0) {
    		throw new EMuertos();
    	}
    	int res [] = {index, max};
    
        return res;
    }
    
    // Personas que han estado de personal de atencion en un evento y a la vez ha sido persona afectada, en el mismo evento.
    public DobleRole[] dobleRole(){
    	DobleRole d [] = new DobleRole[0];
    	
    	for(int i = 0; i < eventos.length; i++) {
    		for(PersonaAfectada a: eventos[i].getPersonasAfectadas()) {
    			for(PersonalEvento e: eventos[i].getPersonalPart()) {
    				if(a.getID().equals(e.getPersonalPart().getID())) {
    					DobleRole r = new DobleRole(e, i, a.getSalud(), a.getVivienda());
    					d = Arrays.copyOf(d, d.length+1);
    					d[d.length-1] = r;
    				}
    			}
    		}
    	}
    	
    	
        return d;
    }
    
    
    //Hacer RECURSIVO
	// Lista de personas que han sido afectadas por mas de un evento.
	// Almacenelo en la lista en el orden en que estan los eventos.
    public PersonaAfectada[] afectadasVariasVeces() {
    	
		return afectadasVariasVeces(0,0, new PersonaAfectada[0]);
	}
    
    private PersonaAfectada[] afectadasVariasVeces(int indexE,int indexP, PersonaAfectada[] res) {

    	if(indexP >= eventos[indexE].getPersonasAfectadas().length) {
    		if(indexE >= eventos.length-1) {
        		if(res.length ==0) {
        			return null;
        		}
        		return res;
        	}
    		return afectadasVariasVeces(indexE+1, 0, res);
    	}
    	
    	PersonaAfectada[] as = eventos[indexE].getPersonasAfectadas();
    	PersonaAfectada a = as[indexP];
		
		if(alreadyIn(a, res) && isAffVarias(a)) {
			res = Arrays.copyOf(res, res.length+1);
			res[res.length-1] =a;
		}
		
		return afectadasVariasVeces(indexE, indexP+1, res);
	
    	
  
    }
    
    
    
    private boolean alreadyIn(PersonaAfectada p, PersonaAfectada[] res ) {
    	int index = 0;
    	while(index < res.length && !p.getID().equals(res[index].getID())) {
    		index++;
    	}
    	
    	return (index == res.length)? true: false;
    }
    
    private boolean isAffVarias(PersonaAfectada p) {
    	int cont = 0;
    	int indexE = 0;
    	int indexP =0;
   
    	while(indexE < eventos.length && cont <= 1) {
    		PersonaAfectada[] af = eventos[indexE].getPersonasAfectadas();
    		while(indexP < af.length) {
    			if(af[indexP].getID().equals(p.getID())) {
    				cont++;
    			}
    			indexP++;
    		}
    		indexP = 0;
    		indexE++;
    	}
    	return (cont > 1)? true: false;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        int preg=Integer.parseInt(line);
        MM[] eventos=new MM[0];
        PersonaAfectada[] afectados=new PersonaAfectada[0];
        Personal[] personal=new Personal[0];
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(", ");
            if (lineSplit[0].equals("P")) {
                personal=Arrays.copyOf(personal, personal.length+1);
                personal[personal.length-1]=new Personal(lineSplit[1], lineSplit[2],lineSplit[3],lineSplit[4],lineSplit[5]);
                
            }else if(lineSplit[0].equals("PA")){
                afectados=Arrays.copyOf(afectados, afectados.length+1);
                afectados[afectados.length-1]=new PersonaAfectada(lineSplit[1], lineSplit[2],lineSplit[3],Integer.parseInt(lineSplit[4]),Cond_Salud.valueOf(lineSplit[5]), Cond_Vivienda.valueOf(lineSplit[6]));
            }else if(lineSplit[0].equals("E")){
                eventos=Arrays.copyOf(eventos, eventos.length+1);
                String[] stringPersonal=lineSplit[3].split(" ");
                PersonalEvento[] listaPersonal=new PersonalEvento[stringPersonal.length/2];
                int indP=0;
                for (int i=0;i<stringPersonal.length;i+=2) {
                    int index=Integer.parseInt(stringPersonal[i]);
                    listaPersonal[indP++]=new PersonalEvento(personal[index], Role.valueOf(stringPersonal[i+1]));
                }
                String[] stringAfectados=lineSplit[4].split(" ");
                PersonaAfectada[] listaAfectados=new PersonaAfectada[stringAfectados.length];
                for (int i=0;i<listaAfectados.length;i++) {
                    int index=Integer.parseInt(stringAfectados[i]);
                    listaAfectados[i]=afectados[index];
                }
                eventos[eventos.length-1]=new MM(lineSplit[1],lineSplit[2],listaPersonal, listaAfectados);
            }
        }
        
        UnidadMM unidad=new UnidadMM(eventos);
        if (preg==1) {
            DobleRole[] dr=unidad.dobleRole();
            for (DobleRole doble:dr) {
                System.out.print(doble.getPersona().getPersonalPart().getNombre() +","+ doble.getEvento());
                System.out.println(","+ doble.getPersona().getRole()+ ","+doble.getSalud() + ","+ doble.getVivienda());
            }
        }
        if (preg==2) {
            int[] muertos;
            try {
				muertos = unidad.masMuertos();
				System.out.println(muertos[0]+" "+ muertos[1]);
			} catch (EMuertos e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
           
        }
        if (preg==3) {
			PersonaAfectada[] pa=unidad.afectadasVariasVeces();
			for (PersonaAfectada p:pa)
				System.out.println(p.getNombre()+" "+p.getID());
		}
        
        in.close();

    }

}