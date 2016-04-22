package edu.csula.datascience.acquisition;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MovieSource {
	String date;
	
	
	public MovieSource(String date) {
		this.date = date;
	}
	
	public Elements getSource(){
		Elements elements = null;
		try {
			Document doc = Jsoup.connect("http://www.boxofficemojo.com/daily/chart/?view=1day&sortdate="+date).userAgent("Mozilla").get();
			elements = doc.select("#body > center > center > table > tbody > tr:eq(1) > td > table > tbody > tr:gt(0)");
		} catch (IOException e) {
			System.out.println("failed to connect to the source website");
			e.printStackTrace();
		}
		return elements;
	}


}
