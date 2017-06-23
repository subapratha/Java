package com.welcome.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.welcome.customer.dao.impl.JdbcCustomerDAO;
import com.welcome.customer.model.Customer;
public class App {
	


	
	    public static void main( String[] args )
	    {
	    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");

	    	JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) context.getBean("customerDAO");
	        Customer customer = new Customer(1, "PSG",28);
	        customerDAO.insert(customer);

	        Customer customer1 = customerDAO.findByCustomerId(1);
	        System.out.println(customer1);

	    }
	
}
