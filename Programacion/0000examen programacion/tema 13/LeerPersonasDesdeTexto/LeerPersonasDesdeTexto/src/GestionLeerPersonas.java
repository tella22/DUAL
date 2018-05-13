import java.io.*;
public class GestionLeerPersonas {

	public static void main(String[] args) {
		Persona reg;
		Fichero ficheroTexto = new Fichero("fichero.txt");
		reg = ficheroTexto.leer();
		while (reg != null) {
			System.out.println("\nNombre  : " + reg.getNombre());
			System.out.println("Apellido: " + reg.getApellido());
			System.out.println("Edad : " + reg.getEdad());
			reg = ficheroTexto.leer();
		}
		ficheroTexto.cerrar();
	}
}
