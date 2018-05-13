public class Lista {
	private Nodo primerNodo;
	private Nodo ultimoNodo;//esta referencia no es obligatoria
	private String nombre; // string a imprimir en el metodo imprimir

	// constructor crea una lista vacia de nombre "*lista*"
	public Lista(){ 
		this( "*lista*" ); 
	} // constructor

	// constructor: crea lista vacia con un nombre
	public Lista( String nombreLista ){
		nombre = nombreLista;
		primerNodo = ultimoNodo = null;
	} // constructor

	// inserta un Object al principio
	public void insertarAlFrente( Object nodoAInsertar ){
		if ( estaVacia() ) // primerNodo y ultimoNodo apuntan al mismo objeto
			primerNodo = ultimoNodo = new Nodo( nodoAInsertar );
		else // primerNodo apunta al nuevo nodo
			primerNodo = new Nodo( nodoAInsertar, primerNodo );
	} // insertarAlFrente

	// inserta Object al final
	public void insertarAlFinal( Object nodoAInsertar ){
		if ( estaVacia() ) // primerNodo y ultimoNodo apuntan al mismo objeto
			primerNodo = ultimoNodo = new Nodo( nodoAInsertar );
		else // el siguienteNodo de ultimoNodo apunta al nuevo nodo
			ultimoNodo = ultimoNodo.siguienteNodo = new Nodo( nodoAInsertar );
	} // insertarAlFinal

	// borrar primer Nodo
	public Object borrarPrimero() throws ListaVaciaException{
		if ( estaVacia() ) // si la lista esta vacia lanza una excepcion
			throw new ListaVaciaException( nombre );

		Object nodoBorrado = primerNodo.dato; // obtiene el dato que se va a borrar

		// actualiza el "puntero al siguiente" de primerNodo y ultimoNodo 
		if ( primerNodo == ultimoNodo )
			primerNodo = ultimoNodo = null;
		else
			primerNodo = primerNodo.siguienteNodo;

		return nodoBorrado; // devuelve el dato del nodo a borrar
	} // borrarPrimero

	// borra el ultimo nodo de la lista
	public Object borrarUltimo() throws ListaVaciaException{
		if ( estaVacia() ) // lanza excepción si la Lista está vacía
			throw new ListaVaciaException( nombre );

		Object nodoBorrado = ultimoNodo.dato; // obtiene el dato que se va a borrar

		// actualiza las referencias primerNodo y ultimoNodo
		if ( primerNodo == ultimoNodo )
			primerNodo = ultimoNodo = null;
		else // localiza el que será el nuevo ultimo nodo
		{ 
			Nodo actual = primerNodo;

			// mientras el nodo actual no apunte al ultimo nodo
			while ( actual.siguienteNodo != ultimoNodo )
				actual = actual.siguienteNodo;

			ultimoNodo = actual; // actual es el nuevo ultimo nodo
			actual.siguienteNodo = null;
		} // 

		return nodoBorrado; // devuelve los datos del nodo borrado
	} // borrarUltimo

	// indica si la lista esta vacia
	public boolean estaVacia()
	{ 
		return primerNodo == null; // devuelve true si la lista esta vacia
	} // estaVacia

	// imprime el contenido de la lista
	public void imprimir(){
		if ( estaVacia() ) 
		{
			System.out.printf( "La lista %s esta vacia\n", nombre );
			return;
		} // 

		System.out.printf( "El contenido de la lista %s es: ", nombre );
		Nodo actual = primerNodo;

		// mientras haya datos, muestra el nodo actual
		while ( actual != null ) 
		{
			System.out.printf( "%s ", actual.dato );
			actual = actual.siguienteNodo;
		} // while

		System.out.println( "\n" );
	} // imprimir
}// class
