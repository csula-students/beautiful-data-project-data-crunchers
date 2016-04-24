package edu.csula.datascience.acquisition;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;


public class MovieSource2 {
	private String movie;

	public MovieSource2(String movie) {
		this.movie = movie;
	}
	
	public JSONObject getSource(){
		JSONObject json = null;
		try {
			String year = getYear();
			String mn = year.length() == 0 ? movie.replace(" ", "%20") : movie.substring(0, movie.length()-7);
			String url = "http://www.omdbapi.com/?t="+mn+"&y="+year+"&plot=full&r=json";
			System.out.println(url);
			
            JsonNode response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .asJson()
                .getBody();
            
            json = response.getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException f) {
        	f.printStackTrace();
		}
		return json;
	}

	private String getYear() {
		int open = movie.lastIndexOf("(");
		int close = movie.lastIndexOf(")");
		String year = (open>0) && (close == open + 5)? movie.substring(open+1, close): "";
		year = year.replaceAll("[^0-9]", "");
		return year.length() == 4 ? year : "";
	}
	

}
