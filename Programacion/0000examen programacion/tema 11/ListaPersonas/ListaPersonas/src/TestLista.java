public class TestLista {

	public static void main(String[] args) {
		Lista lista = new Lista("Lista de personas"); // crea el contenedor de Lista

		// inserta objetos de la clase Peesona en Lista de personas
		lista.insertarAlFrente( new Persona("La primera", 20, 170) );
		lista.imprimir();
		lista.insertarAlFrente( new Persona("La segunda", 21, 171) );
		lista.imprimir();
		lista.insertarAlFinal( new Persona("La tercera", 22, 172) );
		lista.imprimir();
		lista.insertarAlFinal( new Persona("La cuarta", 23, 173) );
		lista.imprimir();

		// elimina objetos de Lista de personas; imprime después de cada eliminación
		try
		{
			Object objetoEliminado = lista.borrarPrimero();
			System.out.printf( "%s eliminado\n", objetoEliminado );
			lista.imprimir();

			objetoEliminado = lista.borrarPrimero();
			System.out.printf( "%s eliminado\n", objetoEliminado );
			lista.imprimir();

			objetoEliminado = lista.borrarUltimo();
			System.out.printf( "%s eliminado\n", objetoEliminado );
			lista.imprimir();

			objetoEliminado = lista.borrarUltimo();
			System.out.printf( "%s eliminado\n", objetoEliminado );
			lista.imprimir();
		} // fin de try
		catch ( ListaVaciaException excepcionListaVacia )
		{
			excepcionListaVacia.printStackTrace();
		} // fin de catch

	}

}
