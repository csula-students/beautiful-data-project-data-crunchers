package edu.csula.datascience.acquisition;

public class SimpleModel2 {
	
	private final String movieName;
	private final String distributor;
	private final String dailyGross;
	private final String totalGross;
	
	public SimpleModel2(String movieName,String distributor,String dailyGross,String totalGross){
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

	public static SimpleModel2 build(MockData2 data) {
        return new SimpleModel2(data.getMovieName(), data.getDistributor(),data.getDailyGross(),data.getTotalGross());
    }	

}
