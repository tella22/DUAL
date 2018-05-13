import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestionLeerPersonas {

	public static void main(String[] args) {
		List<Persona> lista = new ArrayList<>();//Lista para guardar las personas
		// el fichero contiene un solo objeto de clase List<Persona>
		File objetoFile = new File("fichero.da2");
		Fichero fichero;
		if (objetoFile.exists()){
			fichero = new Fichero("fichero.da2","I");//Apertura del fichero de entrada.donde leemos
			lista=leeFichero(fichero);
		}
		anadePersonas(lista);
		fichero = new Fichero("fichero.da2","O");//abrimos el fichero para escritura
		escribeFichero(lista, fichero);
	}

	private static void anadePersonas(List<Persona> lista) {
		Persona reg;
		String nombre;
		String apellido;
		int edad;
		nombre=Leer.pedirCadena("Nombre de la persona (* para finalizar) ");//leemos de teclado el nombre o el final
		while (!nombre.equals("*")) {
			apellido=Leer.pedirCadena("Apellido de la persona ");//leemos de teclado el apellido
			edad=Leer.pedirEntero("Edad de la persona ", "[0-9]{1,3}");//leemos de teclado la edad
			reg = new Persona(nombre, apellido, edad);//se crea un objeto
			lista.add(reg);//se añade a la lista
			nombre=Leer.pedirCadena("Nombre de la persona (* para finalizar) ");//leemos de teclado el nombre o el final
		}
	}

	private static void escribeFichero(List<Persona> lista, Fichero fichero) {
		//escribimos la lista en el fichero
		fichero.escribir(lista);
		fichero.cerrar("O");//Cerramos el fichero de escritura	
	}

	private static List<Persona> leeFichero(Fichero fichero) {
		List<Persona> lista = fichero.leer();
		for (Persona reg : lista) {
			Leer.mostrarEnPantalla("Nombre  : " + reg.getNombre());//imprimimos nombre
			Leer.mostrarEnPantalla("Apellido: " + reg.getApellido());//imprimimos apellido
			Leer.mostrarEnPantalla("Edad : " + reg.getEdad()+"\n");//imprimimos edad
		}
		fichero.cerrar("I");//cerrar fichero de lectura 
		return lista;
	}
}
