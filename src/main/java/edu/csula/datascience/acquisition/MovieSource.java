package edu.csula.datascience.acquisition;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class MovieSource {
	String date;
	
	public MovieSource(String date) {
		this.date = date;
		Document doc = Jsoup.connect().ignoreContentType(true).userAgent("Mozilla").get();
		//construct the jsoup here to access the page
	}
	
	//T as whatever jsoup return, change it later
	public T getSource(){
		//get the jsoup dom
	}


}
