
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploFileOutputStream {

    public static void main(String[] args) {
        FileOutputStream fichero = null;
        boolean existe = true;
        try {
            String cadena;
            int codigoDelCaracter;
            char caracter;
            fichero = new FileOutputStream("ejemploFileOutputStream.dat");
            cadena = Leer.pedirCadena("\nIntroduce una frase: ");
            for (int pos = 0; pos < cadena.length(); pos++) {
                fichero.write(cadena.charAt(pos));
            }
            fichero.write('\n');//Para separar las frases
            int a= 65;
            fichero.write(a);
            fichero.close();
            Leer.mostrarEnPantalla("\nEl contenido del fichero es: ");
            
            FileInputStream fichLec = new FileInputStream("ejemploFileOutputStream.dat");
            codigoDelCaracter = fichLec.read();
            while (codigoDelCaracter != -1) {
                caracter = (char) codigoDelCaracter;
                System.out.print(caracter);
                codigoDelCaracter = fichLec.read();
            }
            
            fichLec.close();
        } catch (FileNotFoundException ex) {
        	Leer.mostrarEnPantalla("El fichero no existe: "+ex.getMessage());
            existe = false;
        } catch (IOException ex) {
        	Leer.mostrarEnPantalla("Error de entrada/salida: "+ex.getMessage());
        } finally {
            try {
                if(fichero!=null)
                    fichero.close();
            } catch (IOException ex) {
            	Leer.mostrarEnPantalla("Error al cerrar fichero: " + ex.getMessage());
            }
        }

    }

}
