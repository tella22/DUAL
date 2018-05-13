
public class Principal {

	public static void main(String[] args) {
		Pila unaPila=new Pila();
		int  num;
		
		int op;
		do{
			op=menu("\n1 Apilar un elemento"
					+ "\n2 Desapilar un elemento"
					+"\n3 Mostrar numero de elementos"
					+ "\n4 Mostrar todos los elementos sin borrarlos"
					+ "\n5 Desapilar todos los elementos (mostrar y borrar)"
					+ "\n0 Salir", 5);
			switch(op){
			case 1: 
				num=Leer.pedirEntero("Introduce un numero para apilar: ");
				unaPila.apilar(new Integer(num)); // el metodo apilar recibe como parametro un Integer
				break;
			case 2:
				System.out.println("desapilando: " + unaPila.desapilar());
				break;
			case 3:
				System.out.println(unaPila.tamaño() + " elementos en la pila");
				break;
			case 4:
				System.out.println("Datos en la pila (no los desapilamos):");
				unaPila.visualizar();
				break;
			case 5:
				System.out.println("Datos en la pila (desapilamos todos):");
				unaPila.visualizarYEliminar();
				break;
			default:
				if(op!=0)
					System.out.println("Opcion incorrecta");
			}
		}while(op!=0);
	}// main
	
	private static int menu(String cadenaOpciones, int numOpciones){
		int op;
		do{
			System.out.println(cadenaOpciones);
			op=Leer.pedirEntero("\nElija opcion");
		}while (op<0 || op>numOpciones);
		return op;
	}//menu
}// class
