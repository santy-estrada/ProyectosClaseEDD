package Diagnóstico;

import java.util.Arrays;

public class SolucionCancion {
    
    private CD[] cds;
    
    public SolucionCancion(CD[] cds) {
        super();
        this.cds = cds;
    }

    //Buscar canciones de un cantante y  que tengan un texto dentro
    //Anadir antes de cada album el titulo "CD: Nombre del Album"
    public String[] tituloCancionesCantanteporAlbum(String cantante, String textoBuscado) {
        // Complete este codigo
        String[] r = new String[0];
        int pos = 0;
        for(int i = 0; i < cds.length; i++){
            int l = cds[i].buscarCantanteTextoCanciones(cantante, textoBuscado).length;
            String[] aux = cds[i].buscarCantanteTextoCanciones(cantante, textoBuscado);
            //aux = cds[i].buscarCantanteTextoCanciones(cantante, textoBuscado).clone();
            r = Arrays.copyOf(r, r.length + l);
            for(int j = 0; j < l; j++){
                r[pos] = aux[j];
                pos++;
            }
        }
        return r;
    }
}
