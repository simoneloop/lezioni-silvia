package appello11luglio2022;
import java.util.*;
public class Merce {
	private String nome;
	private String marca;
	private LinkedList<String> listaFornitori;
	private LinkedList<Float> listaPrezzi;
	
	public Merce(String nome, String marca, LinkedList<String> listaFornitori, LinkedList<Float> listaPrezzi) {
		this.nome=nome;
		this.marca=marca;
		this.listaFornitori=listaFornitori;
		this.listaPrezzi=listaPrezzi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LinkedList<String> getListaFornitori() {
		return listaFornitori;
	}

	public void setListaFornitori(LinkedList<String> listaFornitori) {
		this.listaFornitori = listaFornitori;
	}

	public LinkedList<Float> getListaPrezzi() {
		return listaPrezzi;
	}

	public void setListaPrezzi(LinkedList<Float> listaPrezzi) {
		this.listaPrezzi = listaPrezzi;
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
		Merce m=(Merce) o;
		return m.getListaFornitori().equals(listaFornitori) && m.getMarca().equals(marca) &&
				m.getNome().equals(nome) && m.getListaPrezzi().equals(listaPrezzi);
	}
	public String toString() {
		return "Nome: "+nome+", Marca: "+marca+", ListaFornitori: "+listaFornitori+", ListaPrezzi: "+listaPrezzi;
	}
	
}

