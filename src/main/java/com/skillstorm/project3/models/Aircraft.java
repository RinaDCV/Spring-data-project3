package com.skillstorm.project3.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityReference;


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
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private Inventory inventory;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	public String getAircraft_id() {
		return aircraft_manufacturer;
	}

	public void setAircraft_id(String aircraft_id) {
		this.aircraft_manufacturer = aircraft_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String Nomenclature() {
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

	public String Warehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	@Override
	public String toString() {
		return "Aircraft [aircraft_manufacturer=" + aircraft_manufacturer + ", id=" + id + ", nomenclature=" + nomenclature
				+ ", Qty=" + Qty + ", price=" + price + ", maint_hours=" + maint_hours + ", warehouse_id="
				+ warehouse_id + "]";
	}



}