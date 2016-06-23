package br.com.als.ecommerce.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class OrderedProductsPK implements Serializable {

	private static final long serialVersionUID = 429621812755771720L;

	@JsonBackReference
	private ProductEntity product;
	@JsonBackReference
	private OrderEntity order;

	public OrderedProductsPK() {
	}

	public OrderedProductsPK(ProductEntity product, OrderEntity order) {
		super();
		this.product = product;
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedProductsPK other = (OrderedProductsPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (order.getId() != other.order.getId())
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (product.getId() == other.product.getId())
			return false;
		return true;
	}

	

}
