import java.io.File;

public class EjemClaseFile {
    public static void main(String[] args) {
        File fichero;
        String resp, nombre;
        resp = Leer.pedirCadena("\n¿Nombre de fichero para ver si existe?\n "
                + "Escribe 'S' para si­ y cualquier otro caracter para no\t");
        while (resp.equalsIgnoreCase("S")) {
            nombre = Leer.pedirCadena("\n\tIndica el nombre de fichero a buscar: ");
            fichero = new File(nombre);
            if (fichero.isFile()) {
                System.out.println("\t\t El fichero existe");
            } else {
                System.out.println("\t\t El fichero no existe");
            }
            resp = Leer.pedirCadena("\nNombre de fichero para ver si existe?\n "
                    + "Escribe 'S' para si­ y cualquier otro caracter para no\t");
        }
    }
}
