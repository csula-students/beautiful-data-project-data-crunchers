package edu.csula.datascience.acquisition;



public class MovieSource implements Source<Movie>{
	String date;
	
	public MovieSource(String date) {
		this.date = date;
		//construct the jsoup here to access the page
	}
	
	//T as whatever jsoup return, change it later
	public T getSource(){
		//get the jsoup dom
	}


}
