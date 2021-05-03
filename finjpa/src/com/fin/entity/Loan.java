package com.fin.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the loantbl database table.
 * 
 */
@Entity
@Table(name="loantbl")
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer loanid;

	@Temporal(TemporalType.DATE)
	private Date closedate;

	private Timestamp created;

	private String curr;

	private BigDecimal finamt;

	private BigDecimal iamt;

	private BigDecimal irate;

	@Temporal(TemporalType.DATE)
	private Date opendate;

	private BigDecimal pamt;

	private String status;

	private Integer term;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="custid")
	private Customer custtbl;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="usrid")
	private User usertbl;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="loantbl")
	private List<Schedule> schetbls;

	public Loan() {
	}

	public Integer getLoanid() {
		return this.loanid;
	}

	public void setLoanid(Integer loanid) {
		this.loanid = loanid;
	}

	public Date getClosedate() {
		return this.closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCurr() {
		return this.curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public BigDecimal getFinamt() {
		return this.finamt;
	}

	public void setFinamt(BigDecimal finamt) {
		this.finamt = finamt;
	}

	public BigDecimal getIamt() {
		return this.iamt;
	}

	public void setIamt(BigDecimal iamt) {
		this.iamt = iamt;
	}

	public BigDecimal getIrate() {
		return this.irate;
	}

	public void setIrate(BigDecimal irate) {
		this.irate = irate;
	}

	public Date getOpendate() {
		return this.opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public BigDecimal getPamt() {
		return this.pamt;
	}

	public void setPamt(BigDecimal pamt) {
		this.pamt = pamt;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Customer getCusttbl() {
		return this.custtbl;
	}

	public void setCusttbl(Customer custtbl) {
		this.custtbl = custtbl;
	}

	public User getUsertbl() {
		return this.usertbl;
	}

	public void setUsertbl(User usertbl) {
		this.usertbl = usertbl;
	}

	public List<Schedule> getSchetbls() {
		return this.schetbls;
	}

	public void setSchetbls(List<Schedule> schetbls) {
		this.schetbls = schetbls;
	}

	public Schedule addSchetbl(Schedule schetbl) {
		getSchetbls().add(schetbl);
		schetbl.setLoantbl(this);

		return schetbl;
	}

	public Schedule removeSchetbl(Schedule schetbl) {
		getSchetbls().remove(schetbl);
		schetbl.setLoantbl(null);

		return schetbl;
	}

}