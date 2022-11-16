package appello27gennaio2021;
import java.util.*;
public class Merce {
	private String nome;
	private String marca;
	private LinkedList<String> fornitori;
	
	public Merce(String nome,String marca,LinkedList<String> fornitori) {
		this.nome=nome;
		this.marca=marca;
		this.fornitori=fornitori;
	}
	public String getMarca() {
		return marca;
	}
	public String getNome() {
		return nome;
	} 
	
	public LinkedList<String> getFornitori() {
		return fornitori;
	}
	
	
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(o==this) {
			return true;
		}
		if(!(o.getClass().equals(this.getClass()))) {
			return false;
		}
		Merce f=(Merce) o;
		return f.getNome().equals(nome) &&
				f.getMarca().equals(marca)&&
				f.getFornitori().equals(fornitori);
	}
	
	public String toString() {
		return "nome: "+nome+", marca: "+marca+", fornitori:"+fornitori.toString();
	}
}
