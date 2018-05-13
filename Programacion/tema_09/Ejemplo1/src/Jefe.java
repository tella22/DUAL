import utilidades.Leer;
public class Jefe extends Empleado{
	private String departJefe;
	private String titulUniv;
	
	public void setDepartJefe(String departJefe){		
		this.departJefe=departJefe;
		return;
	}
	
	public void setTitulUniv(String titulUniv){
		this.titulUniv=titulUniv;
		return;
	}
	
	public void setTodo(String nombre,float sueldo, String departJefe, String titulUniv){
		super.setTodo(nombre, sueldo);
		setDepartJefe(departJefe);
		setTitulUniv(titulUniv);		
	}
	
	public void imprimeDepartJefe(){
		System.out.print("\n\t\tES JEFE DEL DEPARTAMENTO:  " + departJefe);
	}
	public void imprimeTitulUniv(){
		System.out.print("\n\t\tTIENE COMO TITULO UNIVERSITARIO: " + titulUniv);
	}
	
	public void imprimeTodo(){
		super.imprimeTodo();
		imprimeDepartJefe();
		imprimeTitulUniv();
	}
}
