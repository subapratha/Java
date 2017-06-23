package com.customer.dao;
import com.customer.model.customer;
public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
