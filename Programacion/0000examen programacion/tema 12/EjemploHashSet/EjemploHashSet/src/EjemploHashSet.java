import java.util.HashSet;

public class EjemploHashSet {
	public static void main(String[] args){
		HashSet<Integer> conjunto=new HashSet<Integer>();		
		int n;
		do {
			n=Leer.pedirEntero("Introduce el elemento "+(conjunto.size()+1)+":");
			if (!conjunto.add(n))
				System.out.println("Número ya en la lista. Debes introducir otro.");
		} while (conjunto.size()<5);
		// Calcular la suma
		Integer suma=new Integer(0);
		for (Integer i: conjunto) {
			suma=suma+i;
		}
		System.out.println("La suma es:"+suma);
	}
}
