import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class GestionPersonas {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<>();
		File archivo = new File("fichTextoExamen.txt");
		FicheroTexto fichero;
		int opcion;
		if (archivo.exists()) {
			fichero = new FicheroTexto("fichTextoExamen.txt", "I");
			leeFichero(personas, fichero);
		}

		opcion = menu();

		do {
			switch (opcion) {
			case 1:
				listaPersonas(personas);
				break;
			case 2:
				altaPersonas(personas);
				break;
			case 3:
				listarEstudiantes(personas);
				break;
			case 4:
				listarTrabajadores(personas);
				break;
			}
			opcion = menu();
		} while (opcion != 0);
	}

	public static int menu() {
		int opcion;
		Leer.mostrarEnPantalla("1.- Listar personas");
		Leer.mostrarEnPantalla("2.- Alta de personas");
		Leer.mostrarEnPantalla("3.- Listar estudiantes");
		Leer.mostrarEnPantalla("4.- Listar trabajadores");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion = Leer.pedirEntero("Elija opcion", "[0-4]");

		return opcion;
	}

	public static void listaPersonas(ArrayList<Persona> personas) {
		for (Persona pers : personas) {
			Leer.mostrarEnPantalla("Nombre  : " + pers.getNombre());
			Leer.mostrarEnPantalla("Apellido: " + pers.getApellido());
			System.out.println();
		}
	}

	public static void listarEstudiantes(ArrayList<Persona> personas) {
		for (Persona pers : personas) {
			if (pers.getClass().toString().equals("class Estudiante")) {
				Leer.mostrarEnPantalla("Nombre: " + pers.getNombre());
				Leer.mostrarEnPantalla("Apellido: " + pers.getApellido());
				System.out.println();
			}
		}
	}

	public static void listarTrabajadores(ArrayList<Persona> personas) {
		for (Persona pers : personas) {
			if (pers instanceof Trabajador) {
				Leer.mostrarEnPantalla("Nombre: " + pers.getNombre());
				Leer.mostrarEnPantalla("Apellido: " + pers.getApellido());
				System.out.println();
			}
		}
	}

	public static void altaPersonas(ArrayList<Persona> personas) {
		String opt;
		do {
			opt = Leer.pedirCadena("Introduce E para dar de alta a un estudiante, T para dar de alta a un trabajador");
		} while (!opt.equals("E") && !opt.equals("T") && !opt.equals("P"));
		if (opt.equals("E")) {
			String nombre = Leer.pedirCadena("Introduce el nombre");
			String apellido = Leer.pedirCadena("Introduce el apellido");
			Integer curso = Leer.pedirEntero("Introduce el curso");
			String estudios = Leer.pedirCadena("Introduce los estudios");

			Estudiante est = new Estudiante(nombre, apellido, curso, estudios);
			personas.add(est);
		} else if (opt.equals("T")) {
			String nombre = Leer.pedirCadena("Introduce el nombre");
			String apellido = Leer.pedirCadena("Introduce el apellido");
			String categoria = Leer.pedirCadena("Introduce la categoria");
			Float sueldo = Leer.pedirFloat("Introduce el sueldo");

			Trabajador tra = new Trabajador(nombre, apellido, categoria, sueldo);
			personas.add(tra);
		}
	}

	private static void leeFichero(ArrayList<Persona> lista, FicheroTexto fichero) {
		Persona reg;
		reg = fichero.leer();
		while (reg != null) {
			lista.add(reg);// lo añadimos a la lista
//			Leer.mostrarEnPantalla("Nombre  : " + reg.getNombre());// imprimimos nombre
//			Leer.mostrarEnPantalla("Apellido: " + reg.getApellido());// imprimimos apellido
			reg = fichero.leer();// leemos siguiente
		}
		fichero.cerrar("I");// cerrar fichero de lectura
	}

}
