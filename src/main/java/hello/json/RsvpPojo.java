package hello.json;


public class RsvpPojo {
	private Long rsvpId;
	private String day;
	private String menu;
	private short thaliCount;
	private String thaliSize;
	private String location;
	private Boolean thaliPicked;
	
	
	public Long getRsvpId() {
		return rsvpId;
	}
	public void setRsvpId(Long rsvpId) {
		this.rsvpId = rsvpId;
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
	public short getThaliCount() {
		return thaliCount;
	}
	public void setThaliCount(short thaliCount) {
		this.thaliCount = thaliCount;
	}
	public String getThaliSize() {
		return thaliSize;
	}
	public void setThaliSize(String thaliSize) {
		this.thaliSize = thaliSize;
	}
	public Boolean getThaliPicked() {
		return thaliPicked;
	}
	public void setThaliPicked(Boolean thaliPicked) {
		this.thaliPicked = thaliPicked;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
}
