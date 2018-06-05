import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GestionVideojuegos {

	public static void main(String[] args) throws IOException {

		TreeSet<Videojuego> videojuegos = new TreeSet<Videojuego>();
		File objetos = new File("objetos.dat");
		if (objetos.exists()) {
			videojuegos = manejoFichero.leer();

		} else {
			crearJuegos(videojuegos);/* creamos el ArrayList con juegos */
		}
		Leer.mostrarEnPantalla("*************");
		Leer.mostrarEnPantalla("Fichero leido");
		Leer.mostrarEnPantalla("*************");

		int opcion = menu();
		while (opcion != 0) {
			switch (opcion) {
			case 1:// dar de alta un juego
				altaVideojuego(videojuegos);
				// ...
				break;
			case 2:// dar de baja un juego
				bajaVideojuego(videojuegos);
				// ...
				break;
			case 3:// modificar un juego
				modificaVideojuego(videojuegos);
				// ...
				break;
			case 4:// listar videojuegos [No recuerdo como ordenar]
				listarVideojuegos(videojuegos);
				break;
			case 5:
				listadoFabricante(videojuegos);
				break;
			}
			opcion = menu();
		}
		manejoFichero.escribe(videojuegos);
	}

	public static void altaVideojuego(TreeSet<Videojuego> videojuegos) {// damos de alta un videojuego

		Videojuego juego;
		String nombre = Leer.pedirCadena("Introduce el nombre");
		for (Videojuego juego2 : videojuegos) {
			if (juego2.buscar(nombre) != null) {
				Leer.mostrarEnPantalla("El juego ya existe.");
				break;
			} else {
				String fabricantes = Leer.pedirCadena("Introduce el fabricante");
				Integer edadMinima = Leer.pedirEntero("Introduce la edad minima");
				Float precio = Leer.pedirFloat("Introduce el precio");
				Integer unidadesVendidas = Leer.pedirEntero("Introduce las unidades vendidas");
				String plataforma = Leer.pedirCadena("Introduce la plataforma");
				String tipo = Leer.pedirCadena("Introduce tipo de juego");
				juego = new Videojuego(nombre, fabricantes, edadMinima, precio, unidadesVendidas, tipo, plataforma);
				videojuegos.add(juego);
			}

		}

	}

	public static void bajaVideojuego(TreeSet<Videojuego> videojuegos) {// damos de baja un videojuego
		String nombre = Leer.pedirCadena("Introduce el nombre del juego a borrar");
		Videojuego aBorrar;
		for (Videojuego juego : videojuegos) {
			// aBorrar = juego.buscar(nombre);
			if (juego.buscar(nombre) != null) {
				videojuegos.remove(juego);
				Leer.mostrarEnPantalla("Juego eliminado");
				break;
			}
		}
	}

	public static void modificaVideojuego(TreeSet<Videojuego> videojuegos) {// modificamos un videojuego
		String nombre = Leer.pedirCadena("Introduce el nombre del juego a modificar");
		for (Videojuego juego : videojuegos) {
			// aBorrar = juego.buscar(nombre);
			if (juego.buscar(nombre) != null) {
				String nombreNuevo = Leer.pedirCadena("Introduce el nombre, 0 para no modificar");
				if (nombreNuevo.equals("0")) {
				} else {
					juego.setNombre(nombreNuevo);
				}
				String fabricanteNuevo = Leer.pedirCadena("Introduce el fabricante, 0 para no modificar");
				if (fabricanteNuevo.equals("0")) {
				} else {
					juego.setFabrincante(fabricanteNuevo);
				}
				Integer unidadesNuevas = Leer.pedirEntero("Introduce las unidades vendidas, 0 para no modificar");
				if (unidadesNuevas.equals(0)) {
				} else {
					juego.setUnidadesVendidas(unidadesNuevas);
				}
				Integer edadMinima = Leer.pedirEntero("Introduce las edad minima, 0 para no modificar");
				if (edadMinima.equals(0)) {
				} else {
					juego.setEdadMinima(edadMinima);
				}
				Float precioNuevo = Leer.pedirFloat("Intorduce el precio nuevo, 0 para no modificar");
				if (precioNuevo.equals(0F)) {
				} else {
					juego.setPrecio(precioNuevo);
				}
				String plataformaNueva = Leer.pedirCadena("Introduce la plataforma, 0 para no modificar");
				if (plataformaNueva.equals("0")) {
				} else {
					juego.setPlataforma(plataformaNueva);
				}
				String formaNueva = Leer.pedirCadena("Introduce la forma de juego, 0 para no modificar");
				if (formaNueva.equals("0")) {
				} else {
					juego.setFormaJuego(formaNueva);
				}

			}
			Leer.mostrarEnPantalla("Juego: " + nombre + " modificado");
			break;
		}
	}

	public static void listarVideojuegos(TreeSet<Videojuego> videojuegos) {
		System.out.println();
		for (Videojuego juego : videojuegos) {
			System.out.println(juego.toString());
		}
		System.out.println();
	}

	public static int menu() {// mostramos el menu
		int op;
		Leer.mostrarEnPantalla("GESTION DE VIDEOJUEGOS");
		Leer.mostrarEnPantalla("-------------------");
		Leer.mostrarEnPantalla("1 - Alta de videojuegos");
		Leer.mostrarEnPantalla("2 - Baja de videojuegos");
		Leer.mostrarEnPantalla("3 - Modificación de videojuegos");
		Leer.mostrarEnPantalla("4 - Listado de videojuegos por nombre");
		Leer.mostrarEnPantalla("5 - Listado de videojuegos por fabricante");
		Leer.mostrarEnPantalla("0 - Salir y guardar sesion");
		op = Leer.pedirEntero("Elija opcion", "[0-5]");
		return op;
	}

	public static void crearJuegos(TreeSet<Videojuego> videojuegos) {// creamos los juegos
		String[] juegos = { "League of legends", "Final Fantasy XXVII", "Star Wars", "FIFA 2020" };
		String[] fabricantes = { "F1", "F1", "F2", "F3" };
		Integer[] edadesMinimas = { 12, 14, 15, 8 };
		Float[] precios = { 20.f, 30.f, 35.f, 25.f };
		String[] plataformas = { "PC", "PC", "XBox", "Play Station" };
		Integer[] unidadesVendidas = { 1000, 900, 2000, 1300 };
		String[] formasJuegos = { "En red", "Multijugador", "Multijugador", "En red" };
		int i;
		Videojuego juego;
		for (i = 0; i < juegos.length; i++) {
			juego = new Videojuego(juegos[i], fabricantes[i], edadesMinimas[i], precios[i], unidadesVendidas[i],
					plataformas[i], formasJuegos[i]);
			videojuegos.add(juego);
		}
	}

	public static void listadoFabricante(TreeSet<Videojuego> videojuegos) {
		TreeSet<Videojuego> auxiliar = new TreeSet<Videojuego>(Videojuego.compVideojuego);
		auxiliar.addAll(videojuegos);
		for (Videojuego juego : auxiliar) {
			Leer.mostrarEnPantalla(juego + "");
		}
	}
}
