package hello.json;

import org.joda.time.LocalDate;

public class DayPojo {
	private Long dayId;
	private String day;
	private String occasionType;
	private String menu;
	private Boolean locked;
	
	
	public Long getDayId() {
		return dayId;
	}
	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}
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
	public String getOccasionType() {
		return occasionType;
	}
	public void setOccasionType(String occasionType) {
		this.occasionType = occasionType;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	
}
