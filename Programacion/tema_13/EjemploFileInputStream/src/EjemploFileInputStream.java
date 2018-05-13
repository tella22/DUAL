
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EjemploFileInputStream {

    public static void main(String args[]) {
        int c;
        FileInputStream f = null;
        try {
            f = new FileInputStream("..\\EjemploFileOutputStream\\ejemploFileOutputStream.dat"); //Se puede poner / o  \\
            
            Leer.mostrarEnPantalla("El contenido del fichero es: ");
            while ((c = f.read()) != -1) {
            	Leer.mostrarEnPantalla("" + (char) c);
            }
            /*Si no hacemos la conversion visualizara el codigo ASCII de cada character que hay guardado en el fichero*/

            f.close();
            Leer.mostrarEnPantalla("FIN");
        } catch (FileNotFoundException e) {
        	Leer.mostrarEnPantalla("El fichero no existe.");
        } catch (IOException e) {
        	Leer.mostrarEnPantalla("Error de lectura: " + e.getMessage());
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
            } catch (IOException ex) {
            	Leer.mostrarEnPantalla("Error al cerrar el fichero: "+ex.getMessage());
            }
        }
    }

}
