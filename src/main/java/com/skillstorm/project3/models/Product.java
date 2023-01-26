package com.skillstorm.project3.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;



@Entity
@Table (name = "product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "nomenclature")
	private String nomenclature;
	
	@Column(name = "engine_manufacturer")
	private String engine_manufacturer;

	@Column(name = "in_stock")
	private int in_stock;

	@Column(name = "qty")
	private int qty;

	@Column(name = "price")
	private String price;

	@Column(name = "warehouse_id")
	private String warehouse_id;
	

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private Set<Inventory> inventory;

	public Product() { }

	public Product(String nomenclature, String engine_manufacturer, int in_stock, int qty, String price, String warehouse_id ) {
		this.nomenclature = nomenclature;
		this.engine_manufacturer = engine_manufacturer;
		this.in_stock = in_stock;
		this.qty = qty;
		this.price= price;
		this.warehouse_id= warehouse_id;
		this.inventory = new HashSet<>();
	}

	public Set<Inventory> getInventory() { 
		return inventory;
	} 

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	public void addInventory(Inventory inventory) {
		this.inventory.add(inventory);
	}

	public void removeInventory(Inventory inventory) {
		this.inventory.remove(inventory);
	}


	public Product(int i, String string, String string2, int j, int k, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return product_id;
	}

	public void setId(int id) {
		this.product_id = id;
	}

	public String getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public String getEngine_manufacturer() {
		return engine_manufacturer;
	}

	public void setEngine_manufacturer(String engine_manufacturer) {
		this.engine_manufacturer = engine_manufacturer;
	}

	public int getIn_stock() {
		return in_stock;
	}

	public void setIn_stock(int in_stock) {
		this.in_stock = in_stock;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getwarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", nomenclature=" + nomenclature + ", engine_manufacturer=" + engine_manufacturer
				+ ", in_stock=" + in_stock + ", qty=" + qty + ", price=" + price + ", Warehouse_id=" + warehouse_id
				+ "]";
	}

	

}
