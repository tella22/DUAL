// se obliga a que el argumento de tipo T sea
//de clase Number o de una clase derivada de Number

public class PromedioBien<T extends Number> {
	T[] numeros; // numeros es un array de tipo Number o subclases de Number 

	public PromedioBien(T[] numeros) {
		this.numeros = numeros;
	}
	
	// devuelve Double en todos los casos
	public Double promedio(){
		Double sum = 0.0; 

		 for(int i=0; i < numeros.length; i++)  
		   sum = sum + numeros[i].doubleValue(); 

		 return sum / numeros.length; 
	}
}// PromedioBien

 