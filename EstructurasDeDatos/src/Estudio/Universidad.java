package Estudio;

import java.util.Arrays;
import java.util.Scanner;

class Curso{
    private String codigo;
    private String nombre;
    private String[] codigoCursoPreRrequisitos;
    public Curso(String codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoCursoPreRrequisitos = new String[0];
    }
    public Curso(String codigo, String nombre, String[] codigoCursoPreRrequisitos) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoCursoPreRrequisitos = codigoCursoPreRrequisitos;
        
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String[] getCodigoCursoPreRrequisitos() {
        return codigoCursoPreRrequisitos;
    }
}


class Semestre{
    private int numero;
    private Curso[] cursos;
    
    public int getNumero() {
        return numero;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public Semestre(int numero, Curso[] cursos) {
        super();
        this.numero = numero;
        this.cursos = cursos;
    }
    
    public int searchCurso(String codigo) {
    	int index = 0;
    	while(index < cursos.length && !cursos[index].getCodigo().equals(codigo)) {
    		index ++;
    	}
    	return (index < cursos.length)? index: -1;
    }

    
}
class Carrera{
    private String nombre;
    private Semestre[] semestres;
    
    public String getNombre() {
        return nombre;
    }
    public Semestre[] getSemestres() {
        return semestres;
    }
    public Carrera(String nombre, Semestre[] semestres) {
        super();
        this.nombre = nombre;
        this.semestres = semestres;
    }

    public int[] searchCurso(String codigo) {
    	int indexS = -1;
    	int indexC = -1;
    	while(indexS < semestres.length && indexC == -1) {
    		indexS++;
    		indexC = semestres[indexS].searchCurso(codigo);
    		
    		
    	}
    	
    	int[] result = {indexS, indexC};
    	
    	return result;
    }
}

class Estudiante2 {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String carrera;
    private String semestre;
    private Curso[] cursosActivos;
    private Curso[] cursosFinalizados;
}

public class Universidad {
    private Carrera[] carreras;
    private Estudiante[] estudiantes;    
    public Universidad(Carrera[] carreras, Estudiante[] estudiantes) {
        super();
        this.carreras = carreras;
        this.estudiantes = estudiantes;
    }
    
    // Implemente
    public int[] buscarCurso(String codigo) {
        int index = 0;
        int r[] = new int[2];
        boolean flag = true;
        while(index < carreras.length && flag) {
        	r = carreras[index].searchCurso(codigo);
        	if(r[1] != -1) {
        		flag = false;
        	}else {
        		index++;
        	}
        	
        	
        	
        }
        
        int resultado[] = new int[3];
        System.arraycopy(r, 0, resultado, 1, r.length);
        resultado[0] = index;
        return resultado;
    }
    
   

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String materia=in.nextLine();
		int countCarrera=Integer.parseInt(in.nextLine());
		Carrera[] carrera=new Carrera[countCarrera];
		for(int i=0;i<carrera.length;i++) {
			String nombCarrera=in.nextLine();
			int countSemestre=Integer.parseInt(in.nextLine());
			Semestre[] semestre=new Semestre[countSemestre];
			for(int j=0;j<semestre.length;j++) {
				int numSemestre=Integer.parseInt(in.nextLine());
				int countCourse=Integer.parseInt(in.nextLine());
				Curso[] curso=new Curso[countCourse];
				for (int k=0;k<curso.length;k++) {
					String[] nl=in.nextLine().split(";");
					String[] pre=null;
					if (nl.length>2) {
						pre=new String[nl.length-2];
						System.arraycopy(nl, 2, pre, 0, pre.length);
					}
					curso[k]=new Curso(nl[0],nl[1],pre);
				}
				semestre[j]=new Semestre(numSemestre,curso);	
			}
			carrera[i]=new Carrera(nombCarrera,semestre);
		}
		
		Universidad u=new Universidad(carrera, null);
		int[] result=u.buscarCurso(materia);
		System.out.println(carrera[result[0]].getNombre());
		System.out.println(carrera[result[0]].getSemestres()[result[1]].getNumero());
		System.out.println(carrera[result[0]].getSemestres()[result[1]].getCursos()[result[2]].getNombre());
		
		in.close();

	}
}
