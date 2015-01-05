package hello.model;

import hello.model.util.YNBooleanConverter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;


/**
 * The persistent class for the rsvp database table.
 * 
 */
@Entity
public class Rsvp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rsvp_id")
	private Long rsvpId;

	@Column(name="adult_count")
	private short adultCount;

	@Column(name="child_count")
	private short childCount;

	private String location;

	@Column(name="thali_count")
	private short thaliCount;

	@Column(name="thali_picked")
	@Convert(converter=YNBooleanConverter.class)
	private Boolean thaliPicked;

	@Column(name="thali_size")
	private String thaliSize;

	//bi-directional many-to-one association to Day
	@ManyToOne
	@JoinColumn(name="day_id")
	private Day day;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Rsvp() {
	}
	
	@PrePersist
	protected void init() {
		thaliCount = 0;
		thaliSize = "S";
		thaliPicked = false;
		adultCount = 0;
		childCount = 0;
		
	}


	public Long getRsvpId() {
		return this.rsvpId;
	}

	public void setRsvpId(Long rsvpId) {
		this.rsvpId = rsvpId;
	}

	public short getAdultCount() {
		return this.adultCount;
	}

	public void setAdultCount(short adultCount) {
		this.adultCount = adultCount;
	}

	public short getChildCount() {
		return this.childCount;
	}

	public void setChildCount(short childCount) {
		this.childCount = childCount;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public short getThaliCount() {
		return this.thaliCount;
	}

	public void setThaliCount(short thaliCount) {
		this.thaliCount = thaliCount;
	}

	public Boolean getThaliPicked() {
		return this.thaliPicked;
	}

	public void setThaliPicked(Boolean thaliPicked) {
		this.thaliPicked = thaliPicked;
	}

	public String getThaliSize() {
		return this.thaliSize;
	}

	public void setThaliSize(String thaliSize) {
		this.thaliSize = thaliSize;
	}

	public Day getDay() {
		return this.day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}