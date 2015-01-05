package hello.json;

import java.util.List;

public class WeekRsvpPojo {
	private String weekId;
	private String week;
	private List<RsvpPojo> rsvps;
	
	
	public String getWeekId() {
		return weekId;
	}
	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public List<RsvpPojo> getRsvps() {
		return rsvps;
	}
	public void setRsvps(List<RsvpPojo> rsvps) {
		this.rsvps = rsvps;
	}

	
}
