package com.fin.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.fin.entity.Customer;

/**
 * Session Bean implementation class CustomerDaoImp
 */
@Stateless(mappedName = "customerDao")
public class CustomerDaoImp implements CustomerDao {
	@PersistenceContext(unitName="finjpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
	
    public CustomerDaoImp() {
        super();
    }
    @Transactional
    @Override
    public void save(Customer customer) throws Exception {
    	try {
    	em.persist(customer);
    	}catch(Exception exp) {
    		throw new Exception();
    	}
    }
    
    @Override
    public Customer getCustomer(long id) throws Exception{
    	try {
    	String sql ="from Customer c where c.custid = :id";
    	TypedQuery<Customer> query = em.createQuery(sql, Customer.class);
    	query.setParameter("id", id);
    	return query.getSingleResult();
    	}catch(Exception ex) {
    		return null;
    	}
    }
	@Override
	public List<Customer> getCustomers(Customer customer, int first, int max) throws Exception {
		String sql ="";
		
		TypedQuery<Customer> query = em.createQuery(sql,Customer.class);
		//query.setParameter(arg0, arg1)
		return null;
	}

}
