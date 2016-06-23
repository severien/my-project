package br.com.als.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(property = "@id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name="ORDERED_PRODUCTS")
public class OrderedProductsEntity implements Serializable {

	private static final long serialVersionUID = 759187809066566896L;

	@Id
	private Integer id;
	private ProductEntity product;
	@JsonBackReference
	private OrderEntity order;
	// private OrderedProductsPK orderedProductsPK;
	private Integer productQuantity;

	public OrderedProductsEntity() {
		super();
	}

	public OrderedProductsEntity(ProductEntity product, Integer productQuantity) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
	}
	
	public OrderedProductsEntity(OrderEntity order, ProductEntity product, Integer productQuantity) {
		super();
		this.order = order;
		this.product = product;
		this.productQuantity = productQuantity;
	}

	// public OrderedProductsEntity(ProductEntity product, OrderEntity order,
	// Integer productQuantity) {
	// super();
	// this.orderedProductsPK = new OrderedProductsPK(product, order);
	// this.productQuantity = productQuantity;
	// }

	// public OrderedProductsPK getOrderedProductsPK() {
	// return orderedProductsPK;
	// }
	// public void setOrderedProductsPK(OrderedProductsPK orderedProductsPK) {
	// this.orderedProductsPK = orderedProductsPK;
	// }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	
	
	@Override
	public String toString() {
		return "OrderedProductsEntity [id=" + id + ", product=" + product + ", productQuantity=" + productQuantity
				+ "]";
	}

	
}
