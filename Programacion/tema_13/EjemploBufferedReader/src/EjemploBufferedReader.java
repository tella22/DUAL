import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploBufferedReader {


    public static void main(String[] args) {
        FileReader fichLeer = null;
        try {
            FileWriter fichEscribir = new FileWriter("bufferedReader.txt");
            String cadAEscribir, cadALeer = "";
            cadAEscribir = Leer.pedirCadena("\nIntroduce una frase: ");
            fichEscribir.write(cadAEscribir);
            fichEscribir.close();
            
            fichLeer = new FileReader("bufferedReader.txt");
            BufferedReader buffer = new BufferedReader(fichLeer);
            cadALeer = buffer.readLine();
            Leer.mostrarEnPantalla("\nLa frase leida del fichero es: \"" + cadALeer + "\"");
            fichLeer.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
        	try {
        		fichLeer.close();
        	} catch (IOException ex) {
        		System.out.println(ex.getMessage());
        	}
        }

    }

}
