
public class Persona implements Comparable<Persona> {
	private String nombre;
	private Integer edad;
	
	public Persona(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public int compareTo(Persona otraPersona) {
		return nombre.compareTo(otraPersona.nombre);
	}
}
