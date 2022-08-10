package br.com.trescon.fmsoauth.entities;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String surname;
	private String nickName;
	private String login;
	private String password;
	private int status;
	private Date lastAccess;
	private Date lastPasswordChange;
	private String email;
	private long loginattempt;
	private String acctNumber;
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
