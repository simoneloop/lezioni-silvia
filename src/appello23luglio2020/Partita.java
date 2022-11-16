package appello23luglio2020;

public class Partita {
	private String nomeSquadraInCasa;
	private String nomeSquadraOspite;
	private int goalSquadraInCasa;
	private int goalSquadraOspite;
	private String nomeArbitro;
	private String cittaArbitro;
	
	public Partita(String nomeSquadraInCasa, String nomeSquadraOspite, int goalSquadraInCasa, int goalSquadraOspite, String nomeArbitro, String cittaArbitro) {
		this.nomeSquadraInCasa= nomeSquadraInCasa;
		this.nomeSquadraOspite=nomeSquadraOspite;
		this.goalSquadraInCasa=goalSquadraInCasa;
		this.goalSquadraOspite=goalSquadraOspite;
		this.nomeArbitro=nomeArbitro;
		this.cittaArbitro=cittaArbitro;
	}
	public String getNomeSquadraInCasa() {
		return nomeSquadraInCasa;
	}
	public String getNomeSquadraOspite() {
		return nomeSquadraOspite;
	}
	public int getGoalSquadraInCasa() {
		return goalSquadraInCasa;
	}
	public int getGoalSquadraOspite() {
		return goalSquadraOspite;
	}
	public String getNomeArbitro() {
		return nomeArbitro;
	}
	public String getCittaArbitro() {
		return cittaArbitro;
	}
	public boolean equals(Object o) {
		if (o==this)
			return true;
		if (o==null)
			return false;
		if (!(o.getClass().equals(this.getClass())))
			return false;
		Partita p= (Partita) o;
		return p.nomeSquadraInCasa.equals(nomeSquadraInCasa) && p.nomeSquadraOspite.equals(nomeSquadraOspite) && 
				p.goalSquadraInCasa==(goalSquadraInCasa) && p.goalSquadraOspite==(goalSquadraOspite) &&
				p.nomeArbitro.equals(nomeArbitro) && p.cittaArbitro.equals(cittaArbitro);
	}
	public String toString() {
		return "La/Il "+nomeSquadraInCasa+"ha giocato contro la/il "+nomeSquadraOspite+"e hanno ottenuto il punteggio: "+goalSquadraInCasa+
				","+goalSquadraOspite+" e la partita Ã¨ stata arbitrata da: "+nomeArbitro+"di "+cittaArbitro;
	}
}
