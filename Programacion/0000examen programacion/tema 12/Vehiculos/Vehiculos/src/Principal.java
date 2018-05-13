import java.util.*;
public class Principal {

	public static void main(String[] args) {

		//si vehiculo no implementa Comparable salta una excepcion. No hace falta que implemente equals ni hashCode()
		Set <Vehiculo> setVehiculos = new TreeSet <Vehiculo>();
		
		//Si Vehiculo no implementa los metodos equals y hashCode() admite repetidos (aunque implemente Comparable, que no hace falta)
		//Set <Vehiculo> setVehiculos = new HashSet <Vehiculo>();
		
		//Si Vehiculo no implementa los metodos equals y hashCode() admite repetidos (aunque implemente Comparable, que no hace falta)
		//Set <Vehiculo> setVehiculos = new LinkedHashSet <Vehiculo>();
		
		List <Vehiculo> listVehiculos = new LinkedList <Vehiculo>();

		Vehiculo vehiculos[] = new Vehiculo[5];

		vehiculos[0] = new Coche("001", 4, 2);
		vehiculos[1] = new Moto("002", 2, 125);
		vehiculos[2] = new Moto("003", 3, 90);
		vehiculos[3] = new Coche("004", 4, 4);
		vehiculos[4] = new Coche("004", 4, 4);

		for (int i=0;i<vehiculos.length;i++){
			setVehiculos.add(vehiculos[i]);
			listVehiculos.add(vehiculos[i]);
		}
		
		visualizar(setVehiculos, listVehiculos);

	}//main


	public static void visualizar(Set <Vehiculo> setVehiculos, List <Vehiculo> listVehiculos){
		Coche coche;
		Moto moto;
		
		/* Vehiculo unVehiculo;
		Iterator<Vehiculo> itr = setVehiculos.iterator();
		while(itr.hasNext()){
			unVehiculo = itr.next();
			System.out.println(unVehiculo.ponerEnMarcha());
		}*/
		
		Leer.mostrarEnPantalla("Recorrido con SET: \n");
		
		for (Vehiculo vehiculo : setVehiculos){
			if (vehiculo instanceof Coche){
				coche = (Coche) vehiculo;
				Leer.mostrarEnPantalla("Asientos del coche: "+coche.getNumAsientos()+ ". Matrícula: "+ coche.getMatricula() + ". Ruedas: " + coche.getRuedas());
			}
			if (vehiculo instanceof Moto){
				moto = (Moto) vehiculo;
				Leer.mostrarEnPantalla("Cilindrada de la moto: "+moto.getCilindrada() + ". Matrícula: "+ moto.getMatricula() + ". Ruedas: " + moto.getRuedas());
			}
			Leer.mostrarEnPantalla(vehiculo.ponerEnMarcha()+"\n");
			
		}
		Leer.mostrarEnPantalla("Recorrido con LIST: \n");
		
		for (Vehiculo vehiculo : listVehiculos){
			if (vehiculo instanceof Coche){
				coche = (Coche) vehiculo;
				Leer.mostrarEnPantalla("Asientos del coche: "+coche.getNumAsientos()+ ". Matrícula: "+ coche.getMatricula() + ". Ruedas: " + coche.getRuedas());
			}
			if (vehiculo instanceof Moto){
				moto = (Moto) vehiculo;
				Leer.mostrarEnPantalla("Cilindrada de la moto: "+moto.getCilindrada() + ". Matrícula: "+ moto.getMatricula() + ". Ruedas: " + moto.getRuedas());
			}
			Leer.mostrarEnPantalla(vehiculo.ponerEnMarcha()+"\n");
			
		}

	}
}//class
