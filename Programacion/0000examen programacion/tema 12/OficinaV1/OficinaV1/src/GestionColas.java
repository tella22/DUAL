import java.util.*;

public class GestionColas {

	public static void main(String[] args) {
		final Integer NUM_VENTANILLAS = 5; // numero de ventanillas
		final Integer FRECUENCIA_CLIENTES = 2; // frecuencia de entrada de clientes en minutos
		final Integer FRECUENCIA_MUESTRA = 1; // frecuencia con la que se muestra la informacion de las colas
		final Integer HORAS = 5; // tiempo total de la simulacion
		
		int indice, t;
		Integer min, nuevo, suma;
		@SuppressWarnings("unchecked")
		List<Integer> ventanillas[] = new LinkedList[NUM_VENTANILLAS];
		int longitudesFilas[] = new int[NUM_VENTANILLAS];
		
		crearColas(ventanillas);
		
		// t marca el instante (minutos del sistema 5 horas = 300 minutos)
		for (t = 1; t <= HORAS * 60; t++) {
			// caso de entrar un cliente medimos colas lo generamos y le asignamos ventanilla
			if (t % FRECUENCIA_CLIENTES == 0){
				// medimos para ver la mas corta
				// generamos un cliente nuevo
				// y lo insertamos en la ventanilla con menos clientes
				min = medir(ventanillas);
				nuevo = generaCliente();

				ventanillas[min].add(nuevo);

				Leer.mostrarEnPantalla("entra cliente en ventanilla " + (min + 1));
			}
			// mostramos el sistema segun frecuencia de muestra
			if (t%FRECUENCIA_MUESTRA==0){
				Leer.mostrarEnPantalla("\n***presentamos clientes de las ventanillas en instante :" + t );
				mostrarVentanillas(ventanillas);
			}

			/////////////////////////////////////////////////////
			// servimos las cabeceras de las colas de cada ventanilla
			////////////////////////////////////////////////////
			servirVentanillas(ventanillas); // se siven en todos los minutos

			// calculo de las longitudes de cada cola en cada instante y se acumulan
			for (indice = 0; indice < ventanillas.length; indice++){
				longitudesFilas[indice] = longitudesFilas[indice] + ventanillas[indice].size();
			}
		}// fin del for de los minutos

		for (indice=0;indice<NUM_VENTANILLAS;indice++){
			Leer.mostrarEnPantalla("longitud media de la cola:" + (indice+1) + ":" + (double)longitudesFilas[indice]/(HORAS*60));
		}
		suma=0;
		for (indice=0;indice<NUM_VENTANILLAS;indice++){
			suma=suma+longitudesFilas[indice];
		}
		Leer.mostrarEnPantalla( "media de medias:" + (double)suma/(NUM_VENTANILLAS*HORAS*60));
		
	}// main

	public static void crearColas(List<Integer> ventanillas[]){
		int i;
		for(i=0; i < ventanillas.length; i++ ){
			ventanillas[i] = new LinkedList<Integer>();
		}
	}//crearColas
	
	public static int medir(List<Integer> ventanillas[]){

		/***********************************************************
	            devuelve min, que sera el num de ventanilla con menos gente
	            es decir, donde insertaremos la tarea
		 ***********************************************************/
		int min,k;
		min=0;
		for (k=1;k<ventanillas.length;k++){
			if (ventanillas[k].size()<ventanillas[min].size()){
				min=k;
			}
		}
		return min;
	}
	
	public static Integer generaCliente(){
		final Integer TIPO1 = 10; // duracion de tarea tipo 1 60 %
		final Integer TIPO2 = 20; // duracion de tarea tipo 2 25 %
		final Integer TIPO3 = 30; // duracion de tarea tipo 3 15 %
		// genera un cliente de tipo 1, 2 o 3 en funcion de un numero aleatorio
		// y asigna la duración de 10,20 o 30 minutos 
		Integer tipo, nuevo = null;
		tipo = (int) (Math.random() * 100 + 1);
		if (tipo<=60){
			nuevo=TIPO1;
		}
		if (tipo>=61 && tipo<=85){
			nuevo=TIPO2;
		}
		if (tipo>85){
			nuevo=TIPO3;
		}
		return nuevo;
	}
	
	public static void mostrarVentanillas (List<Integer> ventanillas[]){
		// mostramos la longitud de las colas cada FRECUENCIA_MUESTRA minutos

		String letra;
		int k ,i;

		for (i = 0; i < ventanillas.length; i++) {
			System.out.print("Ventanilla numero :" + (i + 1) + "--");
			
			for (k = 0; k < ventanillas[i].size(); k++) {
				// presentamos el tiempo que queda de la tarea de cada cliente
				System.out.print("/" + "*" + "(" + ventanillas[i].get(k) + ")");

			}
			Leer.mostrarEnPantalla("\n");
		}

			letra = Leer.pedirCadena("Pulsa enter para continuar ...");
	}
	
	public static void servirVentanillas(List<Integer> ventanillas[]){

		int i;

		// servimos al cliente que está el primero en cada ventanilla
		// si la cola tiene clientes miramos el valor de los minutos
		// si es 1 es que le toca salir, si no restamos 1 al tiempo que le queda
		for ( i = 0 ; i < ventanillas.length; i++ ){
			if (!(ventanillas[i].isEmpty() )/* && ventanillas[i].size() >= 1*/){
				if (ventanillas[i].get(0)==1){
					ventanillas[i].remove(0);
				}
				else
					ventanillas[i].set(0, ventanillas[i].get(0) - 1);
			}
		}
	}
}// class
