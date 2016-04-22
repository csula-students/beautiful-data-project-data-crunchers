package edu.csula.datascience.acquisition;

public class Movie {
	
	private String name;
	private String distributor;
	private Long dailyGross;
	private Long totalGross;
	private Integer daysAftRelease;
	
	public Movie(String name, String distributor,
			Long dailyGross, Long totalGross,
			Integer daysAftRelease) {
		this.name = name;
		this.distributor = distributor;
		this.dailyGross = dailyGross;
		this.totalGross = totalGross;
		this.daysAftRelease = daysAftRelease;
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
