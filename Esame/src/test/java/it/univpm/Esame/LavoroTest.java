package it.univpm.Esame;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.Esame.Model.Lavoro;

	/**
	 * Classe che permette di effettuare i test per la classe Lavoro
	 * @author Parente Christian
	 * @author Garzarella Fiore
	 */

class LavoroTest {
	private Lavoro l=null;
	private ArrayList<String> p=null;
	
	
	
	@BeforeEach
	void setUp() throws Exception{
		p=new ArrayList<String>();
		p.add("ios");
		p.add("javascript");
		p.add("swift");
		l=new Lavoro(1234,"Software","Apple","Cupertino",false,"full time",p,"2021-12-6");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	@DisplayName("test Lavoro")
	void test() {
		assertEquals(l.getId(), 1234);
		assertEquals(l.getRuolo(), "Software");
		assertEquals(l.getAzienda(), "Apple");
		assertEquals(l.getLuogo(), "Cupertino");
		assertEquals(l.isRemoto(), false);
		assertEquals(l.getData(), "2021-12-6");
		assertEquals(l.getKeyword(), p);
		assertEquals(l.getOrario(), "full time");
	}
	
	@Test
	@DisplayName("test 2 Lavoro")
	void test2() {
		assertAll("valori", ()->assertEquals(l.getId(), 1234),  
				()->assertEquals(l.getRuolo(), "Software"),
				()->assertEquals(l.getAzienda(), "Apple"),
				()->assertEquals(l.getLuogo(), "Cupertino"),
				()->assertEquals(l.isRemoto(), false),
				()->assertEquals(l.getData(), "2021-12-6"),
				()->assertEquals(l.getKeyword(), p),
				()->assertEquals(l.getOrario(), "full time"));
	}

}



