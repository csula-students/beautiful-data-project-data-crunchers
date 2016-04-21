package edu.csula.datascience.acquisition;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class MovieSource {
	String date;
	Element element;
	
	
	public MovieSource(String date) {
		this.date = date;
		
		try {
			Document doc = Jsoup.connect("http://www.the-numbers.com/box-office-chart/daily/"+date).ignoreContentType(true).userAgent("Mozilla").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//construct the jsoup here to access the page
	}
	
	public Elements getSource(){
		//return element with tag <tr></tr>
		return null;
	}


}
