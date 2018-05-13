
import java.io.FileWriter;
import java.io.IOException;

public class EjemploFileWriter {

    public static void main(String[] args) {
        FileWriter fichEsc = null;
        try {
            fichEsc = new FileWriter("fileWriter.txt");
            String cadAEscribir;
            cadAEscribir = Leer.pedirCadena("\nIntroduce una frase: ");
            fichEsc.write(cadAEscribir);
            fichEsc.close();
        } catch (IOException ex) {
            System.out.println("Error de escritura: " + ex.getMessage());
        } finally {
            try {
                fichEsc.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero: "+ex.getMessage());
            }
        }

    }

}
