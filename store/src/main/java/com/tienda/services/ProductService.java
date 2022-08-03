package com.tienda.services;

import java.util.List;

import com.tienda.exceptions.TiendaException;
import com.tienda.json.ProductRest;

public interface ProductService {
	
	ProductRest get(Long id) throws TiendaException;
	ProductRest save(ProductRest product) throws TiendaException;
	List<ProductRest> getAll() throws TiendaException;
	
	void test() throws TiendaException;
	
}
