
public class Partido {
	private String nombre;
	private int votos;
	private int escaños;
	/**
	 * @param nombre
	 *
	 */
	public Partido(String nombre) {
		this.nombre = nombre;
		this.votos = 0;
		this.escaños = 0;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the votos
	 */
	public int getVotos() {
		return votos;
	}
	/**
	 * @param votos the votos to set
	 */
	public void setVotos(int votos) {
		this.votos = votos;
	}
	/**
	 * @return the escaños
	 */
	public int getEscaños() {
		return escaños;
	}
	/**
	 * @param escaños the escaños to set
	 */
	public void setEscaños(int escaños) {
		this.escaños = escaños;
	}

	public String toString(){
		return nombre+ "  votos "+votos+" escaños "+escaños;
	}
	
}
