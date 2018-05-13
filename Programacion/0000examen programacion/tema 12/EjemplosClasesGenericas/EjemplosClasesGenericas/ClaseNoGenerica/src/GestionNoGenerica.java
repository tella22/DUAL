
public class GestionNoGenerica {

	public static void main(String[] args) {
		  
	    ClaseNoGenerica objetoInteger;  
	 
	    // Crea un objeto de clase Object y asigna su 
	    // direccion a objetoInteger. 
	    objetoInteger = new ClaseNoGenerica(88); 
	 
	    // Visualiza el tipo de dato de objetoInteger. 
	    objetoInteger.verTipo(); 
	 
	    // Obtiene el valor de objetoInteger. Hay que hacer casting
	    int num = (Integer)objetoInteger.getObjeto(); 
	    System.out.println("valor: " + num); 
	 
	    System.out.println(); 
	 
	    // Crea un objeto de clase Object para Strings. 
	    ClaseNoGenerica objetoString = new ClaseNoGenerica("Prueba de clase NO generica"); 
	 
	    // Muestra el tipo de dato de strObjeto. 
	    objetoString.verTipo(); 
	 
	    // Obtiene el valor de strObjeto. Hay que hacer casting
	    String str = (String)objetoString.getObjeto(); 
	    System.out.println("valor: " + str);
	    
	 // No da error de sintaxis pero conceptualmmente está mal 
	    objetoInteger = objetoString; 
	    num = (Integer) objetoInteger.getObjeto(); // Da un error de ejecucion 

	}//main

}
