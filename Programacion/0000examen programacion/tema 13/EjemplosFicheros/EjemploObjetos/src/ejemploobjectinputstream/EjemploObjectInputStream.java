package ejemploobjectinputstream;

import Clases.Alumno;
import utilidades.Leer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EjemploObjectInputStream {

    public static void main(String[] args) {
        ObjectInputStream fichLeer = null;
        try {
            boolean hayaDatos = true;
            Alumno alum;
            fichLeer = new ObjectInputStream(new FileInputStream("ficheroClase.dat"));
            Leer.mostrarEnPantalla("\nLos datos de los alumnos recuperados del fichero son: ");
            while (hayaDatos) {
                try {
                    alum = (Alumno) fichLeer.readObject();
                    Leer.mostrarEnPantalla("" + alum);
                } catch (EOFException e) {
                    hayaDatos = false; //Salimos del bucle porque ya hemos recorrido el fichero entero
                }
            }
            System.out.println("Fichero recorrido completamente");
        } catch (ClassNotFoundException ex) {
        	 Leer.mostrarEnPantalla(ex.getMessage());
        } catch (IOException ex) {
        	 Leer.mostrarEnPantalla(ex.getMessage());
        } finally {
            try {
                fichLeer.close();
            } catch (IOException ex) {
            	 Leer.mostrarEnPantalla(ex.getMessage());
            }
        }

    }

}
