
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploDataOutputStream {

    public static void main(String[] args) {
        FileOutputStream fichero = null; 
        DataOutputStream salida = null;
        try {
            fichero = new FileOutputStream("ejemploDataOutputStream.dat");
            salida = new DataOutputStream(fichero);
            salida.writeUTF("Ana");
            salida.writeDouble(8);
            salida.writeUTF("Juan");
            salida.writeDouble(9);
            fichero.close();
            salida.close();
            Leer.mostrarEnPantalla("FIN");
            
        } catch (FileNotFoundException ex) {
            Leer.mostrarEnPantalla("El fichero no existe: "+ex.getMessage());
        } catch (IOException ex) {
        	Leer.mostrarEnPantalla("Error de entrada/salida: "+ex.getMessage());
        } finally {
            try {
                if(fichero!=null)
                    fichero.close();
                if(salida!=null)
                    salida.close();
            } catch (IOException ex) {
            	Leer.mostrarEnPantalla("Error al cerrar fichero: " + ex.getMessage());
            }
        }//try
    }//main
    
}//class
