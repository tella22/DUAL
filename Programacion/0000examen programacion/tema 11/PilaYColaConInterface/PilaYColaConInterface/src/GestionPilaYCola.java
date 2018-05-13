
public class GestionPilaYCola {
	public static void main(String args[]) {

		Integer elemento;
		PilaDinamica pilaDinamica = new PilaDinamica(5);
		ColaDinamica colaDinamica = new ColaDinamica(8);

		// añadimos unos numeros
		for(int i=1; i<12; i++){
			pilaDinamica.add(i);
		}

		for(int i=1; i<20; i++){
			colaDinamica.add(i);
		}

		// los borramos y vamos mostrando cada elemento que borramos

		System.out.println("Pila pilaDinamica:");
		System.out.println("-------------------");

		for(int i=1; i<12; i++) {
			elemento=pilaDinamica.delete();
			if(elemento !=null){
				System.out.println(elemento);
			}

		}

		System.out.println("Cola colaDinamica:");
		System.out.println("-------------------");

		for(int i=1; i<20; i++){
			elemento=colaDinamica.delete();
			if(elemento !=null){
				System.out.println(elemento);
			}
		}

		// utilizamos una variable de tipo Dinamizable para guardar tanto la pila como la cola

		Dinamizable interfaz;
		PilaDinamica otraPila = new PilaDinamica(5);
		ColaDinamica otraCola = new ColaDinamica(8);

		interfaz = otraPila; // apunta a la pila
		// apilamos unos cuantos numeros
		for(int i=1; i<12; i++) interfaz.add(i);

		interfaz = otraCola; // apunta a la cola
		// añadimos unos cuantos numeros
		for(int i=1; i<8; i++) interfaz.add(i);
		
		interfaz = otraPila; // apunta a la pila
		System.out.println("\nValores en otraPila:");
		System.out.println("------------------------:");

		// los borramos y vamos mostrando cada elemento que borramos
		for(int i=1; i<12; i++){
			elemento=interfaz.delete();
			if(elemento !=null){
				System.out.println(elemento);
			}
		}

		interfaz = otraCola; // apunta a la cola
		System.out.println("\nValores en otraCola:");
		System.out.println("--------------------:");

		// los borramos y vamos mostrando cada elemento que borramos
		for(int i=1; i<8; i++){
			elemento=interfaz.delete();
			if(elemento !=null){
				System.out.println(elemento);
			}
		}
	}// main
}
