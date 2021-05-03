package com.fin.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the schetbl database table.
 * 
 */
@Entity
@Table(name="schetbl")
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer schid;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private BigDecimal iamt;

	@Temporal(TemporalType.DATE)
	private Date paiddate;

	private BigDecimal pamt;

	private String status;

	//bi-directional many-to-one association to Loan
	@ManyToOne
	@JoinColumn(name="loanid")
	private Loan loantbl;

	public Schedule() {
	}

	public Integer getSchid() {
		return this.schid;
	}

	public void setSchid(Integer schid) {
		this.schid = schid;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public BigDecimal getIamt() {
		return this.iamt;
	}

	public void setIamt(BigDecimal iamt) {
		this.iamt = iamt;
	}

	public Date getPaiddate() {
		return this.paiddate;
	}

	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
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

	public Loan getLoantbl() {
		return this.loantbl;
	}

	public void setLoantbl(Loan loantbl) {
		this.loantbl = loantbl;
	}

}