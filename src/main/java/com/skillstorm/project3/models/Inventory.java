package com.skillstorm.project3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "inventory")

public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id", updatable=false)
	private int id;

	@Column(name = "warehouse_id")
	private String warehouse_id;

	@Column(name = "part_id")
	private int part_id;

	@Column(name = "nomenclature")
	private String nomenclature;

	@Column(name = "price")
	private String price;


	@Column(name = "qty")
	private int qty;
	
	@Column(name = "manufacturer_name")
	private String manufacturer_name;

	
	@ManyToOne
	@JoinColumn(name = "aircraft_id")
	private Aircraft aircraft;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Inventory() { }

	public Inventory( int inventory_id, String warehouse_id, String nomenclature, String price, int qty, String manufacturer_name, Aircraft aircraft, Product product) {
		this.id = inventory_id;
		this.warehouse_id = warehouse_id;
		this.nomenclature = nomenclature;
		this.price = price;
		this.qty = qty;
		this.manufacturer_name= manufacturer_name;
		this.aircraft = aircraft;
		this.product = product;
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getItem_id() {
		return id;
	}

	public void setItem_id(int inventory_id) {
		this.id = inventory_id;
	}

	public String getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
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

	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	@Override
	public String toString() {
		return "Inventory [inventory_id=" + id + ", warehouse_id=" + warehouse_id + ", part_id=" + part_id
				+ ", nomenclature=" + nomenclature + ", price=" + price + ", qty=" + qty + ", manufacturer_name="
				+ manufacturer_name + ", aircraft=" + aircraft + ", product=" + product + "]";
	}

	
	

}

