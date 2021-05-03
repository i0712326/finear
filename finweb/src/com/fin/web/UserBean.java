package com.fin.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String position;
	private String department;
	
	
	public void action() {
		this.setName("adjust ** "+name);
		this.setPosition("adjust ** "+position);
		this.setDepartment("adjust ** "+department);
	}
	
	public void errorAction() throws Exception{
		
		throw new Exception("Test Error !!!!");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
