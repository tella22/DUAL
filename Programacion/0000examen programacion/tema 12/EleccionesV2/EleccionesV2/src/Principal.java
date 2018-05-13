
/*Se usa un TreeMap con clave el nombre del partido y valor asociado un objeto
  de clase Partido. Y además:
  
  TreeMap con clave el cociente y valor asociado un TreeSet que en cada elemento
guarda el nombre del partido a quien pertenece ese cociente. Si hay varios partidos
que están empatados en el valor de algún cociente, en el correspondiente TreeSet 
estarán almacenados los nombres de esos partidos.
El mapa debe estar ordenado por los valores de los cocientes de mayor a menor.
Si hay M escaños se recorren los primeros elementos del TreeMap mapReparto y se va
llevando la cuenta de los elementos de los TreeSet que se guardan en cada nodo del mapa,
que nos indican a quien corresponden los escaños. En este ejercicio nos interesa
recorrer los primeros nodos del mapa y llevar la cuenta del número de elementos
recorridos de los TreeSet que van asociados a cada nodo porque, cuando tengamos 
tantos como escaños en total, se termina.*/
import java.util.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// mapa de partidos
		TreeMap<String, Partido> mapPartidos = new TreeMap<String, Partido>();
		// mapa de cocientes con lista de partidos que han obtenido cada
		// cociente
		TreeMap<Integer, TreeSet<String>> mapReparto = new TreeMap<Integer, TreeSet<String>>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int numEscaños;
		int numPartidos;
		numEscaños = Leer.pedirEntero("Número de escaños");
		numPartidos = Leer.pedirEntero("Número de partidos");
		// creamos los partidos antes de las elecciones
		rellena(mapPartidos, numPartidos);
		Leer.mostrarEnPantalla("Estos son los partidos:");
		Leer.mostrarEnPantalla(mapPartidos.toString());
		// celebramos las elecciones y calculamos los cocientes
		votacion(mapReparto, mapPartidos, numEscaños);
		Leer.mostrarEnPantalla("\nEstos son los partidos y los resultados antes del reparto de escaños:");
		Leer.mostrarEnPantalla(mapPartidos.toString());
		Leer.mostrarEnPantalla("\nEstos son los cocientes:");
		Leer.mostrarEnPantalla(mapReparto.toString());
		// Reparto de escaños
		calcula(mapReparto, mapPartidos, numEscaños);
		Leer.mostrarEnPantalla("\n*************************************************");
		Leer.mostrarEnPantalla(mapPartidos.toString());
		Leer.mostrarEnPantalla("\n*************************************************");

	}

	public static void rellena(TreeMap<String, Partido> mapPartidos, int numPartidos) {
		String partido;
		Partido part;
		for (int i = 1; i <= numPartidos; i++) {
			partido = "Partido" + i;
			part = new Partido(partido);
			mapPartidos.put(partido, part);
		}
	}

	public static void votacion(TreeMap<Integer, TreeSet<String>> mapReparto, TreeMap<String, Partido> mapPartidos,
			int numEscaños) {
		String nombrePartido = "";
		Partido unPartido;
		TreeSet<String> listaPartidos = null;
		Integer votosAUnPartido, totalVotos = 0, cociente = 0;

		for (Map.Entry<String, Partido> nodoDeMapaPartidos : mapPartidos.entrySet()) {
			votosAUnPartido = (int) (Math.random() * 10000 + 3000);
			nombrePartido = nodoDeMapaPartidos.getKey();
			unPartido = nodoDeMapaPartidos.getValue();
			unPartido.setVotos(votosAUnPartido);
			mapPartidos.put(nombrePartido, unPartido);
			totalVotos += votosAUnPartido;
		} // recorre partidos asignando los votos
		
		eliminarPartidosConPocosVotos(mapPartidos, totalVotos);

		// calcula los cocientes de los votos de los partidos que quedan para el reparto
		for (Map.Entry<String, Partido> nodoDeMapaPartidos : mapPartidos.entrySet()) {
			unPartido = nodoDeMapaPartidos.getValue();
			votosAUnPartido = unPartido.getVotos();
			for (int i = 1; i <= numEscaños; i++) {
				cociente = votosAUnPartido / i;
				if (mapReparto.containsKey(cociente)) {
					// obtener el TreeSet de nombres de partidos que tienen ese cociente
					// y añadir el nombre del partido
					mapReparto.get(cociente).add(unPartido.getNombre());
				} else {// ese cociente no esta en el mapa de reparto
					listaPartidos = new TreeSet<String>();
					listaPartidos.add(unPartido.getNombre());
					mapReparto.put(cociente, listaPartidos);
				}
			} // calcula cocientes
		}
	} // votacion

	public static void eliminarPartidosConPocosVotos(TreeMap<String, Partido> mapPartidos, Integer totalVotos) {
		Iterator<Map.Entry<String, Partido>> it = mapPartidos.entrySet().iterator();
		// Recorremos el mapa de partidos
		Leer.mostrarEnPantalla("\n/*/*/*/*/*/* eliminarPartidosConPocosVotos /*/*/*/*/*/*/*/*");
		Leer.mostrarEnPantalla("------------------> el 5% de los votos es: " + totalVotos * 0.05);
		while (it.hasNext()) {
			Map.Entry<String, Partido> nodoDeMapaPartidos = (Map.Entry<String, Partido>) it.next();
			Leer.mostrarEnPantalla(nodoDeMapaPartidos.getKey() + ": " + nodoDeMapaPartidos.getValue());
			// Eliminamos del mapa a los que han obtenido menos del 5% de los
			// votos
			if (nodoDeMapaPartidos.getValue().getVotos() < totalVotos * 0.05) {
				it.remove();
			}
		}
		Leer.mostrarEnPantalla("\n/*/*/*/*/*/* eliminarPartidosConPocosVotos /*/*/*/*/*/*/*/*\n");
	}//eliminarPartidosConPocosVotos

	public static void calcula(TreeMap<Integer, TreeSet<String>> mapReparto, TreeMap<String, Partido> mapPartidos,
			int numEscanios) {

		Partido unPartido;
		TreeSet<String> listaPartidos;
		Integer cociente = 0, contadorEscanios = 0;
		Leer.mostrarEnPantalla("\n/*/*/*/*/*/* metodo calcula /*/*/*/*/*/*/*/*");
		for (Map.Entry<Integer, TreeSet<String>> nodoDeMapaReparto : mapReparto.entrySet()) {
			cociente = nodoDeMapaReparto.getKey();
			Leer.mostrarEnPantalla("-->" + cociente);
			listaPartidos = nodoDeMapaReparto.getValue();
			Leer.mostrarEnPantalla(listaPartidos.toString());
			// recorremos la lista de partidos que han empatado en ese cociente
			for (String nombrePartido : listaPartidos) {
				unPartido = mapPartidos.get(nombrePartido);
				unPartido.setEscaños(unPartido.getEscaños() + 1);
				// actualizamos el nodo en el mapa de partidos
				mapPartidos.put(nombrePartido, unPartido);
				contadorEscanios++;
				if (contadorEscanios == numEscanios) {
					break;
				}
			}
			if (contadorEscanios == numEscanios) {
				break;
			}
		}
		Leer.mostrarEnPantalla("/*/*/*/*/*/* metodo calcula /*/*/*/*/*/*/*/*\n");
	}

}
