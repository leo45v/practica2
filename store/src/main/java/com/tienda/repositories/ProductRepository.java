package com.tienda.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tienda.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();

	Product getById(Long id);

	Optional<Product> findById(Long id);

	@Modifying
	@Transactional
	@Query(value = "update product set name='chocolate' where id = 1", nativeQuery = true)
	public Product updateProduct(Product product);

	@Modifying
	@Transactional
	Product deleteByName(String name);
}
