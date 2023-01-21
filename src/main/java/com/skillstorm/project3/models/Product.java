package com.skillstorm.project3.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "Product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", updatable=false)
	private int id;
	
	@Column(name = "Nomenclature")
	private String nomenclature;
	
	@Column(name = "Engine_Manufacturer")
	private String engine_manufacturer;

	@Column(name = "In_Stock")
	private int in_stock;

	@Column(name = "Qty")
	private int Qty;

	@Column(name = "Price")
	private int price;

	@Column(name = "Warehouse_id")
	private int Warehouse_id;
	
	@ManyToMany(fetch = FetchType.LAZY, // don't be lazy and use .EAGER
			mappedBy = "aircraft") // name of PROPERTY in the OWNER class
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore
	
	private Set<Aircraft> aircraft;

	public Product() { }

	public Product(String nomenclature, String engine_manufacturer, int in_stock, int Qty, int price, int Warehouse_id ) {
		this.nomenclature = nomenclature;
		this.engine_manufacturer = engine_manufacturer;
		this.in_stock = in_stock;
		this.Qty = Qty;
		this.price= price;
		this.Warehouse_id= Warehouse_id;
		this.aircraft = new HashSet<>();
	}

	public Set<Aircraft> getAircraft() {
		return aircraft;
	} 

	public void setAircraft(Set<Aircraft> aircraft) {
		this.aircraft = aircraft;
	}

	public void addProduct(Aircraft aircraft) {
		this.aircraft.add(aircraft);
	}

	public void removeAircraft(Aircraft aircraft) {
		this.aircraft.remove(aircraft);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWarehouse_id() {
		return Warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		Warehouse_id = warehouse_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nomenclature=" + nomenclature + ", engine_manufacturer=" + engine_manufacturer
				+ ", in_stock=" + in_stock + ", Qty=" + Qty + ", price=" + price + ", Warehouse_id=" + Warehouse_id
				+ ", aircraft=" + aircraft + "]";
	}

	

}
