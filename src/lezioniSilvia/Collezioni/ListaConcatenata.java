package lezioniSilvia.Collezioni;

import java.util.ArrayList;

class Nodo<E>{
	private E info;
	private Nodo<E> successivo;
	
	public Nodo(E info, Nodo<E> successivo)
	{	this.info = info;
		this.successivo = successivo;		
	}
	
	public E getInfo()
	{	return info;		
	}
	
	public Nodo<E> getSuccessivo()
	{	return successivo;		
	}
	
	public void setInfo(E info)
	{	this.info = info;		
	}
	
	public void setSuccessivo(Nodo<E> successivo)
	{	this.successivo = successivo;		
	}
	
	public boolean haInfo(E info)
	{	return this.info.equals(info);		
	}
	
	public String toString()
	{	return info.toString();		
	}
}


public class ListaConcatenata<E> {
	private Nodo<E> testa;
	private Nodo<E> coda;
	private int lunghezza;
	
	private void inizializza()
	{	testa = null;
		coda = null;
		lunghezza = 0;		
	}
	
	public ListaConcatenata()
	{	inizializza();		
	}
	
	public ListaConcatenata(ListaConcatenata<E> l)
	{	inizializza();
		for(Nodo<E> n = l.testa; n != null; n = n.getSuccessivo())
			aggiungiInCoda(n.getInfo());
	}
	
	public ListaConcatenata(ArrayList<E> a)
	{	inizializza();
		for(E v : a)
			aggiungiInCoda(v);		
	}
	
	public int getLunghezza()
	{	return lunghezza;		
	}
	
	public boolean eVuota()
	{	return lunghezza == 0;		
	}
	
	public void svuota()
	{	inizializza();		
	}

	
	public void aggiungiInCoda(E info)
	{	Nodo<E> nuovoNodo = new Nodo<E>(info,null);
		if(eVuota())
		{	testa = nuovoNodo;
			coda = nuovoNodo;			
		}
		else
		{	coda.setSuccessivo(nuovoNodo);
			coda = nuovoNodo;			
		}
		lunghezza++;
	}
	public void aggiungiInTesta(E info)
	{	Nodo<E> nuovoNodo = new Nodo<E>(info,testa);
		testa = nuovoNodo;
		if(coda == null)
			coda = nuovoNodo;
		lunghezza++;		
	}
	
	public void rimuoviTesta()
	{	if(eVuota())
			//throw new EccezioneListaVuota();
			throw new RuntimeException();
		if(lunghezza == 1)
		{	svuota();
			return;			
		}
		testa = testa.getSuccessivo();
		lunghezza--;
		if(testa == null)
			coda = null;		
	}
	
	public void rimuoviCoda()
	{	if(eVuota())
			//throw new EccezioneListaVuota();
			throw new RuntimeException();
		if(lunghezza == 1)
		{	svuota();
			return;			
		}
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
			if(n.getSuccessivo() == coda)
			{	n.setSuccessivo(null);
				coda = n;				
			}
		lunghezza--;
	}
	
	public ListaConcatenata<E> listaInvertita()
	{	ListaConcatenata<E> ret = new ListaConcatenata<E>();
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
			ret.aggiungiInTesta(n.getInfo());
		return ret;
	}
	
	public E get(int pos)
	{	if(pos < 0 || pos >= lunghezza)
			//throw new EccezioneIndiceNonValido();
			throw new RuntimeException();
		Nodo<E> n = testa;
		for(int i = 0; i < pos; i++)
			n = n.getSuccessivo();
		return n.getInfo();		
	}
	
	public void rimuovi(int pos)
	{	if(pos < 0 || pos >= lunghezza)
			//throw new EccezioneIndiceNonValido();
		if(pos == 0)
		{	rimuoviTesta();
			return;			
		}
		if(pos == lunghezza - 1)
		{	rimuoviCoda();
			return;			
		}
		Nodo<E> n = testa;
		for(int i = 0; i < pos - 1; i++)
			n = n.getSuccessivo();
		n.setSuccessivo(n.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
	public void rimuoviPrimo(E info)
	{	if(eVuota())
			return;
		if(testa.haInfo(info))
		{	rimuoviTesta();
			return;			
		}
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
		{	Nodo<E> successivoAdN = n.getSuccessivo();
			if(successivoAdN != null && successivoAdN.haInfo(info))
			{	n.setSuccessivo(successivoAdN.getSuccessivo());
				if(successivoAdN == coda)
					coda = n;
				lunghezza--;
				return;				
			}
		}
	}
	
	public void rimuoviTutti(E info)
	{	if(eVuota())
			return;
		while(testa != null && testa.haInfo(info))
			rimuoviTesta();
		Nodo<E> n = testa;
		while(n != null)
		{	Nodo<E> successivoAdN = n.getSuccessivo();
			if(successivoAdN != null && successivoAdN.haInfo(info))
			{	n.setSuccessivo(successivoAdN.getSuccessivo());
				if(successivoAdN == coda)
					coda = n;
				lunghezza--;
			}
			else
				n = successivoAdN;
		}
	}
	
	public int indiceDi(E info)
	{	int pos = 0;
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
		{	if(n.haInfo(info))
				return pos;
			pos++;			
		}
		return -1;
	}
	
	public int[] indiceDiTutti(E info)
	{	int cnt = conta(info);
		if(cnt == 0)
			return null;
		int[] ret = new int[cnt];
		int posLibera = 0;
		int indiceLista = 0;
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
		{	if(n.haInfo(info))
			{	ret[posLibera] = indiceLista;
				posLibera++;
			}
			indiceLista++;
		}
		return ret;
	}
	
	public boolean contiene(E info)
	{	return indiceDi(info) != -1;
	}
	
	public ArrayList<E> adArrayList()
	{	ArrayList<E> ret = new ArrayList<>();
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
			ret.add(n.getInfo());
		return ret;		
	}
	
	public String toString()
	{	String s = "[";
		for(Nodo<E> n = testa; n != null; n = n.getSuccessivo())
		{	s += n;
			if(n.getSuccessivo() != null)
				s += ", ";			
		}
		s += "]";
		return s;
	}
	
	private int contaDa(Nodo<E> n, E info)
	{	if(n == null)
			return 0;
		return (n.haInfo(info)? 1 : 0) + contaDa(n.getSuccessivo(),info);		
	}
	
	public int conta(E info)
	{	return contaDa(testa,info);
	}
}
