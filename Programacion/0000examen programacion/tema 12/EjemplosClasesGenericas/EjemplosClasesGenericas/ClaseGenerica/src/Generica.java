
public class Generica<T> { 
	  T objeto; // declara un objeto de tipo T 
	   
	  // Pasa al constructor una referencia a  
	  // un objeto de tipo T. 
	  Generica(T o) { 
	    objeto = o; 
	  } 
	 
	  // Devuelve el objeto 
	  T getObjeto() { 
	    return objeto; 
	  } 
	 
	  // muestra el tipo de clase del objeto 
	  void verTipo() { 
	    System.out.println("T es de tipo " + 
	                       objeto.getClass().getName()); 
	  } 
	} 
	 
