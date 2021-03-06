import java.util.*;

/**
 * Klassen implementerer en stabel, eller LIFO(last inn first out)
 * liste. Denne klassen er ogsa en hovedklasse for andre implementasjoner
 * slik som koe og ordnetLenkeListe.
 * 
 * @author Daniel James Tarplett
 *
 * @param <T> Objektene som er inneholdt i listen
 */
public class Stabel<T> implements Liste<T>{
	
	protected Node hode;
	protected Node hale;
	protected int antall;
	
	// Etablerer tom liste
	public Stabel(){
		Node ende = null;
		hode = ende;
		hale = ende;
		antall = 0;
	}
	
	/**
	* Beregner antall elementer i listen
	* @return antall elementer i listen
	*/
	public int storrelse(){
	    return antall;
	}

	/**
	* Sjekker om listen er tom
	* @return true om listen er tom, ellers false
	*/
	public boolean erTom(){
		if(hode == null && hale == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	* Setter inn et element i listen. Metoden gjor slik at
	* de siste elementene som legges inn kommer forst i lista.
	* @param element elementet som settes inn
	*/
	public void settInn(T element){
	    Node ny = new Node(element);
	    ny.neste = hode;
	    hode = ny;
	    
	    if(hale == null){
		hale = ny;
		}
	    antall++;
	}
	
	/**
	* Fjerner elementet som er forst i listen. Hvis listen er tom,
	* returneres null.
	* @return elementet
	*/
	public T fjern(){
	    return null;
	}
	
	/**
	 * Henter objekt med nr fra listen
	 * @param nr
	 * @return T Objektetdet sokes etter
	 */
	public T hent(int nr){
	    Node skalHentes = hode;
	    for(int i=0;i<nr;i++){
		skalHentes = skalHentes.neste;
	    }
	    return skalHentes.objekt;
	}
	public Iterator<T> iterator(){
	    return new ListeIterator();
	}
	
	/**
	 * Klassen definerer en nodeklasse som kan inneholde objekter T
	 * i en lenkeliste. Nodene er koblet til nodene ved siden av og
	 * har en start node og endenode.
	 * @author Daniel James Tarplett
	 *
	 */
	protected class Node{
		T objekt;
		Node neste = null;
		
		Node(T objekt){
		    this.objekt = objekt;
		}
	}
	
	/**
	 * Klasse for opprettelse av en iterator
	 * @author Daniel James Tarplett
	 *
	 */
	private class ListeIterator implements Iterator<T>{
		int teller = 0;
		Node neste = hode;
		
		public boolean hasNext(){
			return (teller < antall);
		}
		
		public T next(){
			T nesteObjekt = neste.objekt;
			teller++;
			neste = neste.neste;
			return nesteObjekt;
		}
		
		public void remove(){
			
		}
		
	}
}
