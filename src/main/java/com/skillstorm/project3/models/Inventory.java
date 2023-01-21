package com.skillstorm.project3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;

import java.util.Set;


@Entity
@Table (name = "inventory")

public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Inventory_id", updatable=false)
	private int id;

	@Column(name = "Warehouse_id")
	private String warehouse_id;

	@Column(name = "part_id")
	private int part_id;

	@Column(name = "Nomenclature")
	private String nomenclature;

	@Column(name = "Price")
	private int price;


	@Column(name = "Qty")
	private int Qty;
	
	@Column(name = "Manufacturer_Name")
	private int manufacturer_name;

	@ManyToMany
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			name = "product",
			joinColumns = @JoinColumn(name = "inventory_id"), // name of column of owner class
			inverseJoinColumns = @JoinColumn(name = "aircraft_id") // name of the column of the target class
			)
	private Set<Aircraft> aircraft;

	public Inventory() { }

	public Inventory( int id, String warehouse_id, String nomenclature, int price, int Qty, int manufacturer_name) {
		this.id = id;
		this.warehouse_id = warehouse_id;
		this.nomenclature = nomenclature;
		this.price = price;
		this.Qty = Qty;
		this.manufacturer_name= manufacturer_name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	
	public int getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(int manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	@Override
	public String toString() {
		return "Inventory [item_id=" + id + ", warehouse_id=" + warehouse_id + ", id=" + id
				+ ", nomenclature=" + nomenclature + ", price=" + price + ", Qty=" + Qty + ", manufacturer_name="
				+ manufacturer_name + ", aircraft=" + aircraft + "]";
	}

	

}

