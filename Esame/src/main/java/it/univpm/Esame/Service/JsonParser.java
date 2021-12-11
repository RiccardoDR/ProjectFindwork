package it.univpm.Esame.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.Esame.FindWorkApi.FindWorkApi;
import it.univpm.Esame.Model.Lavoro;

	/**
	 * Classe che utilizziamo per la gestione del JSON, ovvero
	 * del parsing e del suo salvataggio su file 
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */

@Service
public class JsonParser {
	
	/**
	 * Metodo che effettua il parsing del JSON ottenuto dalla chiamata API
	 * @return ArrayList<Lavoro>
	 * @throws IOException
	 * @throws JSONException
	 */
	
	public  ArrayList<Lavoro> Parsing() throws IOException,JSONException{
		
		JSONObject parser=FindWorkApi.JSONDownloader();
		JSONArray data= parser.getJSONArray("results");
	
		ArrayList<Lavoro> annunci = new ArrayList<Lavoro>();
	
		for(int i=0;i<data.length();i++) {
			
			Lavoro annuncio = new Lavoro();
			JSONObject tmp = data.getJSONObject(i);
			
			annuncio.setId( tmp.getInt("id") );
			annuncio.setAzienda(tmp.getString("company_name"));
			annuncio.setRemoto(tmp.getBoolean("remote"));
			annuncio.setLuogo(tmp.get("location").toString());
			annuncio.setOrario(tmp.get("employment_type").toString());
			annuncio.setRuolo(tmp.getString("role"));
			annuncio.setKeyword(tmp.getJSONArray("keywords"));
			annuncio.setData(tmp.getString("date_posted"));
			annunci.add(annuncio);
			 
		} // fine for
		
		JsonParser.Save(annunci);
		return annunci;
		
	} //fine metodo
	
	
	/**
	 * metodo utilizzato per salvare il json contenente gli annunci su un file
	 * @param ArrayList<Lavoro>
	 */
	private static void Save(ArrayList<Lavoro> annunci) {
		try {
			JSONObject obj = new JSONObject();
			FileWriter fileW = new FileWriter("txtdocs/"+"lista_annunci.txt");
			for (Lavoro lavoro : annunci) {
				obj.put("id", lavoro.getId());
				obj.put("comapny_name", lavoro.getAzienda());
				obj.put("date_posted", lavoro.getData());
				obj.put("keywords", lavoro.getKeyword());
				obj.put("location", lavoro.getLuogo());
				obj.put("employment_type", lavoro.getOrario());
				obj.put("role", lavoro.getRuolo());
				fileW.write(obj.toString()+"\n");
			}
			fileW.close(); 
		}catch(IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato");
		}
	}
	
}
