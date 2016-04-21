package edu.csula.datascience.acquisition;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class MovieSource {
	String date;
	
	
	public MovieSource(String date) {
		this.date = date;
	}
	
	public Elements getSource(){
		try {
			System.out.println("http://www.the-numbers.com/box-office-chart/daily/"+date);
			Document doc = Jsoup.connect("http://www.the-numbers.com/box-office-chart/daily/"+date).ignoreContentType(true).userAgent("Mozilla").get();
			Element element = doc.getElementById("page_filling_chart");
			System.out.println(element.html());
		} catch (IOException e) {
			System.out.println("failed to connect to the source website");
			e.printStackTrace();
		}
		//return element with tag <tr></tr>
		return null;
	}


}
