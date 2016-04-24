package edu.csula.datascience.acquisition;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	
	private String name;
	private String distributor;
	private String dailyGross;
	private String totalGross;
	private String daysAftRelease;
	private String theaterCnt;
	private String theaterPrice;
	private String todayRank;
	private String yesterdayRank;
	private static Set<String> moviesNames = new HashSet<String>();
	
	public Movie(String name, String distributor,
			String dailyGross, String totalGross,
			String daysAftRelease, String theaterCnt, String theaterPrice, String todayRank, String yesterdayRank) {
		this.name = name;
		moviesNames.add(name);
		this.distributor = distributor;
		this.dailyGross = dailyGross;
		this.totalGross = totalGross;
		this.daysAftRelease = daysAftRelease;
		this.theaterCnt = theaterCnt;
		this.theaterPrice = theaterPrice;
		this.todayRank = todayRank;
		this.yesterdayRank = yesterdayRank;
	}
	
	public static Set<String> getMoviesNames(){
		return moviesNames;
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
	public String getDaysAftRelease() {
		return daysAftRelease;
	}
	public void setDaysAftRelease(String daysAftRelease) {
		this.daysAftRelease = daysAftRelease;
	}
	public String getTheaterCnt() {
		return theaterCnt;
	}
	public void setTheaterCnt(String theaterCnt) {
		this.theaterCnt = theaterCnt;
	}
	public String getTheaterPrice() {
		return theaterPrice;
	}
	public void setTheaterPrice(String theaterPrice) {
		this.theaterPrice = theaterPrice;
	}

	public String getTodayRank() {
		return todayRank;
	}

	public void setTodayRank(String todayRank) {
		this.todayRank = todayRank;
	}

	public String getYesterdayRank() {
		return yesterdayRank;
	}

	public void setYesterdayRank(String yesterdayRank) {
		this.yesterdayRank = yesterdayRank;
	}
	
	

}
