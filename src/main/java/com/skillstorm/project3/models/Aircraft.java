package com.skillstorm.project3.models;

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

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "aircraft")

public class Aircraft {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Aircraft_Manufacturer")
	private String aircraft_manufacturer;

	@Column(name = "id")
	private int id;

	@Column(name = "Nomenclature")
	private String nomenclature;

	@Column(name = "Qty")
	private int Qty;

	@Column(name = "Price")
	private String price;

	@Column(name = "Maint_Hours")
	private Integer maint_hours;

	@Column(name = "Warehouse_id")
	private String warehouse_id;
	
	@ManyToMany(fetch = FetchType.LAZY, // don't be lazy and use .EAGER
			mappedBy = "aircraft") // name of PROPERTY in the OWNER class
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore
	private Set<Inventory> inventory;

	public Aircraft() { }

	public Aircraft(String aircraft_manufacturer, int Qty, String price, Integer maint_hours, String warehouse_id) {
		this.aircraft_manufacturer = aircraft_manufacturer;
		this.Qty = Qty;
		this.price = price;
		this.maint_hours = maint_hours;
		this.warehouse_id = warehouse_id;

		this.inventory = new HashSet<>();
	}
	public Set<Inventory> getinventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
	
	public void addInventory(Inventory inventory) {
		this.inventory.add(inventory);
	}
	
	public void removeInventory (Inventory inventory) {
		this.inventory.remove(inventory);
	}
	public String getAircraft_manufacturer() {
		return aircraft_manufacturer;
	}

	public void setAircraft_manufacturer(String aircraft_manufacturer) {
		this.aircraft_manufacturer = aircraft_manufacturer;
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

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getMaint_hours() {
		return maint_hours;
	}

	public void setMaint_hours(Integer maint_hours) {
		this.maint_hours = maint_hours;
	}

	public String getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	
	
}