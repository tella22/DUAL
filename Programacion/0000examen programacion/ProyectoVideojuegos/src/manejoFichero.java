import java.io.*;
import java.util.TreeSet;

public class manejoFichero {
	public static void escribe(TreeSet<Videojuego> juegos) {
		try {
			ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("objetos.dat"));
			fichero.writeObject(juegos);
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static TreeSet<Videojuego> leer(){
		try {
			ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("objetos.dat"));
			TreeSet<Videojuego> juegos = (TreeSet<Videojuego>) fichero.readObject();
			fichero.close();
			return juegos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
