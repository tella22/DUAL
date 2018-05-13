package ejemploobjectoutputstream;

import Clases.Alumno;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import utilidades.Leer;

public class EjemploObjectOutputStream {

    public static void main(String[] args) {
        ObjectOutputStream fich = null;
        try {
            ArrayList<Alumno> clase = new ArrayList<>();
            
            fich = new ObjectOutputStream(new FileOutputStream("ficheroClase.dat"));
            
            String nombre = Leer.pedirCadena("Introduce el nombre:('fin' para terminar) ");
            while (!nombre.equalsIgnoreCase("fin")) {
                int nota = Leer.pedirEntero("Introduce la nota: ");
                clase.add(new Alumno(nombre, nota));
                nombre = Leer.pedirCadena("Introduce el nombre: ");
            }

            Leer.mostrarEnPantalla("Guardamos la informacion de estos alumnos en el fichero \"clase.dat\"");
            for (Alumno a : clase) {
                fich.writeObject(a);
            }

            fich.close();
        } catch (IOException ex) {
        	 Leer.mostrarEnPantalla("Error E/S: " + ex.getMessage());
        } finally {
            try {
                if (fich != null) {
                    fich.close();
                }
            } catch (IOException ex) {
            	 Leer.mostrarEnPantalla("Error al cerrar fichero: " + ex.getMessage());
            }
        }

    }

}
