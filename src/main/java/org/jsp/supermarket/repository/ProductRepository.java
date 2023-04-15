package org.jsp.supermarket.repository;

import java.util.List;

import org.jsp.supermarket.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByStatus(boolean b);

	Product findByName(String name);

}
