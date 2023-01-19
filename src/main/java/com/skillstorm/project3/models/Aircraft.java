package com.skillstorm.project3.models;

import javax.persistence.*;


@Entity
@Table(name = "aircraft")


public class Aircraft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "wharehouse_id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "flight_ready")
	private boolean filght_ready;
	
	@Column(name = "req_partid")
	private int req_partid;
	
	@Column(name = "maint_hours")
	private int maint_hours;
	
	@Column(name = "nomenclature")
	private String nomenclature;
	
	@Column(name = "location")
	private boolean location;
}
