package hello.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_calc database table.
 * 
 */
@Entity
@Table(name="user_calc")
public class UserCalc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Version
	@Column(name="action_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	private Timestamp actionOn;

	@Column(name="name_email")
	private String nameEmail;

	public UserCalc() {
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public Timestamp getActionOn() {
		return this.actionOn;
	}

	public void setActionOn(Timestamp actionOn) {
		this.actionOn = actionOn;
	}

	public String getNameEmail() {
		return this.nameEmail;
	}

	public void setNameEmail(String nameEmail) {
		this.nameEmail = nameEmail;
	}

}