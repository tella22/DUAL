public class Moto extends Vehiculo{

	private Integer cilindrada;
	
	public Moto(String matricula, Integer ruedas, Integer cilindrada) {
		super(matricula, ruedas );
		this.cilindrada = cilindrada;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	@Override
	public String ponerEnMarcha() {
		return "La moto de matricula " + getMatricula() + " se ha puesto en marcha.";
	}

}
