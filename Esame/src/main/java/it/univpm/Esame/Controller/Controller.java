package it.univpm.Esame.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.TipsClass;
import it.univpm.Esame.Service.JsonParser;
import it.univpm.Esame.Statistics.FiltersStat;
import it.univpm.Esame.Model.BodyClass;

 /**
 * Rappresenta la classe che gestisce tutte le chiamate al server
 * @author Garzarella Fiore
 * @author Parente Christian
 */

@RestController
public class Controller {
	
	@Autowired
	JsonParser lavoro;
	@Autowired
	Filters filters;
	@Autowired
	TipsClass tips;
	@Autowired
	FiltersStat filstat;
	
	/**
	 * Rotta di tipo GET che restituisce tutti gli annunci di lavoro.	 
	 * @return Ritorna il JSON che contiene la lista di tutti gli annunci.
	 * @throws ParseException
	 * @throws IOException
	 */
		
	@GetMapping(value ="/annunci")
	public ResponseEntity<Object> ShowJobs() throws ParseException, IOException {
		return new ResponseEntity<>(lavoro.Parsing(), HttpStatus.OK);
	}
	
	
	/**
	 * Rotta di tipo GET che restituisce il nome di 5 città americane.
	 * @return Ritorna il nome di 5 città americane su cui successivamente fare filtri e statistiche.
	 */
	
	
	@GetMapping(value="/tips")
	public TipsClass ShowTips() {
		return new TipsClass();
	}
	
	/**
	 * Rotta di tipo POST che effettua il filtraggio degli annunci in base ai parametri forniti.
	 * @param luogo Tipo parametro che dichiara di quale paese si intende conoscere gli annunci.
	 * @param remoto Tipo parametro che dichiara se il lavoro è da remoto o non.
	 * @param orario Tipo parametro che dichiara se il lavoro è full time, part time o contract.
	 * @param ruolo Tipo parametro che filtra gli annunci in base al ruolo.
	 * @return Ritorna solamente gli annunci filtrati.
	 * @throws ParseException 
	 * @throws IOException
	 * @throws BodyException
	 */
	
	@PostMapping(value="/filters")
	public ResponseEntity<Object> ShowFilters(@RequestBody BodyClass body) throws ParseException,IOException,BodyException{
		return new ResponseEntity<>(filters.Filter(body),HttpStatus.OK);
	}
	
	/**
	 * Rotta di tipo POST che effettua le statistiche degli annunci in base ai parametri forniti.
	 * @return Ritorna le statistiche sugli annunci.
	 * @throws ParseException 
	 * @throws IOException
	 * @throws BodyException
	 */
	
	@PostMapping(value="/stats")
	public ResponseEntity<Object> ShowFilStat(@RequestBody BodyClass body) throws ParseException, IOException,BodyException{
		return new ResponseEntity<>(filstat.Stats(body),HttpStatus.OK);
	}
	
	
	
	
}
