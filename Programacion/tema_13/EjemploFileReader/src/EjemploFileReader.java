import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFileReader {

    public static void main(String[] args) {
        FileReader fichALeer = null;
        int codigoDelCaracter;
        char caracter;
        String cadena = "";
        try {
            fichALeer = new FileReader("fileWriter.txt");
            codigoDelCaracter = fichALeer.read();
            while (codigoDelCaracter != -1) {
                caracter = (char) codigoDelCaracter;
                cadena = cadena + caracter;
                codigoDelCaracter = fichALeer.read();
            }
            System.out.println("\nel contenido del fichero es: \"" + cadena + "\"");
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero al que se intenta acceder no existe: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex.getMessage());
        } finally {
            try {
                fichALeer.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero: " + ex.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

    }

}
