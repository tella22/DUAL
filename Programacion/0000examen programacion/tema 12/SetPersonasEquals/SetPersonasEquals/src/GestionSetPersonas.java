import java.util.Set;
import java.util.TreeSet;

public class GestionSetPersonas {

	public static void main(String[] args) {
		Set<Persona> setPersonas  = new TreeSet<Persona>();
		setPersonas.add(new Persona("per1", 11));
		setPersonas.add(new Persona("per1", 111));
		setPersonas.add(new Persona("per2", 22));
		setPersonas.add(new Persona("per3", 33));
		for(Persona p : setPersonas){
			System.out.println(p);
		}
	}//main

}
