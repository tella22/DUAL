
public class Trabajador extends Persona{

	private String categoria;
	private Float sueldo;
	
	public Trabajador(String nombre, String apellido, String categoria, Float sueldo) {
		super(nombre, apellido);
		this.categoria = categoria;
		this.sueldo = sueldo;
	}
	
}
