public class Coche extends Vehiculo {

	private Integer numAsientos;

	public Coche(String matricula, Integer ruedas, Integer numAsientos) {
		super(matricula, ruedas );
		this.numAsientos = numAsientos;
	}

	public Integer getNumAsientos() {
		return numAsientos;
	}

	
	
	@Override
	public String ponerEnMarcha() {
		return "El coche de matricula " + getMatricula() + " se ha puesto en marcha.";
	}
}
