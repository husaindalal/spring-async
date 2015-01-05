package hello.json;

import java.util.List;

public class WeekDayPojo {
	private String weekId;
	private String week;
	private List<DayPojo> days;
	
	
	public String getWeekId() {
		return weekId;
	}
	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}
	public List<DayPojo> getDays() {
		return days;
	}
	public void setDays(List<DayPojo> days) {
		this.days = days;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	
	
}
