package lezioniSilvia.Collezioni;

public class NodoInt {
	
	private int info;
	private NodoInt successivo;
	
	public NodoInt(int info,NodoInt successivo) {
		this.info=info;
		this.successivo=successivo;
	}
	
	public int getInfo() {
		return info;
	}
	public NodoInt getSuccessivo() {
		return successivo;
	}
	
	public void setInfo(int newInfo) {
		info=newInfo;
	}
	
	public void setSuccessivo(NodoInt newSuccessivo) {
		successivo=newSuccessivo;
	}
	
	public boolean haInfo(int info) {
		return this.info==info;
	}
	
	public String toString() {
		return ""+info;
	}
	

}

