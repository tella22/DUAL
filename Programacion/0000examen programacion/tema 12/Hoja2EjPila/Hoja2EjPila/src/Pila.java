import java.util.*;

public class Pila {
	private ArrayList<Integer> pila;
	
	public Pila(){
		pila=new ArrayList<Integer>();

	}

	public void apilar(Integer num){
		pila.add(num);
	}

	public int desapilar(){
		int ultimo, dato;
		
		ultimo=pila.size()-1;
		dato=pila.get(ultimo);
		pila.remove(ultimo);

		return dato;
	}

	public int tamaño(){
		return pila.size();
	}

	public String visualizarEnString(){
		return pila.toString();
	}

	public void visualizar(){
		System.out.println("Mostramos la pila sin destruirla: ");
		for (int i=pila.size()-1;i>=0;i--){
			System.out.print(pila.get(i) + ", ");
		}
	}

	public void visualizarYEliminar(){
		for (int i=pila.size()-1;i>=0;i--){
			System.out.print(pila.get(i) + ", ");
			pila.remove(i);
		}
	}
}
