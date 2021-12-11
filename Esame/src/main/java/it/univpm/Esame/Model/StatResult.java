package it.univpm.Esame.Model;

import java.util.ArrayList;

	/**
	 * classe che rappresenta i risultati delle statistiche
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

public class StatResult {
	private int numTotale; 				//numero totale di annunci
	private String fulltimePercentuale; //percentuale di lavori full time 
	private int numFulltime; 			//numero di lavori part time
	private String partimePercentuale; 	//percentuale di lavori
	private int numPartime;  			//numero di lavori part time
	private String contractPercentuale; //percentuale di lavori a contratto
	private int numContract; 			//numero di lavori a contratto
	private int numRemoto;				//numero di lavori da remoto
	private String remotoPercentuale; 	//percentuale di lavori da remoto
	private int numMaxKeyword; 			//numero massimo di keyword
	private int numMinKeyword;			//numero minimo di keyword
	private ArrayList<String> bestJob;  			// Top 5 ruoli richiesti
	private ArrayList<String> linguaggi;	 //linguaggi richiesti insieme al javascript

	/**
	 * Costruttore senza parametri
	 */
	
	public StatResult() {
		this.numTotale=0;
		this.fulltimePercentuale=null;
		this.numFulltime=0;
		this.partimePercentuale=null;
		this.numPartime=0;
		this.contractPercentuale=null;
		this.numContract = 0;
		this.numMinKeyword=0;
		this.numMaxKeyword=0;
		this.bestJob=new ArrayList<String>();
		this.linguaggi=new ArrayList<String>();
	}
	
	



	/**
	 * Metodi Getter, Setter di numTotale, numTotLocation, fulltimePercentuale, numFulltime, partimePercentuale, numPartime, 
	 * contractPercentuale, numContract, numMinKeyword,numMaxKeyword, bestjob, linguaggi
	 */
	
	public int getNumTotale() {
		return numTotale;
	}


	public void setNumTotale(int numTotale) {
		this.numTotale = numTotale;
	}

	public String getFulltimePercentuale() {
		return fulltimePercentuale;
	}


	public void setFulltimePercentuale(String fulltimePercentuale) {
		this.fulltimePercentuale = fulltimePercentuale;
	}


	public int getNumFulltime() {
		return numFulltime;
	}


	public void setNumFulltime() {
		this.numFulltime++;
	}


	public String getPartimePercentuale() {
		return partimePercentuale;
	}


	public void setPartimePercentuale(String partimePercentuale) {
		this.partimePercentuale = partimePercentuale;
	}


	public int getNumPartime() {
		return numPartime;
	}


	public void setNumPartime() {
		this.numPartime++;
	}


	public String getContractPercentuale() {
		return contractPercentuale;
	}


	public void setContractPercentuale(String contractPercentuale) {
		this.contractPercentuale = contractPercentuale;
	}


	public int getNumContract() {
		return numContract;
	}


	public void setNumContract() {
		this.numContract++;
	}


	public int getNumRemoto() {
		return numRemoto;
	}


	public void setNumRemoto() {
		this.numRemoto++;
	}


	public String getRemotoPercentuale() {
		return remotoPercentuale;
	}


	public void setRemotoPercentuale(String remotoPercentuale) {
		this.remotoPercentuale = remotoPercentuale;
	}

	public ArrayList<String> getBestJob() {
		return bestJob;
	}


	public void setBestJob(ArrayList<String> bestJob) {
		this.bestJob = bestJob;
	}

	public ArrayList<String> getLinguaggi() {
		return linguaggi;
	}


	public void setLinguaggi(ArrayList<String> linguaggi) {
		this.linguaggi = linguaggi;
	}
	
	public int getNumMaxKeyword() {
		return numMaxKeyword;
	}

	public void setNumMaxKeyword(int numMaxKeyword) {
		this.numMaxKeyword = numMaxKeyword;
	}

	public int getNumMinKeyword() {
		return numMinKeyword;
	}

	public void setNumMinKeyword(int numMinKeyword) {
		this.numMinKeyword = numMinKeyword;
	}

}
	
	