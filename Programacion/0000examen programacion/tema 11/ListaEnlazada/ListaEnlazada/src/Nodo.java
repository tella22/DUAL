
class Nodo {
	Object dato; // dato de este nodo
	Nodo siguienteNodo; // direccion del siguiente nodo en la lista

	// el constructor crea un objeto Nodo que hace referencia al objeto
	Nodo( Object object ){ 
		this( object, null ); 
	} // constructor 

	// el constructor crea un objeto Nodo que hace referencia a
	// un objeto Object y al siguiente objeto Nodo
	Nodo( Object object, Nodo nodo ){
		dato = object;    
		siguienteNodo = nodo;  
	} // constructor
	
	// devuelve la referencia del dato en el nodo
	Object getObject(){ 
		return dato; // devuelve el objeto Object en este nodo
	} //  getObject

	// devuelve la referencia al siguiente nodo en la lista
	Nodo getSiguienteNodo() {
		return siguienteNodo;
	} //  getSiguienteNodo
	
} // class
