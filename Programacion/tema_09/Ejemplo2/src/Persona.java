import utilidades.Leer;

public class Persona extends Mamifero {

	private String profesion;

	public Persona() {

		System.out.print(" y persona");
	}

	void insertarDatosPers() {

		insertarDatosMamif();
		System.out.print("\t\tProfesi�n de esta persona: ");
		profesion = Leer.pedirCadena();
	}

	public void visualizarDatos() {

		visDatosMamif();
		System.out.println("\n\t profesi�n: " + profesion);
	}
}
