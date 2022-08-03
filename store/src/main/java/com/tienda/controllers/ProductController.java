package com.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.exceptions.TiendaException;
import com.tienda.json.ProductRest;
import com.tienda.response.TiendaResponse;
import com.tienda.services.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/tienda/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TiendaResponse<ProductRest> getProduct(@PathVariable("id") Long id) throws TiendaException {
		TiendaResponse<ProductRest> res = new TiendaResponse<>("Success", String.valueOf(HttpStatus.OK),
				"Datos de producto", productService.get(id));
		return res;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/producto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TiendaResponse<ProductRest> save(@RequestBody ProductRest product) throws TiendaException {
		boolean canCreate = false;
		try {
			productService.get(product.getId());
		} catch (TiendaException error) {
			canCreate = true;
		}
		if (canCreate) {
			TiendaResponse<ProductRest> res = new TiendaResponse<>("Success", String.valueOf(HttpStatus.OK),
					"Datos de producto", productService.save(product));
			
			return res;
		}
		throw new TiendaException("403", 403, "El producto con ID = " + product.getId() + " ya existe.");
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/productos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TiendaResponse<List<ProductRest>> getProduct() throws TiendaException {
		TiendaResponse<List<ProductRest>> res = new TiendaResponse<>("Success", String.valueOf(HttpStatus.OK),
				"Datos de producto", productService.getAll());
		return res;
	}
}
