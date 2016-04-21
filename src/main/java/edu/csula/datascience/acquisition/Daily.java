package edu.csula.datascience.acquisition;

import java.util.Date;

public class Daily {
	
	private Date currentDate;
	private String movieName;
	private String distributor;
	private Integer changePercent;
	private Long dailyGross;
	private Long totalGross;
	private Integer daysAftRelease;
	
	public Daily(Date currentDate, String movieName, String distributor,
			Integer changePercent, Long dailyGross, Long totalGross,
			Integer daysAftRelease) {
		this.currentDate = currentDate;
		this.movieName = movieName;
		this.distributor = distributor;
		this.changePercent = changePercent;
		this.dailyGross = dailyGross;
		this.totalGross = totalGross;
		this.daysAftRelease = daysAftRelease;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public Integer getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(Integer changePercent) {
		this.changePercent = changePercent;
	}
	public Long getDailyGross() {
		return dailyGross;
	}
	public void setDailyGross(Long dailyGross) {
		this.dailyGross = dailyGross;
	}
	public Long getTotalGross() {
		return totalGross;
	}
	public void setTotalGross(Long totalGross) {
		this.totalGross = totalGross;
	}
	public Integer getDaysAftRelease() {
		return daysAftRelease;
	}
	public void setDaysAftRelease(Integer daysAftRelease) {
		this.daysAftRelease = daysAftRelease;
	}
	
	

}
