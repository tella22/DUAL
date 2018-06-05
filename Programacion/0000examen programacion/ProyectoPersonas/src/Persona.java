import java.io.Serializable;

public class Persona implements Separable, Serializable{

	private String nombre;
	private String apellido;
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		apellido = apellido;
	}

	@Override
	public String toString() {// formato para la escritura en el archivo
		return nombre+getSeparador()+apellido+getSeparador()+"\n";
	}
	
}
