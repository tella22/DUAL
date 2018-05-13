import java.util.ArrayList;
import java.util.Iterator;
public class EjemploIterator01 {
	public static void main(String[] args){
		int i, n;
		Integer numero;
		ArrayList<Integer> arrListEnteros=new ArrayList<Integer>();
		
		n=Leer.pedirEntero("¿Cuantos elementos tendrá el array?");
		for(i=1;i<=n;i++){
			arrListEnteros.add(i);
		}
		//Ejemplo con for each
		System.out.println("Recorrido con for_each");
		for (Integer dato: arrListEnteros) {
			System.out.println(dato);
		}
		
		System.out.println("Recorrido con iterador indicando el tipo de objeto");
		//Recorrido indicando el tipo de objeto del iterador
		Iterator<Integer> itr=arrListEnteros.iterator();
		while (itr.hasNext()) { // si no es nulo
			numero=itr.next(); // recupero el objeto al que apunta y el itr apunta al siguiente
			System.out.println(numero); 
		}
		Leer.mostrarEnPantalla("Creamos un ArrayList que guarda numeros del 0 al 9.");
		ArrayList <Integer> lista2=new ArrayList<Integer>(); 
		for ( i=0;i<10;i++){ 
			lista2.add(i); // inserta en la lista los números del 0 al 9
		}
		Leer.mostrarEnPantalla("Y borramos los números pares.");
		//Recorrido sin indicar el tipo de objeto del iterador
		Iterator it=lista2.iterator(); 
		while (it.hasNext()) { 
			numero=(Integer)it.next(); 
			if (numero%2==0) it.remove(); // los números pares se eliminan de la lista 
		}
		 
		for (Integer dato: lista2) {
			System.out.println(dato);
		}
	}//main
}//Class
