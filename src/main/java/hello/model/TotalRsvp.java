package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="total_rsvp")

public class TotalRsvp {
	
	@Id
	private String day;
	
	private String menu;
	
	private String location;
	
	@Column(name="thali_count")
	private short thaliCount;
	
	@Column(name="large_thali_count")
	private short largeThaliCount;
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public short getThaliCount() {
		return thaliCount;
	}
	public void setThaliCount(short thaliCount) {
		this.thaliCount = thaliCount;
	}
	public short getLargeThaliCount() {
		return largeThaliCount;
	}
	public void setLargeThaliCount(short largeThaliCount) {
		this.largeThaliCount = largeThaliCount;
	}

	
}
