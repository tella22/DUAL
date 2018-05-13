
public class GestionGen2Param {

	public static void main(String[] args) {
		Geberica2Param<Integer, String> objeto2Parametros = 
				new Geberica2Param<Integer, String>(88, "Generica con dos parametros"); 

		// Muestra los tipos 
		objeto2Parametros.verTipo(); 

		// obtiene los objetos y muestra sus valores 
		int num = objeto2Parametros.getObjeto1(); 
		System.out.println("valor: " + num); 

		String cadena = objeto2Parametros.getObjeto2(); 
		System.out.println("valor: " + cadena);

	}

}
