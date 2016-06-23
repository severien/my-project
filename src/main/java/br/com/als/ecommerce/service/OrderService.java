package br.com.als.ecommerce.service;

import java.util.List;
import java.util.Set;

import br.com.als.ecommerce.entity.OrderEntity;
import br.com.als.ecommerce.vo.ProductsOrderVO;

public interface OrderService {

	void placeOrder(Set<ProductsOrderVO> productsOrder);

	void modifyOrder(OrderEntity order);

	List<OrderEntity> listOrders();

	OrderEntity findOrder(Integer id);

}