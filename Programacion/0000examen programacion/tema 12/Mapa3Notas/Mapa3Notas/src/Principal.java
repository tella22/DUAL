
/*
1.	Generar al azar los datos de 50 alumnos. 
2.	Después generar tres mapas (TreeMap), uno para cada nota
3.	Presentar un menú para poder listar la clase por cualquiera de las tres notas en orden ascendente.
4.	Presentar en pantalla el listado requerido.
*/
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Integer opcion;
		ArrayList<Alumno> arrayAlumnos = new ArrayList<Alumno>();
		// clave la nota, valor asociado indice de arrayAlumnos
		// donde esta esa nota
		TreeMap<Integer, LinkedList<Integer>> mapa1, mapa2, mapa3;
		mapa1 = new TreeMap<Integer, LinkedList<Integer>>();
		mapa2 = new TreeMap<>();
		mapa3 = new TreeMap<>();

		rellenarArrayAlumnos(arrayAlumnos);
		// imprimirArrayAlumnos(arrayAlumnos);
		generarMapa(arrayAlumnos, mapa1, 1);
		generarMapa(arrayAlumnos, mapa2, 2);
		generarMapa(arrayAlumnos, mapa3, 3);

		opcion = menu();
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				imprimirMapa(mapa1, arrayAlumnos);
				break;
			case 2:
				imprimirMapa(mapa2, arrayAlumnos);
				break;
			case 3:
				imprimirMapa(mapa3, arrayAlumnos);
				break;
			}
			opcion = menu();
		}

	}// main

	public static void rellenarArrayAlumnos(ArrayList<Alumno> arrayAlumnos) {
		Alumno unAlumno;
		String nombre;
		String apellido;
		int nota1;
		int nota2;
		int nota3;
		int indice;
		for (indice = 0; indice < 50; indice++) {
			nombre = nombreAzar();
			apellido = apellidoAzar();
			nota1 = enteroAzar(1, 10);
			nota2 = enteroAzar(1, 10);
			nota3 = enteroAzar(1, 10);
			unAlumno = new Alumno(nombre, apellido, nota1, nota2, nota3);
			arrayAlumnos.add(indice, unAlumno);
		}

	}// rellenarArrayAlumnos

	public static void imprimirArrayAlumnos(ArrayList<Alumno> arrayAlumnos) {
		for (Alumno alu : arrayAlumnos) {
			System.out.println(alu);
		}
	}// imprimirArrayAlumnos

	public static void generarMapa(ArrayList<Alumno> arrayAlumnos, TreeMap<Integer, LinkedList<Integer>> mapa,
			int numMapa) {
		int i;
		LinkedList<Integer> listaIndices;
		Integer nota = 0;
		for (i = 0; i < arrayAlumnos.size(); i++) {
			switch (numMapa) {
			case 1:
				nota = (Integer) arrayAlumnos.get(i).getNota1();
				break;
			case 2:
				nota = (Integer) arrayAlumnos.get(i).getNota2();
				break;
			case 3:
				nota = (Integer) arrayAlumnos.get(i).getNota3();
			}
			// vemos si la nota ya esta insertada en algun nodo del mapa
			if (!mapa.containsKey(nota)) {// si no esta insertada
				listaIndices = new LinkedList<Integer>();
				listaIndices.add(i);
				mapa.put(nota, listaIndices);
			} else {
				listaIndices = mapa.get(nota);
				listaIndices.add(i);
				// mapa.get(nota).add(i);// o se puede poner solamente esta sentencia
			}
		}
	}// generarMapa

	public static void imprimirMapa(TreeMap<Integer, LinkedList<Integer>> mapa, ArrayList<Alumno> arrayAlumnos) {

		for (Integer nota : mapa.keySet()) {
			LinkedList<Integer> listaIndices = mapa.get(nota);
			System.out.println(nota);
			for (Integer indice : listaIndices) {
				System.out.println(arrayAlumnos.get(indice));
			}
		}
	}// imprimirMapa

	public static String nombreAzar() {
		Random azar = new Random();

		String nombres[] = { "Santiago", "Sebastián", "Diego", "Thiago", "Nicolás", "Samuel", "Dario", "Alejandro",
				"Mateo", "Ángel", "Matías", "Gabriel", "Tomás", "David", "Emiliano", "Andrés", "Joaquín", "Carlos",
				"Alexander", "Adrián", "Lucas", "Sofía", "Camila", "Valentina", "Isabella", "Valeria", "Daniela",
				"Mariana", "Sara", "Victoria", "Gabriela", "Ximena", "Andrea", "Natalia", "Mía", "Martina", "Lucía",
				"Samantha", "María", "Paula", "Nicole" };

		return nombres[azar.nextInt(nombres.length)];
	}// nombreAzar

	public static String apellidoAzar() {
		Random azar = new Random();

		String apellidos[] = { "Abadía", "Abarca", "Abellán", "Abiego", "Acorella", "Baldovinos", "Bandrés", "Cabra",
				"Cajal", "Calasanz", "Samper", "Latorre", "Escolano", "Cebrián", "Clemente", "Navarro", "García",
				"Hernández", "Martínez", "López", "Pérez", "Fernández", "Ruiz", "Sánchez", "Rodríguez", "Gómez",
				"González", "Jiménez", "Cruz", "Requena", "Moreno", "Reyes", "Morillas", "Cortes", "Ortiz", "Romero",
				"Medialdea", "Expósito", "Raya", "Sierra", "Membrilla", "Casado", "Amezcua", "Muñoz", "Santiago",
				"Delgado", "Moya", "Serrano", "Contreras", "Hidalgo", "Mesa", "Pozo", "Soria", "Vera", "Varón",
				"Parra" };

		return apellidos[azar.nextInt(apellidos.length)];
	}// apellidoAzar

	public static int enteroAzar(int desde, int hasta) {
		Random azar = new Random();
		return azar.nextInt(hasta - desde + 1) + desde;
	}// enteroAzar

	public static Integer menu() {
		Integer opcion = null;
		Leer.mostrarEnPantalla("1.- Listado ordenado por la nota 1");
		Leer.mostrarEnPantalla("2.- Listado ordenado por la nota 2");
		Leer.mostrarEnPantalla("3.- Listado ordenado por la nota 3");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion = Leer.pedirEntero("Elija opcion");
		return opcion;
	}
}// class
