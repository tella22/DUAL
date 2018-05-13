import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class EjemploDataInputStream {

    public static void main(String[] args) {
        FileInputStream f = null;
        DataInputStream entrada = null;
        try {
            f = new FileInputStream("..\\EjemploDataOutputStream\\ejemploDataOutputStream.dat"); //Se puede poner / o  \\
            entrada = new DataInputStream(f);
            
            Leer.mostrarEnPantalla(entrada.readUTF());
            Leer.mostrarEnPantalla("" + entrada.readDouble());
            Leer.mostrarEnPantalla(entrada.readUTF());            
            Leer.mostrarEnPantalla("" + entrada.readDouble());
            
            f.close();
            entrada.close();
        } catch (FileNotFoundException e) {
        	 Leer.mostrarEnPantalla("El fichero no existe.");
        } catch(IOException e){
        	 Leer.mostrarEnPantalla("Error: "+e.getMessage());
        } finally {
            try {
                if(f!=null)
                    f.close();
                if(entrada!=null)
                    entrada.close();
            } catch (IOException ex) {
            	 Leer.mostrarEnPantalla("Error al cerrar fichero: " + ex.getMessage());
            }
        }
    }
    
}
