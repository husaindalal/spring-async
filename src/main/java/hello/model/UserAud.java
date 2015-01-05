package hello.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * The persistent class for the user_aud database table.
 * 
 */
@Entity
@Table(name = "user_aud")
public class UserAud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String action;

	@Column(name = "action_by")
	private String actionBy;

	@Column(name = "action_on", columnDefinition = "TIMESTAMP")
	private Calendar actionOn;

	@Column(name = "email_a")
	private String emailA;

	@Column(name = "email_b")
	private String emailB;

	@Column(name = "name_a")
	private String nameA;

	@Column(name = "name_b")
	private String nameB;

	public UserAud() {
	}

	@PrePersist
	public void prePersist() {
		setAction("I");
		setActionBy("HDI");
		setActionOn(Calendar.getInstance());
	}

	@PreUpdate
	public void preUpdate() {
		setAction("U");
		setActionBy("HDU");
		setActionOn(Calendar.getInstance());
	}

	@PreRemove
	public void preRemove() {
		setAction("D");
		setActionBy("HDD");
		setActionOn(Calendar.getInstance());

	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	protected void setAction(String action) {
		this.action = action;
	}

	public String getActionBy() {
		return this.actionBy;
	}

	protected void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Calendar getActionOn() {
		return this.actionOn;
	}

	protected void setActionOn(Calendar actionOn) {
		this.actionOn = actionOn;
	}

	public String getEmailA() {
		return this.emailA;
	}

	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}

	public String getEmailB() {
		return this.emailB;
	}

	public void setEmailB(String emailB) {
		this.emailB = emailB;
	}

	public String getNameA() {
		return this.nameA;
	}

	public void setNameA(String nameA) {
		this.nameA = nameA;
	}

	public String getNameB() {
		return this.nameB;
	}

	public void setNameB(String nameB) {
		this.nameB = nameB;
	}

}