package org.jsp.supermarket.repository;

import org.jsp.supermarket.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
