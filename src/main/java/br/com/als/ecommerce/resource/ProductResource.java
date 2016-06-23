package br.com.als.ecommerce.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.als.ecommerce.entity.ProductEntity;
import br.com.als.ecommerce.service.ProductService;

@Path("/product")
public class ProductResource {

	@Autowired
	ProductService service;

	// @RequestMapping("/hello")
	@PUT
	@Produces("application/json")
	@Path("/add")
	public String hello(ProductEntity p) {
		
		service.add(p);
		return "{\"status\":\"porra\"}";
	}

	@GET
	@Produces("application/json")
	@Path("/list")
	public String listProductCatalog() {
		return service.listProducts();
	}

	@GET
	@Produces("application/json")
	@Path("/{id}")
	public String findProduct(@PathParam("id") Integer id) {
		 return service.findProduct(id);
	}
}
