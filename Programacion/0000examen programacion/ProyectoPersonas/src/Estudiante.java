
public class Estudiante extends Persona{
	
	private Integer curso;
	private String estudios;
	
	public Estudiante(String nombre, String apellido, Integer curso, String estudios) {
		super(nombre, apellido);
		this.curso = curso;
		this.estudios = estudios;
	}
	
}
