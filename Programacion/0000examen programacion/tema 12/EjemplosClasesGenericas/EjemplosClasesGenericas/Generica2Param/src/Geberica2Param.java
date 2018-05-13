
public class Geberica2Param <T, V> { 
	  T ob1; 
	  V ob2; 
	   
	  // el constructor recibe una referencia a  
	  // un object de tipo T y otra a un objeto de tipo V. 
	  Geberica2Param(T o1, V o2) { 
	    ob1 = o1; 
	    ob2 = o2; 
	  } 
	 
	  // Visualiza los tipos de T y V. 
	  void verTipo() { 
	    System.out.println("T es de tipo " + 
	                       ob1.getClass().getName()); 
	 
	    System.out.println("V es de tipo " + 
	                       ob2.getClass().getName()); 
	  } 
	 
	  T getObjeto1() { 
	    return ob1; 
	  } 
	 
	  V getObjeto2() { 
	    return ob2; 
	  } 
	} 
