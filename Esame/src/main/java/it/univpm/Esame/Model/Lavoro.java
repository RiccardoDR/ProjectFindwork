package it.univpm.Esame.Model;

import java.util.ArrayList;



import org.json.JSONArray;

	/**
	 * Classe che implementa i dati riguardante un annuncio
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

public class Lavoro {
	private int id;
	private String ruolo;
	private String azienda;
	private String luogo;
	private boolean remoto;
	private String orario;   //part-time o full-time o a contratto
	private ArrayList<String> keyword;
	private String data; 
	
	/**
	 * Costruttore senza parametri
	 */

	public Lavoro() {
		this.id= 0;
		this.ruolo=null;
		this.azienda=null;
		this.luogo=null;
		this.remoto=false;
		this.data=null;
		this.orario=null;
		this.keyword=new ArrayList<String>();
	}
	
	
	/**
	 * Costruttore con parametri
	 * @param id
	 * @param ruolo
	 * @param azienda
	 * @param luogo
	 * @param remoto
	 * @param data
	 * @param orario
	 * @param keyword
	 */
	
	public Lavoro(int id, String ruolo, String azienda, String luogo, boolean remoto, String orario,
			ArrayList<String> keyword, String data) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.azienda = azienda;
		this.luogo = luogo;
		this.remoto = remoto;
		this.orario = orario;
		this.keyword = keyword;
		this.data = data;
	}


	/**
	 * Metodi Getter, Setter di data, id, ruolo, azienda, luogo, remoto, orario, keyword
	 */

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String getAzienda() {
		return azienda;
	}
	
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	
	public String getLuogo() {
		return luogo;
	}
	
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public boolean isRemoto() {
		return remoto;
	}
	
	public void setRemoto(boolean remoto) {
		this.remoto = remoto;
	}
	
	public String getOrario() {
		return orario;
	}
	
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	public ArrayList<String> getKeyword() {
		return this.keyword;
	}
	
	public void setKeyword(JSONArray jsonArray) {
		for(int i=0;i<jsonArray.length();i++) {
			String tmpString=(String)jsonArray.getString(i);
			this.keyword.add(tmpString);
		}
	}
	
}
