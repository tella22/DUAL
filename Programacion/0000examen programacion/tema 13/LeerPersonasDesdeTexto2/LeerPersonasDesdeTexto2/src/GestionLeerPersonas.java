import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestionLeerPersonas implements Separable{

	public static void main(String[] args) {
		List<Persona> lista = new ArrayList<>();//Lista para guardar las personas
		Fichero ficheroTexto = new Fichero("fichero.txt","I");//Apertura del fichero de entrada.donde leemos
		leeFichero(lista, ficheroTexto);
		anadePersonas(lista);
		ficheroTexto = new Fichero("fichero.txt","O");//abrimos el fichero para escritura
		escribeFichero(lista, ficheroTexto);
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

	private static void escribeFichero(List<Persona> lista, Fichero ficheroTexto) {
		for(Persona e:lista){//recorremos la lista y vamos escribiendo el contenido en el fichero
			ficheroTexto.escribir(e);
		}
		ficheroTexto.cerrar("O");//Cerramos el fichero de escritura	
	}

	private static void leeFichero(List<Persona> lista, Fichero ficheroTexto) {
		Persona reg;
		reg = ficheroTexto.leer();
		while (reg != null) {
			lista.add(reg);//lo añadimos a la lista
			Leer.mostrarEnPantalla("Nombre  : " + reg.getNombre());//imprimimos nombre
			Leer.mostrarEnPantalla("Apellido: " + reg.getApellido());//imprimimos apellido
			Leer.mostrarEnPantalla("Edad : " + reg.getEdad()+"\n");//imprimimos edad
			reg = ficheroTexto.leer();//leemos siguiente
		}
		ficheroTexto.cerrar("I");//cerrar fichero de lectura 
	}
}
