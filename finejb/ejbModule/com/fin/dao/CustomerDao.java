package com.fin.dao;

import java.util.List;

import javax.ejb.Local;

import com.fin.entity.Customer;

@Local
public interface CustomerDao {
	public void save(Customer customer) throws Exception;
	public Customer getCustomer(long id) throws Exception;
	public List<Customer> getCustomers(Customer customer,int first, int max) throws Exception;
}
