package EstudioFinal;

import java.util.*;


class Video implements Comparable<Video>{
    private String autor;
    private String id;
    private int me_gusta;
    private int visualizaciones;
    private int comentarios;
        
    
    public Video(String autor, String id, int me_gusta, int visualizaciones, int comentarios) {
        super();
        this.autor = autor;
        this.id = id;
        this.me_gusta = me_gusta;
        this.visualizaciones = visualizaciones;
        this.comentarios = comentarios;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getMe_gusta() {
        return me_gusta;
    }
    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }
    public int getVisualizaciones() {
        return visualizaciones;
    }
    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
    public int getComentarios() {
        return comentarios;
    }
    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        return  autor + ":"+ me_gusta ;
    }
    @Override
    public int compareTo(Video arg0) {
        if(arg0.getVisualizaciones() == visualizaciones && arg0.getMe_gusta() == me_gusta) {
        	return - comentarios + arg0.getComentarios();
        }
        if(arg0.getVisualizaciones() == visualizaciones) {
        	return -me_gusta + arg0.getMe_gusta();
        }
        
        return - visualizaciones + arg0.getVisualizaciones();
    }
}




public class Tiktok {
    
    public Video[] videoOrdenado(Video[] videos) {
		PriorityQueue<Video> pq = new PriorityQueue<Video>();
		for(Video v: videos) {
			pq.add(v);
		}
		
		Video[] s = new Video[pq.size()];
		int size = pq.size();
		for(int i = 0; i < size; i++) {
			s[i] = pq.poll();
		}
		return s;
    }
        


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        Video[] videos=new Video[0];
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            Video v=new Video(lineSplit[0],lineSplit[1], Integer.parseInt(lineSplit[2]),
                    Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]));
            videos=Arrays.copyOf(videos, videos.length+1);
            videos[videos.length-1]=v;
        }
        Tiktok t=new Tiktok();
        Video[] videosO=t.videoOrdenado(videos);
        for (Video v:videosO)
            System.out.println(v);
        in.close();
    
    }

}
