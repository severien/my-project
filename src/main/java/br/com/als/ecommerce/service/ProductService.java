package br.com.als.ecommerce.service;

import br.com.als.ecommerce.entity.ProductEntity;

public interface ProductService {
	
	void add(ProductEntity p);
	
	String listProducts();
	String findProduct(Integer id);
}