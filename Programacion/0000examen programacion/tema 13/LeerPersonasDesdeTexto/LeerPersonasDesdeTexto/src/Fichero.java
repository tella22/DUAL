import java.io.*;

public class Fichero{
	
	private BufferedReader entrada;

	public Fichero(String nombre){

		try{
			entrada=new BufferedReader(new FileReader(nombre));
		}catch(IOException e){
			System.out.println("Error al abrir el archivo "+e.getMessage());
			System.exit(1);
		}
	}

	public Persona leer( ){
		Persona persona=null;
		String regTexto=null;
		String nombre= "", apellido="";
		int edad=0;
		try {
			regTexto = entrada.readLine();

			if(regTexto.length() != 0){
				// los valores de cada atributo estan separados por ;
				if(regTexto.indexOf(";")!=-1){// recuperamos el valor del primer atributo		
					nombre= regTexto.substring(0, regTexto.indexOf(";"));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1 );
				}
				if(regTexto.indexOf(";")!=-1){// recuperamos el valor del segundo atributo
					apellido= regTexto.substring(0, regTexto.indexOf(";"));
					regTexto = regTexto.substring(regTexto.indexOf(";") + 1 );
				}
				// recuperamos el valor del tercer atributo
				edad = Integer.parseInt(regTexto);
			}
			persona=new Persona(nombre,apellido,edad);
			return persona;
		}catch(IOException e){
			System.out.println("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {
	        return null;
	    }
		return persona;
	}

	public void cerrar(){ 
		try{
			entrada.close();
		}catch(IOException e){
			System.out.println("Error al cerrar el archivo "+e.getMessage());
			System.exit(1);
		}
	}
}
