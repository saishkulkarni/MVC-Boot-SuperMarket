package org.jsp.supermarket.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.supermarket.dto.Product;
import org.jsp.supermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

	@Autowired
	ProductRepository repository;

	public Product save(Product product) {
		return repository.save(product);
	}

	public Product find(int pid) {
		Optional<Product> optional = repository.findById(pid);
		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;
	}

	public void deleteProduct(int pid) {
		repository.deleteById(pid);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

	public List<Product> fetchCustomerProducts() {
		return repository.findByStatus(true);
	}

	public Product find(String name) {
		return repository.findByName(name);
	}

}
