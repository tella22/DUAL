
public class GestionPromedioBien {

	public static void main(String[] args) {

		Integer numerosEnteros[] = { 1, 2, 3, 4, 5 }; 
		PromedioBien<Integer> objetoDeEnteros = new PromedioBien<Integer>(numerosEnteros);   
		Double promedioEnteros = objetoDeEnteros.promedio(); 
		System.out.println("Promedio del objeto que tiene un vector de enteros: " + promedioEnteros); 

		Double numerosDouble[] = { 1.1, 2.2, 3.3, 4.4, 5.5 }; 
		PromedioBien<Double> objetoDeDoubles = new PromedioBien<>(numerosDouble);   
		double promedioDoubles = objetoDeDoubles.promedio(); 
		System.out.println("Promedio del objeto que tiene un vector de doubles: " + promedioDoubles); 

		//No compila porque String no es una subclase de Number 
		/*
		String cadenas[] = { "1", "2", "3", "4", "5" }; 
		PromedioBien<String> objetoDeCadenas = new PromedioBien<String>(cadenas); //aqui da error  

		double promedioCadenas = objetoDeCadenas.promedio(); 
		System.out.println("Promedio del objeto que tiene un vector de cadenas " + promedioCadenas);*/ 

	}

}
