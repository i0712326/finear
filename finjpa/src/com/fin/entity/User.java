package com.fin.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usertbl database table.
 * 
 */
@Entity
@Table(name="usertbl")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer userid;

	private Timestamp createdate;

	private String firstname;

	private String lastname;

	private String passwd;

	private String status;

	private String username;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="usertbl")
	private List<Customer> custtbls;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="usertbl")
	private List<Loan> loantbls;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="usr_role_tbl"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleid")
			}
		)
	private List<Role> roletbls;

	public User() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Customer> getCusttbls() {
		return this.custtbls;
	}

	public void setCusttbls(List<Customer> custtbls) {
		this.custtbls = custtbls;
	}

	public Customer addCusttbl(Customer custtbl) {
		getCusttbls().add(custtbl);
		custtbl.setUsertbl(this);

		return custtbl;
	}

	public Customer removeCusttbl(Customer custtbl) {
		getCusttbls().remove(custtbl);
		custtbl.setUsertbl(null);

		return custtbl;
	}

	public List<Loan> getLoantbls() {
		return this.loantbls;
	}

	public void setLoantbls(List<Loan> loantbls) {
		this.loantbls = loantbls;
	}

	public Loan addLoantbl(Loan loantbl) {
		getLoantbls().add(loantbl);
		loantbl.setUsertbl(this);

		return loantbl;
	}

	public Loan removeLoantbl(Loan loantbl) {
		getLoantbls().remove(loantbl);
		loantbl.setUsertbl(null);

		return loantbl;
	}

	public List<Role> getRoletbls() {
		return this.roletbls;
	}

	public void setRoletbls(List<Role> roletbls) {
		this.roletbls = roletbls;
	}

}