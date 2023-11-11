package Final2023;

import java.util.*;
import java.text.*;


class Persona{
    protected String id;
    protected String tipo;
    protected String nombre;
    protected String apellidos;
    protected int edad;
    public Persona(String id, String tipo, String nombre, String apellidos, int edad) {
        super();
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    public String getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
    	return edad;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
                + edad + "]";
    }
    
}

class Delito{
    protected String codigo;
    protected Date fecha;
    protected String departamento;
    protected String ciudad;
    protected Acusado_Delito[] acusados;
    public Delito(String codigo, Date date, String departamento, String ciudad, Acusado_Delito[] acusados) {
        super();
        this.codigo = codigo;
        this.fecha = date;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.acusados = acusados;
    }
    
    public Acusado_Delito[] getAcusados() {
        return acusados;
    }
    
    public Date getFecha() {
    	return fecha;
    }
    
	public boolean tieneMenores() {
		int index = 0;
		while(index < acusados.length && !(acusados[index].getAcusado().getEdad() < 18)) {
			index++;
		}
		
		
		return index < acusados.length;
	}
	
	public boolean tieneAsesinato() {
		int index = 0;
		while(index < acusados.length && !(acusados[index] instanceof Acusado_Asesinato)) {
			index++;
		}
		
		
		return index < acusados.length;
	}
    
    
    
}


class Acusado_Delito{
    protected Persona acusado;
    protected String pruebas;
    protected String estado;
    public Acusado_Delito(Persona acusado, String pruebas, String estado) {
        super();
        this.acusado = acusado;
        this.pruebas = pruebas;
        this.estado = estado;
    }
    public Persona getAcusado() {
        return acusado;
    }
    public String getPruebas() {
        return pruebas;
    }
    public String getEstado() {
        return estado;
    }
    
}

class Acusado_Asesinato extends Acusado_Delito{
    public Acusado_Asesinato(Persona acusado, String pruebas, String estado) {
        super(acusado, pruebas, estado);
    }
    private boolean presenciaHuellas;
    private boolean motivo;
    private String tipo_motivo;

}


//COMPLETAR
class DelitoComparator implements Comparator<Delito> {

    @Override
    public int compare(Delito delito1, Delito delito2) {
    	if(delito1.tieneMenores() && !delito2.tieneMenores()) {
    		return -1;
    	}else if(!delito1.tieneMenores() && delito2.tieneMenores()) {
    		return 1;
    	}else if (!delito1.tieneMenores() && !delito2.tieneMenores()){
    		if(delito1.tieneAsesinato() && !delito2.tieneAsesinato()) {
    			return -1;
    		}else if(!delito1.tieneAsesinato() && delito2.tieneAsesinato()) {
    			return 1;
    		}
    	}
		return delito2.getFecha().compareTo(delito1.getFecha());
		
        
    }
}  


class ExceptionAsesino extends Exception{
	public ExceptionAsesino(String s) {
		super(s);
	}
}

public class CSI2 {
    
    private ArrayList<Persona> personas;
    private ArrayList<Delito> delitos;
    
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    public ArrayList<Delito> getDelitos() {
        return delitos;
    }
    public void setDelitos(ArrayList<Delito> delitos) {
        this.delitos = delitos;
    }
    //COMPLETAR
    public ArrayList<Persona> listaAsesinos() throws ExceptionAsesino{
    	 ArrayList<Persona> asesinos = listaAsesinos(0,0, new ArrayList<Persona>());
    	 if(asesinos.isEmpty()) {
    		 throw new ExceptionAsesino("No hay asesinos");
    	 }
        return asesinos;
    }
    
    private ArrayList<Persona> listaAsesinos(int i, int j, ArrayList<Persona> list){
    	if(i == delitos.size()) {
			return list;
		}
    	if(j == delitos.get(i).getAcusados().length) {
    		
    		
    		return listaAsesinos(i+1,0,list);
    	}
    	
    	Acusado_Delito p = delitos.get(i).getAcusados()[j];
    	Persona a = p.getAcusado();
    	if(p instanceof Acusado_Asesinato && valid(list, a) && p.getEstado().equals("enjuiciado")) {
    		list.add(a);
    	}
    	
    	return listaAsesinos(i,j+1,list);
    	
    }
    
    private boolean valid (ArrayList<Persona> list, Persona p) {
    	
    	if(list.size() == 0) {
    		return true;
    	}
    	int index = 0;
    	
    	while(index < list.size() && !p.equals(list.get(index))) {
    		index++;
    	}
    	
    	return index == list.size();
    }
    
    
    
    //COMPLETAR
    public PriorityQueue<Delito> ordenDelitos() {
    	PriorityQueue<Delito> orden = new PriorityQueue<Delito>(new DelitoComparator());
		ListIterator<Delito> l = delitos.listIterator();
		while(l.hasNext()) {
			orden.add(l.next());
		}
        return orden;
    }

    public static void main(String[] args) {
        CSI2 csi=new CSI2();
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        int ej=Integer.parseInt(line);
        ArrayList<Persona> personas=new ArrayList<Persona>();
        ArrayList<Acusado_Delito[]> acusados=new ArrayList<Acusado_Delito[]>();
        ArrayList<Delito> delitos=new ArrayList<Delito>();
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            if (lineSplit[0].compareTo("p")==0)
                personas.add(new Persona(lineSplit[1],lineSplit[2],lineSplit[3],lineSplit[4],Integer.parseInt(lineSplit[5])));
            else
                if (lineSplit[0].compareTo("a")==0) {
                    int cant=(lineSplit.length-1)/4;
                    Acusado_Delito[] acusadosDelito=new Acusado_Delito[cant];
                    for (int i=0; i<cant;i++)
                        if (lineSplit[i*4+1].compareTo("a")==0)
                            acusadosDelito[i]=new Acusado_Delito(personas.get(Integer.parseInt(lineSplit[i*4+2])-1),lineSplit[i*4+3],lineSplit[i*4+4]);
                        else
                            acusadosDelito[i]=new Acusado_Asesinato(personas.get(Integer.parseInt(lineSplit[i*4+2])-1),lineSplit[i*4+3],lineSplit[i*4+4]);
                    acusados.add(acusadosDelito);
                } else
                    try {
                        delitos.add(new Delito(lineSplit[0], new SimpleDateFormat("yyyy-MM-dd").parse(lineSplit[1]), lineSplit[2], lineSplit[3], acusados.get(Integer.parseInt(lineSplit[4])-1)));
                    } catch (NumberFormatException | ParseException e) {
                        e.printStackTrace();
                    }
                    
        }
        in.close();
        csi.setPersonas(personas);
        csi.setDelitos(delitos);
        
        if (ej==1) {
            ArrayList<Persona> asesinos = null;
            try {
                asesinos = csi.listaAsesinos();
            }catch (ExceptionAsesino e) {
            	System.out.println(e.getMessage());
            }
            if (asesinos!=null)
                System.out.println(asesinos.toString());
            
        }else {
            PriorityQueue<Delito> colaPrioridadDelitos= csi.ordenDelitos();
            while (colaPrioridadDelitos!=null && !colaPrioridadDelitos.isEmpty()) {
                Delito delito = colaPrioridadDelitos.poll();
                System.out.println("Delito: " + delito.codigo + ", Fecha: " + delito.fecha+", Menores: " + delito.tieneMenores()+", Asesinato: " +delito.tieneAsesinato());
            }
        }

    }

}
