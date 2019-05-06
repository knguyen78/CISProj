package bLogic;

import java.sql.Time;

public class Flight {
	int id;
	String depCity, arrCity;
	Time depTime, arrTime;
	
	public Flight(int id, String depCity, String arrCity, Time depTime, Time arrTime) {
		super();
		this.id = id;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depTime = depTime;
		this.arrTime = arrTime;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}
	

}
