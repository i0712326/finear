package com.fin.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the custtbl database table.
 * 
 */
@Entity
@Table(name="custtbl")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer custid;

	private String address01;

	private BigDecimal balamt;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private Timestamp created;

	private String firstname;

	private String idcard;

	private String lastname;

	private String status;

	private String tel;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="usrid")
	private User usertbl;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="custtbl")
	private List<Loan> loantbls;

	public Customer() {
	}

	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getAddress01() {
		return this.address01;
	}

	public void setAddress01(String address01) {
		this.address01 = address01;
	}

	public BigDecimal getBalamt() {
		return this.balamt;
	}

	public void setBalamt(BigDecimal balamt) {
		this.balamt = balamt;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public User getUsertbl() {
		return this.usertbl;
	}

	public void setUsertbl(User usertbl) {
		this.usertbl = usertbl;
	}

	public List<Loan> getLoantbls() {
		return this.loantbls;
	}

	public void setLoantbls(List<Loan> loantbls) {
		this.loantbls = loantbls;
	}

	public Loan addLoantbl(Loan loantbl) {
		getLoantbls().add(loantbl);
		loantbl.setCusttbl(this);

		return loantbl;
	}

	public Loan removeLoantbl(Loan loantbl) {
		getLoantbls().remove(loantbl);
		loantbl.setCusttbl(null);

		return loantbl;
	}

}