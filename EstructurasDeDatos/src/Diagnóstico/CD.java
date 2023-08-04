package Diagnóstico;

import java.util.Arrays;
import java.util.Scanner;

class Cancion{
    private String titulo;
    private String[] cantante;
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String[] getCantante() {
        return cantante;
    }
    public void setCantante(String[] cantante) {
        this.cantante = cantante;
    }
    public Cancion(String titulo, String[] cantante) {
        super();
        this.titulo = titulo;
        this.cantante = cantante;
    }
    
}

class CD{
    private String nombre;
    private Cancion[] canciones;
        
    public CD(String nombre, Cancion[] canciones) {
        super();
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public Cancion[] getCanciones() {
        return canciones;
    }


    public String[] buscarCantanteTextoCanciones(String cantante, String textoBuscado) {
    // Complete este metodo
        textoBuscado = textoBuscado.toUpperCase();
        String[] match = new String[2];
        int j = 0;
        boolean flag = true;
        for(int i = 0; i < canciones.length; i++){
            if(canciones[i].getTitulo().toUpperCase().indexOf(textoBuscado) != -1){
                for(int k = 0; k < canciones[i].getCantante().length; k++){
                    if(canciones[i].getCantante()[k].equals(cantante)){
                    	if (flag) {
                    		match[j] = "CD: " + nombre;
                    		flag = false;
                    		match[j+1] = canciones[i].getTitulo();
                            match = Arrays.copyOf(match, match.length+2);
                            j += 2;
                    	}else {
                            match[j] = canciones[i].getTitulo();
                            match = Arrays.copyOf(match, match.length+1);
                            j++;
                    	}
                    }
                }
            }
        }
        match = Arrays.copyOf(match, match.length-2);
        return match;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String musico=in.nextLine();
        String palabraBuscar=in.nextLine();
        String line=in.nextLine();
        CD[] cds=new CD[0];
        while (line.compareTo("")!=0) {
            String album=line;
            Cancion[] canciones=new Cancion[0];
            while ((line=in.nextLine()).compareTo("")!=0 && line.substring(0, 3).compareTo("CD:")!=0) {
                String[] lineSplit=line.split(", ");
                String[] musicos=new String[lineSplit.length-1];
                System.arraycopy(lineSplit, 1, musicos, 0, lineSplit.length-1);
                Cancion c=new Cancion(lineSplit[0], musicos);
                canciones=Arrays.copyOf(canciones, canciones.length+1);
                canciones[canciones.length-1]=c;
            }
            CD cd=new CD(album.substring(4,album.length()), canciones);
            cds=Arrays.copyOf(cds, cds.length+1);
            cds[cds.length-1]=cd;
        }
        SolucionCancion solucion=new SolucionCancion(cds);
        String[] coincidencias=solucion.tituloCancionesCantanteporAlbum(musico, palabraBuscar);
        if (coincidencias!=null)
            for (String s:coincidencias)
                System.out.println(s);
        in.close();
    }

}
