public class Billete implements Comparable<Billete>{
	private Integer numBillete;
	private Tren tren;
	private Integer vagon;
	private Integer asiento;
	private Double precio;
	private static int contaBilletes = 0;
	private Fecha fecha;
	
	public Billete(Tren tren, Fecha fecha) {
		this.tren = tren;
		this.fecha = fecha;
		precio = 20.0;
		contaBilletes++;
		numBillete = contaBilletes;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Integer getNumBillete() {
		return numBillete;
	}

	public Tren getTren() {
		return tren;
	}

	public void setTren(Tren tren) {
		this.tren = tren;
	}

	public Integer getVagon() {
		return vagon;
	}

	public void setVagon(Integer vagon) {
		this.vagon = vagon;
	}

	public Integer getAsiento() {
		return asiento;
	}

	public void setAsiento(Integer asiento) {
		this.asiento = asiento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int compareTo(Billete otroBillete){
		return this.numBillete.compareTo(otroBillete.numBillete);
	}

	@Override
	public String toString() {
		return "Billete [tren:" + tren.getEstacionSalida() + " - " + tren.getEstacionLLegada() + ", vagon: " + vagon + ", asiento: " + asiento + ", precio: " + precio
				+ "\n numBillete: " + numBillete + ", fecha: " + fecha.fechaTexto() +"]\n";
		/*return "Billete [tren:" + tren + ", vagon: " + vagon + ", asiento: " + asiento + ", precio: " + precio
				+ "€, idBillete: " + idBillete + ", numBillete: " + numBillete + ", fecha: " +fecha +"]";*/
	}

}