package hello.model;

import hello.model.util.YNBooleanConverter;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long userId;

	@Email
	private String email;

	@Convert(converter=YNBooleanConverter.class)
	private Boolean enabled;

	@NotNull
	//@UniqueConstraint
	private String name;

	@NotNull
	private String password;

	//@Phone
	private BigInteger phone1;

	private BigInteger phone2;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;
	
	//bi-directional many-to-one association to Rsvp
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Rsvp> rsvps;

	//bi-directional one-to-one association to UserDefault
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private UserDefault userDefault;



	public User() {
	}
	
	@PrePersist
	protected void init() {
		enabled = true;
		password = "welcome1";
	}


	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getPhone1() {
		return this.phone1;
	}

	public void setPhone1(BigInteger phone1) {
		this.phone1 = phone1;
	}

	public BigInteger getPhone2() {
		return this.phone2;
	}

	public void setPhone2(BigInteger phone2) {
		this.phone2 = phone2;
	}

	public List<Role> getRoles() {
		if(this.roles == null) {
			this.roles = new ArrayList<Role>();
		}
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUser(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUser(null);

		return role;
	}

	
	public List<Rsvp> getRsvps() {
		if(this.rsvps == null) {
			this.rsvps = new ArrayList<Rsvp>();
		}

		return this.rsvps;
	}

	public void setRsvps(List<Rsvp> rsvps) {
		this.rsvps = rsvps;
	}

	public Rsvp addRsvp(Rsvp rsvp) {
		getRsvps().add(rsvp);
		rsvp.setUser(this);

		return rsvp;
	}

	public Rsvp removeRsvp(Rsvp rsvp) {
		getRsvps().remove(rsvp);
		rsvp.setUser(null);

		return rsvp;
	}

	public UserDefault getUserDefault() {
		return this.userDefault;
	}

	public void setUserDefault(UserDefault userDefault) {
		this.userDefault = userDefault;
	}


//	@Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", email='" + email.replaceFirst("@.*", "@***") +
//                ", passwordHash='" + password.substring(0, 10) +
//                ", role=" + role +
//                '}';
//    }
}