import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheroTexto {
	private DataInputStream entrada;
	private ObjectOutputStream salida;

	public FicheroTexto(String nombre, String io){
		//fin=false;
		if (io.equals("I")){//abrir el fichero para leer
			try{
				entrada=new DataInputStream(new FileInputStream(nombre));//asignar fichero a buffer
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
	
//	public Persona leer( ) { // lee un objeto de clase Persona y lo devuelve
//		Persona persona=null;
//		try {
//			persona = (Persona) entrada.();//leemos un registro
//		}catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			persona=null;
//		} catch (NullPointerException e) {
//			persona= null;
//		} catch(EOFException e){
//			//Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
//			persona=null;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return persona;
//	}

	public Persona leer() {
		int tipo = 0;
		String regTexto = null;
		/*
		 * Ya que la estructura es la misma para estudiante o trabajador
		 * (numero;String;String;String;numero) podemos aprovechar la estructura
		 * y crear al final, una vez recuperados los datos, el Estudiante o
		 * Trabajador dependiendo de lo que hayamos recuperado en el primer
		 * valor
		 */
		String estudiosCategoria = "";
		int cursoSueldo;
		String nombre = "", apellido = "";
		try {
			regTexto = entrada.readLine();// leemos un registro
			// Si tiene registros
			if (regTexto.length() != 0) {
				if (regTexto.indexOf(";") != -1) {// recuperamos el valor del
													// primer atributo
					tipo = Integer.parseInt(regTexto.substring(0, regTexto.indexOf(";")));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1);
				}
				if (regTexto.indexOf(";") != -1) {// recuperamos el valor del
													// segundo atributo
					nombre = regTexto.substring(0, regTexto.indexOf(";"));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1);
				}

				// recuperamos el valor del tercer atributo
				if (regTexto.indexOf(";") != -1) {
					apellido = regTexto.substring(0, regTexto.indexOf(";"));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1);
				}
				// Valor del cuarto atributo
				if (regTexto.indexOf(";") != -1) {
					estudiosCategoria = regTexto.substring(0, regTexto.indexOf(";"));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1);
				}
				try {
					cursoSueldo = Integer.parseInt(regTexto);
				} catch (NumberFormatException e) {
					Leer.mostrarEnPantalla("Datos erróneos se asigna 0.");
					cursoSueldo = 0;
				}

				if (tipo == 1) {
					Estudiante estudiante = new Estudiante(nombre, apellido, cursoSueldo,estudiosCategoria);
					return estudiante;
				}
				if (tipo == 2) {
					Trabajador trabajador = new Trabajador(nombre, apellido, estudiosCategoria, (float) cursoSueldo);
					return trabajador;
				}

			}
			// Si algo sale mal devuelve null
			return null;
		} catch (IOException e) {
			Leer.mostrarEnPantalla("Error al leer en el archivo " + e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}
	
	public Boolean escribir(List<Persona> persona ){
		
		try {
			if(persona!=null){//si el objeto existe lo escribimos
				salida.writeObject(persona);
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
