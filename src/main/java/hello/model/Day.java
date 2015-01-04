package hello.model;

import hello.model.util.YNBooleanConverter;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import org.hibernate.annotations.Type;


import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the days database table.
 * 
 */
@Entity
@Table(name="days")
public class Day implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="day_id")
	private Long dayId;
	
	//@Temporal(TemporalType.DATE)
	//@Type(type="org.joda.time.contrib.hibernate.PersistentLocalDate")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate day;

	private String description;

	private String host;

	private String location;

	@Convert(converter=YNBooleanConverter.class)
	private Boolean locked;

	private String menu;


//	enum OccasionType {
//	    MAWAID, MIQAAT;
//	}
//	@Enumerated(EnumType.STRING)
//	
	
	@Column(name="occasion_type")
	private String occasionType;

	private String time;

	//bi-directional many-to-one association to Rsvp
	@OneToMany(mappedBy="day", cascade=CascadeType.ALL)
	private List<Rsvp> rsvps;

	public Day() {
	}
	
	@PrePersist
	protected void init() {
		occasionType = "MAWAID";
		locked = false;
		
	}

	public Long getDayId() {
		return this.dayId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}

	public LocalDate getDay() {
		return this.day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getOccasionType() {
		return this.occasionType;
	}

	public void setOccasionType(String occasionType) {
		this.occasionType = occasionType;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Rsvp> getRsvps() {
		return this.rsvps;
	}

	public void setRsvps(List<Rsvp> rsvps) {
		this.rsvps = rsvps;
	}

	public Rsvp addRsvp(Rsvp rsvp) {
		getRsvps().add(rsvp);
		rsvp.setDay(this);

		return rsvp;
	}

	public Rsvp removeRsvp(Rsvp rsvp) {
		getRsvps().remove(rsvp);
		rsvp.setDay(null);

		return rsvp;
	}

}
