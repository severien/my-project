package br.com.als.ecommerce.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.als.ecommerce.entity.OrderEntity;
import br.com.als.ecommerce.entity.OrderedProductsEntity;
import br.com.als.ecommerce.entity.ProductEntity;
import br.com.als.ecommerce.service.OrderService;
import br.com.als.ecommerce.vo.ProductsOrderVO;

@Path("/order")
public class OrderResource {

	private static Logger logger = LoggerFactory.getLogger(OrderResource.class);

	@Autowired
	private OrderService service;
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/place")
	public ResponseEntity<String> placeOrder(Set<ProductsOrderVO> orderedProducts) {
		logger.info("Placing order {}", orderedProducts.toString());
		service.placeOrder(orderedProducts);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/modify/{id}")
	public ResponseEntity<String> modifyOrder(@PathParam("id") Integer id, OrderEntity order) {
		order.setId(id);
		service.modifyOrder(order);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GET
	@Produces("application/json")
	@Path("/list")
	public ResponseEntity<List<OrderEntity>> listOrders() {
		List<OrderEntity> list = service.listOrders();
		logger.info("",list.toString());
		return new ResponseEntity<List<OrderEntity>>(list, HttpStatus.OK);
	}

	@GET
	@Produces("application/json")
	@Path("/find/{id}")
	public ResponseEntity<OrderEntity> findOrder(@PathParam("id") Integer id) {
		OrderEntity order = service.findOrder(id);
		logger.info("Order {}",order.toString());
		return new ResponseEntity<OrderEntity>(order, HttpStatus.OK);
	}

}
