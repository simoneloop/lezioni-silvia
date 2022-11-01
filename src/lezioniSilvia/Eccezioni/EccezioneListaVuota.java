package lezioniSilvia.Eccezioni;

public class EccezioneListaVuota extends RuntimeException {
	
	public String toString() {
		return "la lista è vuota";
	}
}
