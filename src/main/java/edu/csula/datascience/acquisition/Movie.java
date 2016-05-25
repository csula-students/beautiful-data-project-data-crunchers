package edu.csula.datascience.acquisition;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	
	private String name;
	private String distributor;
	private Long dailyGross;
	private Long totalGross;
	private Integer daysAftRelease;
	private String todayRank;
	private String yesterdayRank;
	private String date;
	private static Set<String> moviesNames = new HashSet<String>();
	
	public Movie(String name, String distributor,
			String dailyGross, String totalGross,
			String daysAftRelease, String todayRank, String yesterdayRank, String date) {
		try{
			this.name = name;
			moviesNames.add(name);
			this.distributor = distributor;
			this.dailyGross = Long.parseLong(dailyGross);
			this.totalGross = Long.parseLong(totalGross);
			this.daysAftRelease = Integer.parseInt(daysAftRelease);
			this.todayRank = todayRank;
			this.yesterdayRank = yesterdayRank;
			this.date = date;
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public Long getDailyGross() {
		return dailyGross;
	}
	public void setDailyGross(long dailyGross) {
		this.dailyGross = dailyGross;
	}
	public Long getTotalGross() {
		return totalGross;
	}
	public void setTotalGross(long totalGross) {
		this.totalGross = totalGross;
	}
	public Integer getDaysAftRelease() {
		return daysAftRelease;
	}
	public void setDaysAftRelease(int daysAftRelease) {
		this.daysAftRelease = daysAftRelease;
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
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		return date;
	}

}
