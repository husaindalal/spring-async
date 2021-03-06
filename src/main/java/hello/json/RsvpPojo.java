package hello.json;


public class RsvpPojo {
	private Long rsvpId;
	private String day;
	private String menu;
	private short thaliCount;
	private short largeThaliCount;
	private String thaliSize;
	private String location;
	private Boolean thaliPicked;
	
	private short adultCount;
	private short childCount;
	
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
	
	public short getLargeThaliCount() {
		return largeThaliCount;
	}
	public void setLargeThaliCount(short largeThaliCount) {
		this.largeThaliCount = largeThaliCount;
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
	public short getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(short adultCount) {
		this.adultCount = adultCount;
	}
	public short getChildCount() {
		return childCount;
	}
	public void setChildCount(short childCount) {
		this.childCount = childCount;
	}

	
}
