package com.skillstorm.project3.models;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "inventory")
@JsonIdentityInfo(generator = StringIdGenerator.class, property = "id")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Inventory_id")
	private int inventory_id;

	@Column(name = "Warehouse_id")
	private String warehouse_id;

	@Column(name = "id")
	private int id;

	@Column(name = "Nomenclature")
	private String nomenclature;

	@Column(name = "Price")
	private int price;


	@Column(name = "Qty")
	private int Qty;


//	@ManyToMany(fetch = FetchType.LAZY, // don't be lazy and use .EAGER
//			mappedBy = "inventory") // name of PROPERTY in the OWNER class
//	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
//	@JsonIgnore
//	private Set<Aircraft> aircraft;
	
	@OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Aircraft> aircraft;
	
	public List<Aircraft> getAircraft() {
		return aircraft;
	}

	
	public Inventory() { }

	public Inventory(String name, String description, int inventory_id, String warehouse_id, String nomenclature, int price, int Qty) {
		this.inventory_id = inventory_id;
		this.warehouse_id = warehouse_id;
		this.nomenclature = nomenclature;
		this.price = price;
		this.Qty = Qty;
	}

	public List<Aircraft> getAricraft() {
		return aircraft;
	}

	public void setAircraft(List<Aircraft> aircraft) {
		this.aircraft = aircraft;
	}

	public void addAircraft(Aircraft aircraft) {
		this.aircraft.add(aircraft);
	}

	public void removeAircraft(Aircraft aircraft) {
		this.aircraft.remove(aircraft);
	}



	public int getInventory_id() {
		return inventory_id;
	}


	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
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


	@Override
	public String toString() {
		return "Inventory [inventory_id=" + inventory_id + ", warehouse_id=" + warehouse_id + ", id=" + id
				+ ", nomenclature=" + nomenclature + ", price=" + price + ", Qty=" + Qty + "]";
	}


}
