//queremos calcular el promedio de un array de numeros de cualquier tipo
//esta clase tiene un error
public class PromedioMal<T> {
	T[] numeros; // numeros es un array de tipo T 

	public PromedioMal(T[] numeros) {
		this.numeros = numeros;
	}
	
	// devuelve Double en todos los casos
	public Double promedio(){
		Double sum = 0.0; 

		 for(int i=0; i < numeros.length; i++)  
		   sum = sum + numeros[i].doubleValue(); // Error!!! 

		 return sum / numeros.length; 
	}
}//PromedioMal

