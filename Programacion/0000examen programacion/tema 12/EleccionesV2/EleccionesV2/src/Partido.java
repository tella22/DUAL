
public class Partido {
	private String nombre;
	private int votos;
	private int esca�os;
	/**
	 * @param nombre
	 *
	 */
	public Partido(String nombre) {
		this.nombre = nombre;
		this.votos = 0;
		this.esca�os = 0;
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
	 * @return the esca�os
	 */
	public int getEsca�os() {
		return esca�os;
	}
	/**
	 * @param esca�os the esca�os to set
	 */
	public void setEsca�os(int esca�os) {
		this.esca�os = esca�os;
	}

	public String toString(){
		return nombre+ "  votos "+votos+" esca�os "+esca�os;
	}
	
}
