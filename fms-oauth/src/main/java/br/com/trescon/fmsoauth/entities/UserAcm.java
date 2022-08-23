package br.com.trescon.fmsoauth.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class UserAcm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "FIRSTNAME", nullable = false, length = 45)
	private String firstName;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "NICKNAME")
	private String nickName;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "LASTACCESS")
	private Date lastAccess;
	
	@Column(name = "LASTPASSWORDCHANGE")
	private Date lastPasswordChange;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "LOGINATTEMPT")
	private Long loginattempt;
	
	@Column(name = "ACCTNUMBER")
	private String acctNumber;
	
	@Column(name = "ADVISORID")
	private String advisorId;
	
	//private Set<TbPasswordHistoric> tbPasswordHistorics = new HashSet<TbPasswordHistoric>(0);
	//private Set<TbUserRole> tbUserRoles = new HashSet<TbUserRole>(0);

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Long getLoginattempt() {
		return loginattempt;
	}

	public void setLoginattempt(Long loginattempt) {
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
