package br.com.als.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.als.ecommerce.entity.ProductEntity;
import br.com.als.ecommerce.repository.ProductsOrdersRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductsOrdersRepositoryImpl repo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	
	public ProductServiceImpl(){}
	
	public void add(ProductEntity p) {

		repo.insert(p);
		
	}

	@Override
	public String listProducts() {
		String productsJson = "[]";
		try {
			productsJson = mapper.writeValueAsString(repo.findAllProducts());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return productsJson;
	}

	@Override
	public String findProduct(Integer id) {
		String productJson = "{}";
		try {
			productJson = mapper.writeValueAsString(repo.findProductById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return productJson;
	}
}
