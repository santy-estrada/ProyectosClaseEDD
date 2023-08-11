package Quiz1;

import java.util.*;

//Adicione lo que crea necesario

class Producto{
 private String tipo;
 private String codigo;
 private String nombre;
 private double precio;
 

   public Producto(String tipo, String codigo, String nombre, double precio) {
     this.tipo=tipo;
     this.codigo = codigo;
     this.nombre = nombre;
     this.precio = precio;
 }
   
   public String getCodigo() {
	   return codigo;
   }
   
   public double getPrecio(){
	   return precio;
   }
   
   public String getTipo() {
	   return tipo;
   }
   
   public String getNombre() {
	   return nombre;
   }
 
}


public class Tienda {
 private Producto[] productos;
 
 
 public Tienda(Producto[] productos) {
     this.productos =productos;
 }
 

 // Complete
 public String[] listaPrecioMayor(String tipo, double precio) {
	 String lista[] = new String[0];
	 for(Producto p: productos) {
		 if(p.getTipo().equalsIgnoreCase(tipo) && p.getPrecio() > precio) {
			 lista = Arrays.copyOf(lista, lista.length+1);
			 lista[lista.length-1] = p.getCodigo();
		 }
	 }
	 
	 return(lista.length == 0)? null: lista;

 }
 
 public static void main(String[] args) {
     
     Scanner in = new Scanner(System.in);
     String tipo=in.nextLine();
     double precio=Double.parseDouble(in.nextLine());
     String line;
     Producto[] lista=new Producto[0];
     while ((line=in.nextLine()).compareTo("")!=0) {
         String[] lineSplit=line.split(", ");
         Producto p;
         p=new Producto(lineSplit[0],lineSplit[1],lineSplit[2],Double.parseDouble(lineSplit[3]));
         lista=Arrays.copyOf(lista, lista.length+1);
         lista[lista.length-1]=p;
     }
     Tienda tienda=new Tienda(lista);
     String[] listaPrecio=tienda.listaPrecioMayor(tipo, precio);
     if (listaPrecio!=null)
         for (String p:listaPrecio)
             System.out.println(p);
     System.out.println(); 
     in.close();
     
 }

}
