package com.fin.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the roletbl database table.
 * 
 */
@Entity
@Table(name="roletbl")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer roleid;

	private Timestamp createdate;

	private String roledesc;

	private String rolename;

	private String status;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roletbls")
	private List<User> usertbls;

	public Role() {
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getRoledesc() {
		return this.roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<User> getUsertbls() {
		return this.usertbls;
	}

	public void setUsertbls(List<User> usertbls) {
		this.usertbls = usertbls;
	}

}