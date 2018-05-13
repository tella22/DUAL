import java.util.Arrays;

public class ColaDinamica implements Dinamizable{

	private Integer cola[];
	//podríamos prescindir del frente porque al implementar la cola con un vector
	//el frente siempre se va a referir al elemento de indice cero
	private Integer frente;
	private Integer ultimo;

	ColaDinamica(Integer tamanioInicial) {
		cola = new Integer[tamanioInicial];
		frente = ultimo = 0;
	}
	public void add(Integer elemento){ // añadir un elemento a la cola
		if(ultimo==cola.length){ // si esta llena la ampliamos
			cola = Arrays.copyOf(cola, (cola.length+1) );
			cola[ultimo] = elemento;
			ultimo++;
		}else{
			cola[ultimo] = elemento;
			ultimo++;
		}
	}

	public Integer delete(){ // desapilar un elemento
		int i;
		Integer elemento = null;
		if(ultimo!=0){
			elemento = cola [frente];
			for(i = 0; i < ultimo-1; i++){
				cola[i] = cola[i+1];
			}
			ultimo--;
		}
		return elemento;		
	}//delete
}
