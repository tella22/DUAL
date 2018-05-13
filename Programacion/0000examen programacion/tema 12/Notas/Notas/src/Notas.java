import java.util.TreeSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class Notas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> mapaDeNombres  = new TreeMap<>();
		Map<Integer, String> MapNotasConString = new TreeMap<>();
		Map<Integer, TreeSet<String>> mapaNotasConSet = new TreeMap<>();
		Set<String> listaDeNombres = new TreeSet<>();
		String nombre,cadenaDeNombres;
		Integer nota;
		nombre = Leer.pedirCadena("Nombre (* para terminar)");
		while(!nombre.equals("*")){ 
			nota=Leer.pedirEntero("Nota (0-10)", "[0-9]|10");
			
			buscaNombre(mapaDeNombres, MapNotasConString, mapaNotasConSet, nombre);//controlar si el nombre ya existía 
			
			mapaDeNombres.put(nombre, nota);//   inserta/actualiza en el primer mapa
			
			// tratar los dos mapas siguientes si la nota existe en el mapa
			if(MapNotasConString.containsKey(nota)){
				listaDeNombres=mapaNotasConSet.get(nota);// obtener el TreeSet de nombres a partir de mapaNotasConSet
				listaDeNombres.add(nombre);// añadir el nombre al set
				cadenaDeNombres=MapNotasConString.get(nota);// obtener la cadena de nombres a partir de MapNotasConString
				cadenaDeNombres=cadenaDeNombres+"//"+nombre;// concatenar el nuevo nombre
				//MapNotasConString.put(nota,cadenaDeNombres);
				MapNotasConString.replace(nota, cadenaDeNombres);// actualizar el mapa
			}else{// tratar los dos mapas siguientes si la nota NO existe en el mapa
				listaDeNombres = new TreeSet<>(); // crea el nuevo set
				listaDeNombres.add(nombre);// añadir el nombre al set
				mapaNotasConSet.put(nota, (TreeSet<String>) listaDeNombres);// añadir el nodo de la nueva nota y set
				MapNotasConString.put(nota, nombre);// añadir el nodo de la nueva nota y cadena 
			}
			nombre = Leer.pedirCadena("Nombre (* para terminar)");
		}
		
		Leer.mostrarEnPantalla("Alumnos y sus notas");
		for (Entry<String, Integer> e : mapaDeNombres.entrySet()) {// escribir el mapa de los nombres y sus notas
			Leer.mostrarEnPantalla("Alumno : " + e.getKey() + " nota " + e.getValue());
		}
		Leer.mostrarEnPantalla("---------------------\nNotas y sus alumnos separados por //");
		for (Entry<Integer, String> e : MapNotasConString.entrySet()) {//escribir el mapa de las notas y los nombres en cadena
			Leer.mostrarEnPantalla("Nota : " + e.getKey() + " alumnos " + e.getValue());
		}
		Leer.mostrarEnPantalla("---------------------\nNotas y sus alumnos en lista");
		for (Entry<Integer, TreeSet<String>> e : mapaNotasConSet.entrySet()) {// escribir el mapa de las notas y los set de nombres
			Leer.mostrarEnPantalla("Nota : " + e.getKey() + " alumnos " + e.getValue().toString());
		}
	}

	private static void buscaNombre(Map<String, Integer> mapaDeNombres, Map<Integer, String> MapNotasConString,
			Map<Integer, TreeSet<String>> mapaNotasConSet, String nombre) {
		Set<String> listaDeNombres;
		String cadenaDeNombres;
		Integer notaAnterior;
		if(mapaDeNombres.containsKey(nombre)){//si el nombre se repite hay que arreglar los dos mapas de notas
			notaAnterior=mapaDeNombres.get(nombre);// nota antigua del nombre
			// arreglar el mapa mapaNotasConSet
			listaDeNombres=mapaNotasConSet.get(notaAnterior);// recupera el set del mapa mapaNotasConSet
			listaDeNombres.remove(nombre);//elimina del set el nombre
			if (listaDeNombres.isEmpty()){// si deja el set vacío solo estaba ese nombre-> hay que borrar el nodo de la nota
				mapaNotasConSet.remove(notaAnterior);
			}
			// arreglar el mapa MapNotasConString
			cadenaDeNombres=MapNotasConString.get(notaAnterior);// recupera el String de los nombres de la nota antigua
			cadenaDeNombres=cadenaDeNombres.replaceFirst(nombre, "");// borra el nombre de la cadena
			if(cadenaDeNombres.indexOf("//")==-1){// si en la cadena no quedan // era el único nombre-> hay que borrar el nodo nota-cadena
				MapNotasConString.remove(notaAnterior);
			}else if(cadenaDeNombres.indexOf("//")==0){// si aparecen // en las primeras posiciones, hemos borrado el primer nombre.
				cadenaDeNombres=cadenaDeNombres.substring(2);// quitamos las // del inicio
				MapNotasConString.put(notaAnterior, cadenaDeNombres);// actualizamos el nodo nota-cadena
			}else if(cadenaDeNombres.indexOf("//")==cadenaDeNombres.length()-2){// si aparecen // en las últimas posiciones, hemos borrado el último nombre.
				cadenaDeNombres=cadenaDeNombres.substring(0,cadenaDeNombres.length()-2);// eliminamos las // del final
				MapNotasConString.put(notaAnterior, cadenaDeNombres);// actualizamos el nodo nota-cadena
			}else {// el nombre estaba en medio
				cadenaDeNombres=cadenaDeNombres.replaceFirst("////", "//");// habrán quedado cuatro / seguidas, las dejamos en dos
				MapNotasConString.put(notaAnterior, cadenaDeNombres);// actualizamos el nodo nota-cadena
			}
		}
	}
}
