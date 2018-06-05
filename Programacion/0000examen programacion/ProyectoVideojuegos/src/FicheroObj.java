import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheroObj {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public FicheroObj(String nombre, String io){
		//fin=false;
		if (io.equals("I")){//abrir el fichero para leer
			try{
				entrada=new ObjectInputStream(new FileInputStream(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de entrada "+e.getMessage());
				System.exit(1);
			}
		}
		if (io.equals("O")){//abrir el fichero para escribir
			try{
				salida=new ObjectOutputStream(new FileOutputStream(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de salida "+e.getMessage());
				System.exit(1);
			}
		}
	}
	
	public Videojuego leer( ) { // lee un objeto de clase Persona y lo devuelve
		Videojuego juego=null;
		try {
			juego = (Videojuego) entrada.readObject();//leemos un registro
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			juego=null;
		} catch (NullPointerException e) {
			juego= null;
		} catch(EOFException e){
			//Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			juego=null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return juego;
	}

	public Boolean escribir(ArrayList<Videojuego> videojuegos ){
		
		try {
			if(videojuegos!=null){//si el objeto existe lo escribimos
				salida.writeObject(videojuegos);
			}
		}catch(IOException e){//controlar el error de escritura
			Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {//controlar el error de asignación de fichero
	        return false;
	    }
		return true;
	}
	
	public void cerrar(String io){ 
		try{
			if(io.equals("I")){//cerrar el buffer de entrada
				entrada.close();
			}
			if(io.equals("O")){//cerrar el buffer de salida
				salida.close();
			}
		}catch(IOException e){//controlar la excepción
			Leer.mostrarEnPantalla("Error al cerrar el archivo "+e.getMessage());
			System.exit(1);
		}
	}
}
