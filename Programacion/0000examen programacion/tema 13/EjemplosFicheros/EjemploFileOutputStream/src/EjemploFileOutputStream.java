import java.io.BufferedOutputStream;
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
			fichero = new FileOutputStream("ejemploFileOutputStream1.dat");
			cadena = "Esto es una cadena de texto que vamos a usar de ejemplo para escribirla en el fichero.";
			for (int pos = 0; pos < cadena.length(); pos++) {
				fichero.write(cadena.charAt(pos));
			}
			fichero.write('\n');//Para separar las frases
			int a= 65;
			fichero.write(a);
			fichero.close();
			
			////////////////////////////////////////////////////////////////
			fichero = new FileOutputStream("ejemploFileOutputStream2.dat");
			
			//Creamos un array de byte a partir del String anterior, mediante el 
			// método getBytes() de la clase String
			
			byte arrayDeBytes[] = cadena.getBytes();
			System.out.println("caracteres del String cadena: " + cadena.length() );
	        System.out.println("numero de elementos del array arrayDeBytes:"+ arrayDeBytes.length);
			
	        /*escribimos directamente todo el array arrayDeBytes en el flujo. 
			 Aquí no hemos montado ningún buffer sobre el flujo.*/
	        
	        fichero.write(arrayDeBytes);
			fichero.close();
			
			////////////////////////////////////////////////////////////////
			/*En este fichero escribimos los bytes del array arrayDeBytes de uno en uno 
			  en el flujo, sobre el que se ha montado un buffer con BufferedOutputStream*/
			
			fichero = new FileOutputStream("ejemploFileOutputStream3.dat");
			BufferedOutputStream flujoSalidaConBuffer= new BufferedOutputStream(fichero);
	        for (int i = 0; i < arrayDeBytes.length; i++) {
	            flujoSalidaConBuffer.write(arrayDeBytes[i]);
	        }
	        flujoSalidaConBuffer.close();
			
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







