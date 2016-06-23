package br.com.als.ecommerce;

import org.glassfish.jersey.server.ResourceConfig;

import br.com.als.ecommerce.resource.OrderResource;
import br.com.als.ecommerce.resource.ProductResource;

public class ECommerceApplication extends ResourceConfig {

	public ECommerceApplication() {
		register(ProductResource.class);
		register(OrderResource.class);
	}
	
}
