package edu.csula.datascience.acquisition;

public class Movie {
	
	private String name;
	private String distributor;
	private String dailyGross;
	private String totalGross;
	private Integer daysAftRelease;
	private Integer theaterCnt;
	private String theaterPrice;
	
	public Movie(String name, String distributor,
			String dailyGross, String totalGross,
			Integer daysAftRelease, Integer theaterCnt, String theaterPrice) {
		this.name = name;
		this.distributor = distributor;
		this.dailyGross = dailyGross;
		this.totalGross = totalGross;
		this.daysAftRelease = daysAftRelease;
		this.setTheaterCnt(theaterCnt);
		this.setTheaterPrice(theaterPrice);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public String getDailyGross() {
		return dailyGross;
	}
	public void setDailyGross(String dailyGross) {
		this.dailyGross = dailyGross;
	}
	public String getTotalGross() {
		return totalGross;
	}
	public void setTotalGross(String totalGross) {
		this.totalGross = totalGross;
	}
	public Integer getDaysAftRelease() {
		return daysAftRelease;
	}
	public void setDaysAftRelease(Integer daysAftRelease) {
		this.daysAftRelease = daysAftRelease;
	}
	public Integer getTheaterCnt() {
		return theaterCnt;
	}
	public void setTheaterCnt(Integer theaterCnt) {
		this.theaterCnt = theaterCnt;
	}
	public String getTheaterPrice() {
		return theaterPrice;
	}
	public void setTheaterPrice(String theaterPrice) {
		this.theaterPrice = theaterPrice;
	}
	
	

}
