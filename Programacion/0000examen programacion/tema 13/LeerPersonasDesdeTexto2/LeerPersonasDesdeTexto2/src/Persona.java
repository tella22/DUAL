
public class Persona implements Separable{
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {// formato para la escritura en el archivo
		return nombre+getSeparador()+apellido+getSeparador()+edad+"\n";
	}
	
}
