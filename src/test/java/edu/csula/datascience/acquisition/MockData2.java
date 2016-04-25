package edu.csula.datascience.acquisition;

public class MockData2 {
	
	private String movieName;
	private String distributor;
	private String dailyGross;
	private String totalGross;
	
	public MockData2(String movieName, String distributor, String dailyGross, String totalGross) {
		this.movieName = movieName;
		this.distributor = distributor;
		this.dailyGross = dailyGross;
		this.totalGross = totalGross;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public String getDistributor() {
		return distributor;
	}
	public String getDailyGross() {
		return dailyGross;
	}
	public String getTotalGross() {
		return totalGross;
	}

	
	
	

}
