import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

public class VentaBilletes {

	public static void main(String[] args) {
		int opcion;
		TreeMap<Fecha, ArrayList<Tren>> mapaFechas = new TreeMap<Fecha, ArrayList<Tren>>();
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		Tren[] trenesMain = new Tren[3];
		
		trenesMain[0] = new Tren("Calatayud", "Zaragoza");
		trenesMain[1] = new Tren("Zaragoza", "Madrid");
		trenesMain[2] = new Tren("Cordoba", "Madrid");
		System.out.println("Hay " + Tren.getContaTrenes() + " trenes");

		opcion = Leer.pedirEntero("1-Vender un billete\n2-Anular un billete\n3-Listar billetes\n0-Salir");
		while (opcion != 0) {
			switch (opcion) {//vender billete
			case 1:
				venderBillete(mapaFechas, billetes, trenesMain);
				break;
			case 2:
				devolverBillete(mapaFechas, billetes, trenesMain);
				break;
			case 3:
				mostrarBilletes(billetes);
				break;
			default:
				break;
			}
			opcion = Leer.pedirEntero("1-Vender un billete\n2-Anular un billete\n3-Listar billetes\n0-Salir");
			
		}
	}// main

	public static void visualizarTrenes(Tren[] trenes) {
		for (int i = 0; i < trenes.length; i++) {
			System.out.println(trenes[i]);
		}
	}// visualizarTrenes

	public static void mostrarBilletes(ArrayList<Billete> billetes) {
		int opcion;
		opcion = Leer.pedirEntero(
				"1-Ordenacion por numero de billete\n2-Ordenacion por fecha, tren, vagon y asiento\n3-Ordenacion por tren, fecha y vagon");
		switch (opcion) {
		case 1:
			Collections.sort(billetes);
			for (Billete billete : billetes) {
				System.out.println(billete);
			}
			break;
		case 2:
			Collections.sort(billetes, compararFechaTrenVagonAsiento);
			for (Billete billete : billetes) {
				System.out.println(billete);
			}
			break;
		case 3:
			Collections.sort(billetes, compararTrenFechaVagon);
			for (Billete billete : billetes) {
				System.out.println(billete);
			}
			break;
		default:
			break;
		}
	}// mostrarBilletes

	public static void venderBillete(TreeMap<Fecha, ArrayList<Tren>> mapaFechas , 
			ArrayList<Billete> billetes, Tren[] trenesMain ){
		int numTren, dia, mes, anio,  i;
		ArrayList<Tren> trenesDeUnaFecha = null;
		Billete unBillete = null;
		Fecha fechaSalida;
		Tren miTren = null;
		LinkedList<Integer[]> vagonesDeMiTren;
		Integer[] miVagon = new Integer[11];
		Boolean  encontrado = false;
		do {
			dia = Leer.pedirEntero("Dia?");
			mes = Leer.pedirEntero("Mes?");
			anio = Leer.pedirEntero("Año?");
			fechaSalida = new Fecha(dia, mes, anio);
			//si la fecha es incorrecta el dia es null
		} while (fechaSalida.getDia() == null);

		if (mapaFechas.containsKey(fechaSalida)) {// Si la fecha ya esta en el mapa
			System.out.println("Ya hay billetes para esa fecha");
			numTren = elegirTipoDeTren(trenesMain);

			//Ahora hay que controlar si para esa fecha ya existe el tren
			// si no existe se crea un tren nuevo con el constructor copia y se añade
			// al ArrayList  de trenes de esa fecha

			trenesDeUnaFecha = mapaFechas.get(fechaSalida); // recupera el ArrayList de trenes de una fecha
			//buscamos el tren
			miTren = trenesDeUnaFecha.get(numTren);
			if(miTren !=null){//el tren existe
				//buscamos el primer asiento libre en ese tren
				vagonesDeMiTren = miTren.getVagonesDelTren();//lista de vagones
				//como asigno el primer asiento libre, recupero el ultimo vagon
				// aunque debería ver si se ha anulado algun billete en los vagones anteriores
				miVagon = vagonesDeMiTren.getLast();
				unBillete = new Billete(miTren, fechaSalida);
				encontrado = false;
				// miramos todos los asientos del vagon
				for(i = 1 ; i < miVagon.length && encontrado == false; i++){
					if(miVagon[i]==0){// si esta libre tiene un cero
						unBillete.setAsiento(i);
						unBillete.setVagon(miVagon[0]);
						miVagon[i]=unBillete.getNumBillete();
						encontrado = true;
					}
				}
				if(!encontrado){// hay que añadir otro vagon porque todo esta ocupado
					miVagon = new Integer[11];
					miVagon[0] = miTren.getNumeroVagones() +1;//en el primer elemento del vagon se guarda el numero de vagon
					for( i = 2 ; i < miVagon.length ; i++){
						miVagon[i] = 0;
					}
					miVagon[1] = unBillete.getNumBillete();
					miTren.agregarVagon(miVagon);
				}
				
				billetes.add(unBillete);

			}else{//si el tren no existe hay que crearlo y añadirlo a los trenes de una fecha		
				miTren = creaTrenYGeneraBillete(trenesMain, billetes, numTren, fechaSalida);						
				trenesDeUnaFecha.set(numTren, miTren);
			}

		}else{// Si la fecha no esta en el mapa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

			System.out.println("Todavia no hay billetes para esa fecha");

			trenesDeUnaFecha = new ArrayList<Tren>(); //crea ArrayList de trenes vacio
			//Guardamos nulos en el arraylist
			for(i=0; i<3; i++){
				trenesDeUnaFecha.add(null);
			}
			numTren = elegirTipoDeTren(trenesMain);
			miTren = creaTrenYGeneraBillete(trenesMain, billetes, numTren, fechaSalida);
			trenesDeUnaFecha.set(numTren, miTren);
			mapaFechas.put(fechaSalida, trenesDeUnaFecha);
		}
	}// venderBillete
	
	public static void devolverBillete(TreeMap<Fecha, ArrayList<Tren>> mapaFechas , 
			ArrayList<Billete> billetes, Tren[] trenesMain ){
		
		Integer numBillete,  indice, numVagon, asiento, posicion;
		ArrayList<Tren> trenesDeUnaFecha = null;
		Billete unBillete = null;
		Fecha fechaSalida;
		Tren miTren = null;
		LinkedList<Integer[]> vagonesDeMiTren;
		Integer[] miVagon = new Integer[11];
		Boolean  encontrado = false;
		do {
			numBillete = Leer.pedirEntero("Numero de billete a devolver?");
		} while (numBillete < 1 || numBillete > billetes.size());
		
		//unBillete = billetes.get(numBillete-1);// no procede
		
		Iterator<Billete> itr = billetes.iterator();
		indice = 0; posicion = 0;
		while (itr.hasNext() && !encontrado) { 
			unBillete=itr.next();
			
			if (numBillete == unBillete.getNumBillete()){
				encontrado = true;
				posicion = indice;
			}
			indice++;
			itr.remove();
		}
		
		if(encontrado){
			// poner el asiento libre en el TreeMap
			fechaSalida = unBillete.getFecha();
			miTren = unBillete.getTren();
			numVagon = unBillete.getVagon();
			asiento = unBillete.getAsiento();
			trenesDeUnaFecha = mapaFechas.get(fechaSalida);
			vagonesDeMiTren = trenesDeUnaFecha.get(miTren.getNumTren() ).getVagonesDelTren();
			miVagon = vagonesDeMiTren.get(numVagon-1);
			miVagon[asiento]=0;
			//borrar el billete
			//billetes.remove(posicion);
		}
		
	}// devolverBillete
	
	public static int elegirTipoDeTren(Tren[] trenes){
		int numTren;
		do {
			visualizarTrenes(trenes);
			numTren = Leer.pedirEntero("Elige un tren mediante su identificador");
		} while (numTren < 1 || numTren > 3);
		numTren--;
		return numTren;
	}// elegirTipoDeTren

	public static Tren creaTrenYGeneraBillete(Tren [] trenesMain, ArrayList<Billete> billetes, int numTren, Fecha fechaSalida){
		int i;
		Billete unBillete;
		Tren miTren = new Tren(trenesMain[numTren]);
		Integer [] miVagon = new Integer[11];
		miVagon[0] = miTren.getNumeroVagones() +1;
		for( i = 1 ; i < miVagon.length ; i++){
			miVagon[i] = 0;
		}			
		miTren.agregarVagon(miVagon);
		unBillete = new Billete(miTren, fechaSalida);
		unBillete.setVagon(miVagon[0]);
		unBillete.setAsiento(1);
		miVagon[1] = unBillete.getNumBillete();
		billetes.add(unBillete);
		return miTren;
	}//creaTrenYGeneraBillete

	// Necesario para hacer la busqueda binaria
	public static Comparator<Billete> compararNumBillete = new Comparator<Billete>() {
		public int compare(Billete unBillete, Billete otroBillete) {
			Integer numBillete1 = unBillete.getNumBillete();
			Integer numBillete2 = otroBillete.getNumBillete();
			return numBillete1.compareTo(numBillete2);
		}
	};//compararNumBillete
	
	public static Comparator<Billete> compararFechaTrenVagonAsiento = new Comparator<Billete>() {
		public int compare(Billete unBillete, Billete otroBillete) {
			Fecha fecha1 = unBillete.getFecha();
			Fecha fecha2 = otroBillete.getFecha();
			if (fecha1.equals(fecha2)) {// si las fechas son iguales
				Integer numTren1 = unBillete.getTren().getNumTren();
				Integer numTren2 = otroBillete.getTren().getNumTren();
				if (numTren1.equals(numTren2)) {// si las fechas y el tren son iguales
					Integer numVagon1 = unBillete.getVagon();
					Integer numVagon2 = otroBillete.getVagon();
					if (numVagon1.equals(numVagon2)) {// si las fechas, el tren y el vagon son iguales
						Integer asiento1 = unBillete.getAsiento();
						Integer asiento2 = otroBillete.getAsiento();
						return asiento1.compareTo(asiento2);//ordena por asiento
					} else {
						return numVagon1.compareTo(numVagon2);// ordena por vagon
					}
				} else {
					return numTren1.compareTo(numTren2);//ordena por tren
				}
			} else {// si las fechas son distintas ordena por fecha
				return fecha1.compareTo(fecha2);
			}
		}
	};//compararFechaTrenVagonAsiento
	
	public static Comparator<Billete> compararFechaTrenVagon = new Comparator<Billete>() {
		public int compare(Billete unBillete, Billete otroBillete) {
			Fecha fecha1 = unBillete.getFecha();
			Fecha fecha2 = otroBillete.getFecha();
			if (fecha1.equals(fecha2)) {// si las fechas son iguales
				Integer numTren1 = unBillete.getTren().getNumTren();
				Integer numTren2 = otroBillete.getTren().getNumTren();
				if (numTren1.equals(numTren2)) {// si las fechas y el tren son iguales
					Integer numVagon1 = unBillete.getVagon();
					Integer numVagon2 = otroBillete.getVagon();
					return numVagon1.compareTo(numVagon2);// ordena por vagon
				} else {
					return numTren1.compareTo(numTren2);//ordena por tren
				}
			} else {// si las fechas son distintas ordena por fecha
				return fecha1.compareTo(fecha2);
			}
		}
	};//compararFechaTrenVagon
	public static Comparator<Billete> compararTrenFechaVagon = new Comparator<Billete>() {
		public int compare(Billete unBillete, Billete otroBillete) {
			Integer numTren1 = unBillete.getTren().getNumTren();
			Integer numTren2 = otroBillete.getTren().getNumTren();			
			if (numTren1.equals(numTren2)) {// si los trenes son iguales
				Fecha fecha1 = unBillete.getFecha();
				Fecha fecha2 = otroBillete.getFecha();
				if (fecha1.equals(fecha2)) {// si los trenes y las fechas son iguales
					Integer numVagon1 = unBillete.getVagon();
					Integer numVagon2 = otroBillete.getVagon();
					return numVagon1.compareTo(numVagon2);// ordena por vagon
				} else {//ordena por fecha
					return fecha1.compareTo(fecha2);
				}
			} else {// si las fechas son distintas ordena por fecha
				return numTren1.compareTo(numTren2);//ordena por tren				
			}
		}
	};//compararTrenFechaVagon
	
	public static Comparator<Billete> compararAsientosVendidos = new Comparator<Billete>() {
		public int compare(Billete unBillete, Billete otroBillete) {
			Integer tren1 = unBillete.getTren().getNumTren();
			Integer tren2 = otroBillete.getTren().getNumTren();
			if (tren1.equals(tren2)) {
				Fecha fecha1 = unBillete.getFecha();
				Fecha fecha2 = otroBillete.getFecha();
				if (fecha1.equals(fecha2)) {
					Integer vagon1 = unBillete.getVagon();
					Integer vagon2 = unBillete.getVagon();
					return vagon1.compareTo(vagon2);
				} else {
					return fecha1.compareTo(fecha2);
				}
			} else {
				return tren1.compareTo(tren2);
			}
		}
	};

}// Class