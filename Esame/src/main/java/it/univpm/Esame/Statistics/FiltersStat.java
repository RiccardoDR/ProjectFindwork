package it.univpm.Esame.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.BodyClass;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.StatResult;

	/**
	 * CLasse che gestisce la generazione delle statistiche in base
	 * ai parametri inseriti
	 * @author Parente Christian
	 * @author Fiore Garzarella
	 */

@Service
public class FiltersStat {
	
	/**
	 * Metodo che effettua le statistiche sugli annunci in base ai parametri forniti nel body dall'utente.
	 * @param BodyClass
	 * @return StatResult
	 * @throws IOException
	 * @throws BodyException
	 */
	
	public StatResult Stats(BodyClass body) throws IOException, BodyException {
		StatResult risultati = new StatResult();
		Filters f = new Filters();
		
		ArrayList<Lavoro> annunci = f.Filter(body); //richiamo i filtri
		risultati.setNumTotale(annunci.size());
		ArrayList<String> tmp=new ArrayList<String>();
		ArrayList<Integer> conta = new ArrayList<Integer>(); 
		
		
		for (Lavoro lavori : annunci) { 
			if(lavori.getOrario().equalsIgnoreCase("full time"))
				risultati.setNumFulltime(); //metodi set che incrementano solamente
			if(lavori.getOrario().equalsIgnoreCase("part time"))
				risultati.setNumPartime();  
			if(lavori.getOrario().equalsIgnoreCase("contract"))
				risultati.setNumContract();
			if(lavori.isRemoto())
				risultati.setNumRemoto();
			tmp.addAll(lavori.getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
		}
		
		risultati.setBestJob(top5(annunci));
		
		Set<String> set = new HashSet<String>(tmp);  //lo metto dentro un hashSet che non consente i duplicati
		tmp.clear();  //cancello gli elementi dell'arraylist
		tmp.addAll(set);  //e ci rimetto l'hashset privo di duplicati
		tmp=filtraKeywords(tmp);
		
		double percentuale1 = (risultati.getNumFulltime()/ (double) risultati.getNumTotale())*100;
		risultati.setFulltimePercentuale(String.format("%.01f", percentuale1)+"%"); //"%.01f" per mettere solo una cifra decimale
		
		//calcolo percentuale part time
		double percentuale2=(risultati.getNumPartime()/ (double) risultati.getNumTotale())*100;
		risultati.setPartimePercentuale(String.format("%.01f", percentuale2)+"%");
		
		double percentuale3 = (risultati.getNumContract()/ (double) risultati.getNumTotale())*100;
		risultati.setContractPercentuale(String.format("%.01f", percentuale3)+"%");
			
		double percentuale4 = (risultati.getNumRemoto()/ (double) risultati.getNumTotale())*100;
		risultati.setRemotoPercentuale(String.format("%.01f", percentuale4)+"%");
		
		for (Lavoro lavori : annunci) 
			conta.add(lavori.getKeyword().size());
		Collections.sort(conta); 		//dato che devo trovare massimo e minimo riordino e prendo la prima e ultima posizione
		risultati.setNumMinKeyword(conta.get(0));
		risultati.setNumMaxKeyword(conta.get(conta.size()-1));
			
		risultati.setLinguaggi(tmp);
		
		
		return risultati;
		
	}
	
	/**
	 * Metodo che permette di filtrare le keywords attraverso
	 * la lista presente sul file lista_keywords
	 * @param ArrayList<String>
	 * @return ArrayList<String>
	 */
	
	private ArrayList<String> filtraKeywords(ArrayList<String> arr){
		String c;
		try {
			BufferedReader file = new BufferedReader(new FileReader("txtdocs/"+"lista_keywords.txt"));
			 c= file.readLine();
			if(c==null) 
				file.close();

			file.close();
		}catch(IOException e) {
			e.getStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato.");
		}
		for(int j=0;j<arr.size();j++){
			if(c.contains(arr.get(j))==false) {
				arr.remove(j);
				j--;
			}
		}
		return arr;
		
		}

	/**
	 * metodo per trovare la Top 5 dei ruoli più richiesti
	 * @param ArrayList<Lavoro>
	 * @return ArrayList<String>
	 */
	
	private ArrayList<String> top5(ArrayList<Lavoro> annunci){
		ArrayList<String> roles=new ArrayList<String>(); 
		ArrayList<Integer> contator=new ArrayList<Integer>(); //inizializzare di dimensione come roles 
		String c="";					      
		
		try {
			BufferedReader file = new BufferedReader(new FileReader("txtdocs/"+"lista_ruoli.txt"));
			while(c != null){
				c = file.readLine();
				if(c != null) {
					roles.add(c);
					contator.add(0);
				}
			}
			file.close();
		}catch(IOException e) {
			e.getStackTrace();
		}

		for(int i=0;i<annunci.size();i++)
			for(int j=0;j<roles.size();j++) {
				if(annunci.get(i).getRuolo().contains(roles.get(j)))
					contator.set(j,contator.get(j)+1);
			}
		while (roles.size()>5) { 
			int indice=trovaMinimo(contator);
			contator.remove(indice);
			roles.remove(indice);
		}
		return roles; //rimangono solo i 5 ruoli 
	}

	/**
	 * metodo per trovare il minimo in un arraylist di interi e ne restituisce l'indice 
	 * @param ArrayList<Integer>
	 * @return int
	 */
	private int trovaMinimo(ArrayList<Integer> contator) {
		int minimo = contator.get(0);
		int indexMin=0;
		for(int i=1;i<contator.size();i++){
			if(minimo > contator.get(i)) {
				minimo=contator.get(i);
				indexMin=i;
			}
		}
		return indexMin;
	}

}







