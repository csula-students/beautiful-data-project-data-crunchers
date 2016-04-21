package edu.csula.datascience.acquisition;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class MovieSource {
	String date;
	Element element;
	
	
	public MovieSource(String date) {
		this.date = date;
		Document doc = Jsoup.connect().ignoreContentType(true).userAgent("Mozilla").get();
		this.element = doc.getElementById("page_filling_chart");
		//construct the jsoup here to access the page
	}
	
	public Elements getSource(){
		//return element with tag <tr></tr>
		return null;
	}


}
