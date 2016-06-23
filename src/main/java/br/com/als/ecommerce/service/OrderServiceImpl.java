package br.com.als.ecommerce.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.als.ecommerce.entity.OrderEntity;
import br.com.als.ecommerce.entity.OrderedProductsEntity;
import br.com.als.ecommerce.entity.ProductEntity;
import br.com.als.ecommerce.repository.ProductsOrdersRepositoryImpl;
import br.com.als.ecommerce.vo.ProductsOrderVO;

@Service
public class OrderServiceImpl implements OrderService {

	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	ProductsOrdersRepositoryImpl repo;
	
	public OrderServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see br.com.als.ecommerce.service.OrderService#placeOrder(br.com.als.ecommerce.entity.OrderEntity)
	 */
	@Override
	public void placeOrder(Set<ProductsOrderVO> productsOrder) {
		OrderEntity order = new OrderEntity();
		Set<OrderedProductsEntity> orderedProductsEntities = new HashSet<>();
		for(ProductsOrderVO item : productsOrder) {
			ProductEntity product = repo.findProductById(item.getProductId());
			OrderedProductsEntity orderedProduct = new OrderedProductsEntity(order, product, item.getQuantity());
//			repo.insertOrderedProduct(orderedProduct);
			orderedProductsEntities.add(orderedProduct);
		}
		order.setProducts(orderedProductsEntities);
		logger.info("Placing order {}",order);
		repo.insertOrder(order);
	}
	
	/* (non-Javadoc)
	 * @see br.com.als.ecommerce.service.OrderService#modifyOrder(br.com.als.ecommerce.entity.OrderEntity)
	 */
	@Override
	public void modifyOrder(OrderEntity order) {
		repo.updateOrder(order);
	}
	
	/* (non-Javadoc)
	 * @see br.com.als.ecommerce.service.OrderService#listOrders()
	 */
	@Override
	@Transactional
	public List<OrderEntity> listOrders() {
		return repo.findAllOrders();
	}
	
	/* (non-Javadoc)
	 * @see br.com.als.ecommerce.service.OrderService#findOrder(java.lang.Integer)
	 */
	@Override
	public OrderEntity findOrder(Integer id) {
		return repo.findOrderById(id);
	}
}
