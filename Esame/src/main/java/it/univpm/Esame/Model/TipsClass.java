package it.univpm.Esame.Model;

import org.springframework.stereotype.Service;

	/**
	 * Rappresenta la classe che gestisce la rotta delle cinque città americane 
	 * da suggerire all'utente
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

@Service
public class TipsClass {
	
	private String titolo;
	private String citta;
	
	/**
	 * Costruttore senza parametri
	 */
	
	public TipsClass() {
		this.setTitolo("Città americane suggerite :");
		this.setCitta("Plano, Seattle, Boston , Palo Alto, San Francisco");
	}

	/**
	 * Metodi Getter, Setter di titolo, città
	 */

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public String getCitta() {
		return this.citta;
	}
	
	
}
