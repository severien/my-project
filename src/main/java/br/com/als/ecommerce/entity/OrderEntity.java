package br.com.als.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ORDER")
@JsonIdentityInfo(property="@order", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class OrderEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	
	private Integer id;
	
	@OneToMany
	@JsonManagedReference
	private Set<OrderedProductsEntity> products;

	public OrderEntity() {
		super();
	
	}
	
	public OrderEntity(Set<OrderedProductsEntity> products) {
		super();
		this.products = products;
	}
	
	public OrderEntity(Integer id, Set<OrderedProductsEntity> products) {
		super();
		this.id = id;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<OrderedProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<OrderedProductsEntity> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", products=" + products + "]";
	}
	
	
	
}
