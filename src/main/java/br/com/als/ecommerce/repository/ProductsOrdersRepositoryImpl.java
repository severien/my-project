package br.com.als.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.als.ecommerce.entity.OrderEntity;
import br.com.als.ecommerce.entity.OrderedProductsEntity;
import br.com.als.ecommerce.entity.ProductEntity;

@Repository
public class ProductsOrdersRepositoryImpl {

//	@PersistenceContext
//	EntityManager em;
	
	@Autowired
	SessionFactory sf;
	
	public ProductsOrdersRepositoryImpl() {}
	
	public void insert(ProductEntity product) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<ProductEntity> findAllProducts() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		Session session = sf.openSession();
		
		session.beginTransaction();
		products.addAll(session.createCriteria(ProductEntity.class).list());
		session.getTransaction().commit();
		session.close();
		
		return products;
		
	}
	
	public ProductEntity findProductById(Integer id) {
		Session session = sf.openSession();
		session.beginTransaction();
		ProductEntity product = (ProductEntity) session.get(ProductEntity.class, id);
		session.getTransaction().commit();
		session.close();
		
		return product;
	}
	
	public void insertOrder(OrderEntity order) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertOrderedProducts(Set<OrderedProductsEntity> orderedProducts) {
		Session session = sf.openSession();
		session.beginTransaction();
		for(OrderedProductsEntity op : orderedProducts) {
			session.save(op);
			
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertOrderedProduct(OrderedProductsEntity orderedProduct) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(orderedProduct);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateOrder(OrderEntity order) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<OrderEntity> findAllOrders() {
		List<OrderEntity> orders = new ArrayList<>();
		Session session = sf.openSession();
		session.beginTransaction();
		orders.addAll(session.createCriteria(OrderEntity.class).list());
		session.getTransaction().commit();
		session.close();
		
		return orders;
	}
	
	public OrderEntity findOrderById(Integer id) {
		Session session = sf.openSession();
		session.beginTransaction();
		OrderEntity order = (OrderEntity) session.get(OrderEntity.class, id);
		session.getTransaction().commit();
		session.close();
		
		return order;
	}
	
}
