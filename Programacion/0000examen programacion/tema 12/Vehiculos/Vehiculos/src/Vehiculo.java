public abstract class Vehiculo implements Comparable<Vehiculo>{

	private String matricula;
	private Integer ruedas;
	

	public Vehiculo(String matricula, Integer ruedas ) {
		this.matricula = matricula;
		this.ruedas = ruedas;	
	}

	public Integer getRuedas() {
		return ruedas;
	}


	public String getMatricula() {
		return matricula;
	}

	public abstract String ponerEnMarcha();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public int compareTo(Vehiculo v2){
		return this.matricula.compareTo(v2.matricula);
	}
	
}
