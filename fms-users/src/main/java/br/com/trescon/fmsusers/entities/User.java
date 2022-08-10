package br.com.trescon.fmsusers.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "NICKNAME")
	private String nickName;
	
	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "LASTACCESS")
	private Date lastAccess;
	
	@Column(name = "LASTPASSWORDCHANGE")
	private Date lastPasswordChange;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "LOGINATTEMPT")
	private long loginattempt;
	
	@Column(name = "ACCTNUMBER")
	private String acctNumber;

	@Column(name = "ADVISORID")
	private String advisorId;

	//private Set<TbPasswordHistoric> tbPasswordHistorics = new HashSet<TbPasswordHistoric>(0);

	//MANY TO MANY
	//JOINTABLE
	/*
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "tb_user_role",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private Set<String> roles = new HashSet<>();
	*/
	//private Set<Role> role;
	//private Set<TbUserRole> tbUserRoles = new HashSet<TbUserRole>(0);
	
	public User() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getLoginattempt() {
		return loginattempt;
	}

	public void setLoginattempt(long loginattempt) {
		this.loginattempt = loginattempt;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}
	
}
