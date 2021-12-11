package it.univpm.Esame.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

 /**
  * Classe per generare eccezioni personalizzate, che estende Exception
  * @author Garzarella Fiore
  * @author Parente Christian
  */


@SuppressWarnings("serial") //perchè non viene inserito un serialID
public class BodyException extends Exception{
	//eccezione 
	
	public BodyException() {	
		super();
	}
	
	/**
	 * eccezione da richiamare in caso di body non valido,
	 * restituisce un messaggio di errore
	 * @param String
	 */
	public void InvalidBody(String out) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,out);
	}
	
	/**
	 * eccezione da richiamare in caso filtri o statistiche non producano risultati
	 * @param String
	 */
	public void BodyResults(String out) {
		throw new ResponseStatusException(HttpStatus.OK, out);
	}

}
