package org.jsp.supermarket.dao;

import java.util.Optional;

import org.jsp.supermarket.dto.Customer;
import org.jsp.supermarket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	@Autowired
	CustomerRepository repository;

	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public Customer find(String id) {
		Optional<Customer> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else
			return optional.get();
	}

}
