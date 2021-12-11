package it.univpm.Esame;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Classe che permette di effettuare tutti i test contemporaneamente
 * @author Parente Christian
 * @author Garzarella Fiore
 */

@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
@SelectClasses({BodyClassTest.class,LavoroTest.class,StatisticsTest.class,FiltersTest.class, StatisticsTest.class})
class AllTests {

}
