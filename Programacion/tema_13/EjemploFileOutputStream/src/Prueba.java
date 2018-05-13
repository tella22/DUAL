
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Prueba {
    public static void main(String[] args) {
        try {
            FileOutputStream salida = new FileOutputStream("ficheroprueba.dat");
            salida.write('H');
            salida.close();
        } catch (FileNotFoundException ex) {
        	Leer.mostrarEnPantalla("El fichero no existe: "+ex.getMessage());
        } catch (IOException ex) {
        	Leer.mostrarEnPantalla("Error de entrada/salida: "+ex.getMessage());
        } 
    }
}
