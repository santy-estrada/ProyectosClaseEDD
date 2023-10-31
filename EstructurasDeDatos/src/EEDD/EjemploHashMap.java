package EEDD;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import Ordenamiento.Persona;

public class EjemploHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="Hola";
		System.out.println(x.hashCode());
		System.out.println();
		
		Integer i=2;
		System.out.println(i.hashCode());
		
		HashMap<String,String> map=new HashMap<String,String>(); 
		map.put("1_4","Alex");  
		map.put("1_2","Ana");    
		map.put("1_3","Juan");   
		map.put("1_1","Pedro");   

		for(Map.Entry<String,String> m : map.entrySet()){    
			System.out.println(m.getKey()+" "+m.getValue());    
		} 
		System.out.println("___________________________");
		
		
		LinkedHashMap<String,String> lmap=new LinkedHashMap<String,String>(); 
		lmap.put("1_4","Alex");  
		lmap.put("1_2","Ana");    
		lmap.put("1_3","Juan");   
		lmap.put("1_1","Pedro");   

		for(Map.Entry<String,String> m : lmap.entrySet()){    
			System.out.println(m.getKey()+" "+m.getValue());    
		} 
		
		System.out.println("___________________________");
		Persona p1=new Persona("Alex", 23);
		Persona p2=new Persona("Pedro", 27);
		Persona p3=new Persona("Juan", 20);
		Persona p4=new Persona("Ana", 18);
		HashMap<Integer,Persona> mapP=new HashMap<Integer,Persona>();
		mapP.put(3,p3);
		mapP.put(1,p1);
		mapP.put(2,p2);
		mapP.put(4,p4);
		
		for(Map.Entry<Integer,Persona> m : mapP.entrySet()){ 
			Persona aux=m.getValue();
			System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());    
		} 
		System.out.println(mapP);
		//////////////////////////////////////////////////////////////////////////
		/*TreeMap<Integer,Persona> mapT=new TreeMap<Integer,Persona>();
		mapT.put(3,p3);
		mapT.put(1,p1);
		mapT.put(2,p2);
		mapT.put(4,p4);

		System.out.println("___________________________");
		
		for(Map.Entry<Integer,Persona> m : mapT.entrySet()){ 
			Persona aux=m.getValue();
			System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());    
		} 
		System.out.println(mapT);*/
		
		//////////////////////////////////////////////////////////
		SortedMap<Integer,Persona> mapTS=new TreeMap<Integer,Persona>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		mapTS.put(3,p3);
		mapTS.put(1,p1);
		mapTS.put(2,p2);
		mapTS.put(4,p4);
		System.out.println("___________________________");
		for(Map.Entry<Integer,Persona> m : mapTS.entrySet()){ 
			Persona aux=m.getValue();
			System.out.println(m.getKey()+": "+aux.getNombre()+" "+aux.getEdad());    
		} 
		System.out.println(mapTS);
		
		// Si ponemos llaves repetidas los reemplaza
		mapTS.put(2,p1);
		System.out.println(mapTS);
		/*
		mapTS.remove(3);
		System.out.println(mapTS);
		*/
		


	}

}
