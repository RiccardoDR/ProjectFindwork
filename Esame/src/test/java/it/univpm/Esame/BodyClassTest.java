package it.univpm.Esame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import it.univpm.Esame.Model.BodyClass;
	
	/**
	 * Classe che permette di effettuare i test per la classe BodyClass
	 * @author Parente Christian
	 * @author Garzarella Fiore
	 */

class BodyClassTest {
	private BodyClass body=null;
	
	
	@BeforeEach
	void Setup() {
		body=new BodyClass("Plano", false, "full time", "Full stack developer", "2021-12-07");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test() {
		assertEquals(body.getLuogo(),"Plano");
		assertEquals(body.getRemoto(),false);
		assertEquals(body.getOrario(),"full time");
		assertEquals(body.getRuolo(),"Full stack developer");
		assertEquals(body.getData(),"2021-12-07");
		
	}
	
	@Test
	void test2() {
		assertAll("valori", ()->assertEquals(body.getLuogo(),"Plano"),  
				()->assertEquals(body.getRemoto(),false),
				()->assertEquals(body.getOrario(),"full time"),
				()->assertEquals(body.getRuolo(),"Full stack developer"),
				()->assertEquals(body.getData(),"2021-12-07"));
	}

}
