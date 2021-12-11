package it.univpm.Esame.Model;

	/**
	 * Rappresenta la classe che utilizziamo per
	 * effettuare le richieste di tipo POST
	 * @author Garzarella Fiore
 	 * @author Parente Christian
 	 */

//ci metto solo i campi che ci servono per i filtri e statistiche

public class BodyClass {
	private String luogo;  //filtro su città
	private Boolean remoto;  //filtro su lavori in remoto
	private String orario;	//filtro per part-time full-time
	private String ruolo; //filtro sui ruoli
	private String data;  //per filtrare su data
	
	/**
	 * Costruttore con parametri
	 * @param luogo
	 * @param remoto
	 * @param orario
	 * @param ruolo
	 * @param data
	 */

	public BodyClass(String luogo, Boolean remoto, String orario, String ruolo, String data) {
		this.luogo = luogo;
		this.remoto = remoto;
		this.orario = orario;
		this.ruolo = ruolo;
		this.data = data;
	}

	/**
	 * Metodi Getter, Setter di data,luogo,remoto,orario,ruolo
	 */
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Boolean getRemoto() {
		return remoto;
	}

	public void setRemoto(Boolean remoto) {
		this.remoto = remoto;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	

}
