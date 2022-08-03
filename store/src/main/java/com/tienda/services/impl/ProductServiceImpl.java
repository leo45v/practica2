package com.tienda.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.Product;
import com.tienda.exceptions.NotFoundException;
import com.tienda.exceptions.TiendaException;
import com.tienda.json.ProductRest;
import com.tienda.repositories.ProductRepository;
import com.tienda.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	public static final ModelMapper mapper = new ModelMapper();

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductRest get(Long id) throws TiendaException {
		Product productResult = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("PRODUCTO NO ENCONTRADO", 500, "No existe el producto"));

		return mapper.map(productResult, ProductRest.class);
	}

	@Override
	public void test() throws TiendaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductRest save(ProductRest product) throws TiendaException {
		Product productResult = productRepository.save(mapper.map(product, Product.class));
		
		return mapper.map(productResult, ProductRest.class);
	}

	@Override
	public List<ProductRest> getAll() throws TiendaException {
		List<Product> products = productRepository.findAll();
		
		return products.stream().map(p -> mapper.map(p, ProductRest.class)).toList();
	}
}
