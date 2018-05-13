import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploBufferedReader {


    public static void main(String[] args) {
        FileReader fichLeer = null;
        try {
        	String cadAEscribir, cadALeer = "";
        	FileWriter fichEscribir = new FileWriter("bufferedReader1.txt");          
            cadAEscribir = Leer.pedirCadena("\nIntroduce una frase: ");
            fichEscribir.write(cadAEscribir);
            fichEscribir.write("\n");
            cadAEscribir = Leer.pedirCadena("\nIntroduce una frase: ");
            fichEscribir.write(cadAEscribir);
            fichEscribir.write("\n");
            fichEscribir.close();
            
            fichLeer = new FileReader("bufferedReader1.txt");
            BufferedReader buffer = new BufferedReader(fichLeer);
            cadALeer = buffer.readLine();
            while (cadALeer != null) {
                System.out.println(cadALeer);
                cadALeer = buffer.readLine();
             } 
            fichLeer.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
			try {
				if (fichLeer != null) {
					fichLeer.close();
				}
        	} catch (IOException ex) {
        		System.out.println(ex.getMessage());
        	}
        }

    }

}
