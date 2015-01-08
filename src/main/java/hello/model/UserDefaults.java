package hello.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;


/**
 * The persistent class for the user_defaults database table.
 * 
 */
@Entity
@Table(name="user_defaults")
//@NamedQuery(name="UserDefault.findAll", query="SELECT u FROM UserDefault u")
public class UserDefaults implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="default_id")
	private Long defaultId;

	@Column(name="adult_count")
	private short adultCount;

	@Column(name="child_count")
	private short childCount;

	private String location;

	@Column(name="thali_count")
	private short thaliCount;

	@Column(name="large_thali_count")
	private short largeThaliCount;

	@Column(name="thali_size")
	private String thaliSize;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="userDefault")
	private User user;

	public UserDefaults() {
	}

	@PrePersist
	protected void init() {
		thaliCount = 0;
		largeThaliCount = 0;
		thaliSize = "S";
		adultCount = 0;
		childCount = 0;
		location = "MASJID";
		
	}

	public Long getDefaultId() {
		return this.defaultId;
	}

	public void setDefaultId(Long defaultId) {
		this.defaultId = defaultId;
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

	public short getLargeThaliCount() {
		return largeThaliCount;
	}

	public void setLargeThaliCount(short largeThaliCount) {
		this.largeThaliCount = largeThaliCount;
	}

	public void setThaliCount(short thaliCount) {
		this.thaliCount = thaliCount;
	}

	public String getThaliSize() {
		return this.thaliSize;
	}

	public void setThaliSize(String thaliSize) {
		this.thaliSize = thaliSize;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}