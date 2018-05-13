import utilidades.Leer;
public class Empleado {
	private String nombre;
	private float sueldo;
	
	public void setNombre(String nombre){	
		this.nombre=nombre;
		return;
	}
	
	public void setSueldo(float sueldo){		
		this.sueldo=sueldo;
		return;
	}
	
	public void setTodo(String nombre,float sueldo){
		this.nombre=nombre;
		this.sueldo=sueldo;
		return;
	}
	public void imprimeNombre(){
		System.out.print("\n\t\tNOMBRE " + nombre);
		return;
	}
	
	public void imprimeSueldo(){
		System.out.print("\n\t\tSUELDO " + sueldo);
		return;
	}
	public void imprimeTodo(){		
		imprimeNombre();
		imprimeSueldo();
		return;
	}
}
