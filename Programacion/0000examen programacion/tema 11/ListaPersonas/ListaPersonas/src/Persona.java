public class Persona {

	private String nombre;
	private int edad;
	private int altura;	
	private static int contador;
	
	Persona(){
		nombre=""; 
	}
	Persona(String unNombre, int unaEdad, int unAltura){
		nombre=unNombre;
		edad=unaEdad;
		altura=unAltura;
	}
	public static int getContador() {
		return contador;
	}
	
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int unaEdad) {
		edad = unaEdad;
	}
	public String hablar(String frase){
		return "soy " + nombre + " " + frase;
	}
	public String toString(){
		return "soy " + nombre + " de " + edad + " años " + " y " + altura + " altura ";
	}
}
