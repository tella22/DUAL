
public class ClaseNoGenerica { 
	  Object objeto; // declara un objeto de tipo Object 
	   
	  // Pasa al constructor una referencia a  
	  // un objeto de tipo Object. 
	  ClaseNoGenerica(Object o) { 
	    objeto = o; 
	  } 
	 
	  // Devuelve objeto. 
	  Object getObjeto() { 
	    return objeto; 
	  } 
	 
	  // Muestra el el tipo de clase del objeto. 
	  void verTipo() { 
	    System.out.println("T es de tipo " + 
	                       objeto.getClass().getName()); 
	  } 
	} 
	 
