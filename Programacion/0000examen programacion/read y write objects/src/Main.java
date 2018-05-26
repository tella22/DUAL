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

public class Main{

    public static void main(String[] args) {
        
        TreeSet<String> set = new TreeSet<String>();
        File objetos = new File("objetos.dat"); //leer fichero con objetos, en caso de querer leer otra cosa modificarlo en FileReadWrite.java
		if (objetos.exists()) {
			set = manejoFichero.leer();
		} else {
			crearJuegos(set);/* creamos el ArrayList con juegos */
		}

        manejoFichero.escribe(set); // escribimos fichero pasandole como parametro un treeset, en caso de querer pasar otra cosa modificarlo en FileReadWrite.java
        
    }

}