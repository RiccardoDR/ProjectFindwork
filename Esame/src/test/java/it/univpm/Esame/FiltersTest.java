package it.univpm.Esame;


import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.BodyClass;
import it.univpm.Esame.Model.Lavoro;

	/**
	 * Classe che permette di effettuare i test per la classe Filters
	 * @author Parente Christian
	 * @author Garzarella Fiore
 	*/

class FiltersTest {
	
	Filters filters= null;
	BodyClass body = null;
	BodyClass body2 = null;
	ArrayList<Lavoro> lavori = null;
	
	@BeforeEach
	void setUp() throws Exception{
		filters = new Filters();
		body = new BodyClass("Plano", false, "", "", "");
		body2 = new BodyClass("Chieti", false, "", "", "");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test() throws IOException, BodyException {
		lavori = new ArrayList<Lavoro>();
		lavori = filters.Filter(body);
		for (Lavoro lavoro : lavori) {
			assertEquals(lavoro.getLuogo(), body.getLuogo());
			assertEquals(lavoro.isRemoto(), body.getRemoto());
		}
	}
	
	@Test
	void test_eccezioni( ) {
		ResponseStatusException e;
		e = assertThrows(ResponseStatusException.class, ()->{filters.Filter(body2);});
		assertTrue(e.getMessage().contains("Nessun risultato trovato"));
	}

}
