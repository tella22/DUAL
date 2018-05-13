
public class GestionGenerica {

	public static void main(String[] args) {
		// Crea una referencia Generica para Integer.  
	    Generica<Integer> objetoInteger;  
	 
	    // Crea un objeto Generica<Integer> y asigna su 
	    // direccion a objetoInteger. 
	    objetoInteger = new Generica<Integer>(88); 
	 
	    // Visualiza el tipo de clase de objetoInteger
	    objetoInteger.verTipo(); 
	 
	    // Obtiene el valor de objetoInteger. No hay que hacer casting
	    int num = objetoInteger.getObjeto(); 
	    System.out.println("valor: " + num); 
	 
	    System.out.println(); 
	 
	    // Crea un objeto de clase Generica para Strings. 
	    Generica<String> strObjeto = new Generica<String>("Prueba de clase Generica"); 
	 
	    // Muestra el tipo de clase de strObjeto. 
	    strObjeto.verTipo(); 
	 
	    // Obtiene el valor de strObjeto. No hay que hacer casting
	    String str = strObjeto.getObjeto(); 
	    System.out.println("valor: " + str);

	}//main

}
