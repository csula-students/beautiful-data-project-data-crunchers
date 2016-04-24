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
            JsonNode response = Unirest.post("http://www.omdbapi.com/?t"+movie+"&y="+year+"&plot=full&r=json")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .asJson()
                .getBody();
            
            json = response.getObject();
        } catch (UnirestException e) {
            throw new IllegalStateException("Server may not be up and running.", e);
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
