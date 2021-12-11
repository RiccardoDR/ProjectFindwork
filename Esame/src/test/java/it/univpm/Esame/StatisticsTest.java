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
import it.univpm.Esame.Model.StatResult;
import it.univpm.Esame.Statistics.FiltersStat;

	/**
	 * Classe che permette di effettuare i test per la classe FilterStat
	 * @author Parente Christian
	 * @author Garzarella Fiore
	 */

class StatisticsTest {
	
	FiltersStat stat=null;
	StatResult res=null;
	StatResult res2=null;
	StatResult res3=null;
	BodyClass body=null;
	BodyClass body3=null;
	Filters fil=null;
	ArrayList<Lavoro> l=null;
	
	@BeforeEach
	void setUp() throws Exception {
		stat=new FiltersStat();
		fil=new Filters();
		body=new BodyClass("Plano", false, null, null, null); //caso in cui c'è la località
		body3=new BodyClass("Chieti", false, null, null, null); //caso in cui non viene trovata (per test eccezioni)
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException, BodyException {
		l=fil.Filter(body);
		res=stat.Stats(body);
		assertEquals(res.getNumTotale(),l.size()); 
		}
	
	
	@Test
	void test3_eccezioni() {
		ResponseStatusException e;
		e = assertThrows(ResponseStatusException.class, ()->{res3=stat.Stats(body3);});
		assertTrue(e.getMessage().contains("Nessun risultato trovato"));
	}
	
	
	
	
	

}
