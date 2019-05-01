package bLogic;

public class Flights {
	
	private String depCity;
	private String arrCity;
	private String depTime;
	private String arrTime;
	private int maxCapcity;
	private int currentCapcity;
	
	
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public int getMaxCapcity() {
		return maxCapcity;
	}
	public void setMaxCapcity(int maxCapcity) {
		this.maxCapcity = maxCapcity;
	}
	public int getCurrentCapcity() {
		return currentCapcity;
	}
	public void setCurrentCapcity(int current) {
		this.currentCapcity = current;
	}
	
	public Flights(String depCity, String arrCity, String arrTime, String depTime, int maxCapcity, int currentCapcity) {
		
		this.arrCity = arrCity;
		this.arrTime = arrTime;
		this.currentCapcity = currentCapcity;
		this.depCity = depCity;
		this.depTime = depTime;
		this.maxCapcity = maxCapcity;
		
	}
	
	
}
