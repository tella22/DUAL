import java.io.Serializable;
import java.util.Comparator;

public class Videojuego implements Comparable<Videojuego>, Serializable {

	private String nombre;
	private String fabricante;
	private Integer edadMinima;
	private Float precio;
	private Integer unidadesVendidas;
	private String formaJuego;
	private String plataforma;

	public Videojuego(String nombre, String fabrincante, Integer edadMinima, Float precio, Integer unidadesVendidas,
			String formaJuego, String plataforma) {
		super();
		this.nombre = nombre;
		this.fabricante = fabrincante;
		this.edadMinima = edadMinima;
		this.precio = precio;
		this.unidadesVendidas = unidadesVendidas;
		this.formaJuego = formaJuego;
		this.plataforma = plataforma;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFabrincante(String fabrincante) {
		this.fabricante = fabrincante;
	}

	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public void setUnidadesVendidas(Integer unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public void setFormaJuego(String formaJuego) {
		this.formaJuego = formaJuego;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getFabricante() {
		return fabricante;
	}

	public Integer getEdadMinima() {
		return edadMinima;
	}

	public Float getPrecio() {
		return precio;
	}

	public Integer getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public String getFormaJuego() {
		return formaJuego;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public Videojuego buscar(String nombre) {
		if (nombre.equals(this.nombre)) {
			return this;
		} else {
			return null;
		}
	}

	@Override
	public int compareTo(Videojuego o) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(o.getNombre());

	}
	
//	@Override
//	public String toString() {
//		return "Videojuego [nombre=" + nombre + ", fabricante=" + fabricante + "]";
//	}

	public static Comparator<Videojuego> compVideojuego = new Comparator<Videojuego>() {

		// Ordena primero por nombre de fabricante y luego por nombre de videojuego
		@Override
		public int compare(Videojuego vid, Videojuego vid1) {
			// TODO Auto-generated method stub
			int devolver;
			devolver = vid.getFabricante().compareTo(vid1.getFabricante());
			if (devolver != 0) {
				return devolver;
			}
			devolver = vid.compareTo(vid1);
			return devolver;

		}

	};

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", fabricante=" + fabricante + ", edadMinima=" + edadMinima
				+ ", precio=" + precio + ", unidadesVendidas=" + unidadesVendidas + ", formaJuego=" + formaJuego
				+ ", plataforma=" + plataforma + "]";
	}
}
