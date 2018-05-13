import java.util.LinkedList;

public class Tren {
	private int numTren;
	private LinkedList<Integer[]> vagonesDelTren;
	private String estacionSalida;
	private String estacionLlegada;
	//private static int contaVagones = 0;// esto hay que quitarlo porque cada tren numera sus vagones a partir de 1
	private static int contaTrenes = 0;

	public Tren(String estacionSalida, String estacionLLegada) {		
		this.estacionSalida = estacionSalida;
		this.estacionLlegada = estacionLLegada;
		numTren = contaTrenes;
		contaTrenes++;
	}

	// Constructor copia
	public Tren(Tren otroTren) {
		this.numTren = otroTren.numTren;
		this.estacionSalida = otroTren.estacionSalida;
		this.estacionLlegada = otroTren.estacionLlegada;
		vagonesDelTren = new LinkedList<Integer[]>();
		
	}

	public void agregarVagon(Integer [] unVagon){
		vagonesDelTren.add(unVagon);
	}
	//este metodo hay que revisarlo
	public boolean asignarAsiento(Billete billete) {
		// numAsiento es el indice del array de vagon
		
		Integer[] vagon = new Integer[11];
		for (int i = 1; i < vagon.length; i++) {
			vagon[i] = 0;
		}
		vagonesDelTren.add(vagon);
		vagon[0] = vagonesDelTren.size();
		
		boolean lleno = false;
		boolean exito = false;
		int contaOcupados = 0;
		//Integer[] coche = vagonesDelTren.get(vagon - 1);

		
		return exito;
	}// asignarAsiento

	public boolean eliminarAsiento(int numAsiento, int vagon, Fecha fecha) {
		Integer[] coche = vagonesDelTren.get(vagon - 1);
		boolean exito = false;
		if (coche[numAsiento] != null) {
			if (coche[numAsiento] != 0) {
				coche[numAsiento] = 0;
				exito = true;
			} else {
				exito = false;
			}
		}
		return exito;
	}// eliminarAsiento

	//Esto lo cambiamos
	/*public Integer getVagon(LinkedList<Integer[]> vagones) {
		return vagones.size();
	}*/
	public Integer getNumeroVagones() {
		return vagonesDelTren.size();
	}

	public LinkedList<Integer[]> getVagonesDelTren() {
		return vagonesDelTren;
	}

	public String getEstacionSalida() {
		return estacionSalida;
	}

	public String getEstacionLLegada() {
		return estacionLlegada;
	}

	public static int getContaTrenes() {
		return contaTrenes;
	}

	//public static int getContaVagones() {
	/*public int getContaVagones() {// hace lo mismo que getNumeroVagones()
		//return contaVagones;
		return vagonesDelTren.size();
	}*/

	public int getNumTren() {
		return numTren;
	}

	@Override
	public String toString() {
		return estacionSalida + "-" + estacionLlegada + " (" + (numTren+1) + ")";
	}

	public void visualizarTren() {
		System.out.println("Tren #" + getNumTren() + " (" + estacionSalida + "-" + estacionLlegada + ")");
		for (Integer[] vagon : vagonesDelTren) {
			System.out.print("Vagon ");
			for (int i = 0; i < vagon.length; i++) {
				System.out.print(vagon[i] + " ");
			}
			System.out.println("\n");
		}
	}// visualizarTren

}// Tren