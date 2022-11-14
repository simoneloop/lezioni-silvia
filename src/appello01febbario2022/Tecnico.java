package appello01febbario2022;
public class Tecnico {
	private String nome;
	private int costoOrario;
	
	public Tecnico(String nome, int costoOrario) {
		this.nome=nome;
		this.costoOrario=costoOrario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCostoOrario() {
		return costoOrario;
	}

	public void setCostoOrario(int costoOrario) {
		this.costoOrario = costoOrario;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Tecnico t= (Tecnico) o;
		return t.nome.equals(nome) && t.costoOrario==costoOrario;
	}
	public String toString() {
		return "''"+nome+"'', "+costoOrario;
	}
}
