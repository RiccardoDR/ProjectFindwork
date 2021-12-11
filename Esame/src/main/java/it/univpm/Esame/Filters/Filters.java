package it.univpm.Esame.Filters;


import java.io.IOException;
import java.util.ArrayList;


import org.springframework.stereotype.Service;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.BodyClass;
import it.univpm.Esame.Service.JsonParser;

	/**
	 * Rappresenta la classe in cui si effettua
	 * il filtraggio degli annunci.
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

@Service
public class Filters {
	
	/**
	 * Metodo che filtra gli annunci in base ai parametri forniti nel body dall'utente.
	 * @param BodyClass
	 * @return ArrayList<Lavoro>
	 * @throws IOException
	 * @throws BodyException
	 */
	
	public ArrayList<Lavoro> Filter(BodyClass body) throws IOException, BodyException {
		BodyException e = new BodyException();
		JsonParser downloader = new JsonParser();
		ArrayList<Lavoro> annunci = downloader.Parsing();

		// filtro location
		if (body.getLuogo() != null) {
			if(body.getLuogo().contains(" ")) { // caso più città nel filtro
				ArrayList<String> tmp = new ArrayList<String>();
				boolean flag;
				String[] locations=body.getLuogo().split(" ");
				for(int j=0;j<locations.length;j++)
					tmp.add(locations[j]);
				
				for(int i=0;i<annunci.size();i++){
					flag = false;
					for(int h=0;h<tmp.size();h++) {
						if(annunci.get(i).getLuogo().contains(tmp.get(h)) == true) { 
							flag = true;
						}
					}
					if (flag == false) {
						annunci.remove(i);
						i--;
					}
				}		
				
			} else if(body.getLuogo() != "") { 
					for(int i=0;i<annunci.size();i++) 
						if(annunci.get(i).getLuogo().contains(body.getLuogo())==false) {
							annunci.remove(i);
							i--;
						}
					}
		}
				
		//filtro orario full-time part-time contratto
		if (body.getOrario()!=null) {
			if(body.getOrario() != ""){	
				for(int i=0;i<annunci.size();i++)
					if(body.getOrario().equalsIgnoreCase(annunci.get(i).getOrario())==false ) {
						annunci.remove(i);
						i--;
						}
			}
		}
		
		//filtro ruolo
		if (body.getRuolo()!=null) {
			if(body.getRuolo() != "") {
				for(int i=0;i<annunci.size();i++)
					if(annunci.get(i).getRuolo().contains(body.getRuolo())==false ) {
						annunci.remove(i);
						i--;
					}
			}
		}
		
		
		//filtro remoto		
		if (body.getRemoto() != null){
			if(body.getRemoto() instanceof Boolean == false) //controllo se ha inserito un booleano
				e.InvalidBody("Remoto è di tipo booleano, inserire true o false"); //se non è un booleano richiamo l'eccezione personalizzata
			if(body.getRemoto() != false) {
				for(int i=0;i<annunci.size();i++)
					if(body.getRemoto() != annunci.get(i).isRemoto()) {
						annunci.remove(i);
						i--;
					}
			} 
		
			if(body.getRemoto() != true) {
				for(int i=0;i<annunci.size();i++)
					if(body.getRemoto() != annunci.get(i).isRemoto()) {
						annunci.remove(i);
						i--;
					}
			}
		}
		
		//filtro data
		if(body.getData() !=null){
			if(body.getData() != ""){
				for(int i=0;i<annunci.size();i++){
					String appoggio=annunci.get(i).getData().substring(0,10);
					if(appoggio.equals(body.getData())==false){
						annunci.remove(i);
						i--;
					}
				}
			}
		}
		
		if(annunci.size()==0) //se non ho trovato nessun annuncio che soddisfa i filtri
			e.BodyResults("Nessun risultato trovato"); //richiamo l'eccezione personalizzata
		
		return annunci;
			
	} // fine metodo

}
