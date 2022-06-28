package com.fis.IzposojaAvto.Parking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parking",schema="testing")
public class Parking {

	@Id
	private int id;
	private String city;
	private String address;
	
	public int getId() {
		return id;
	}

	public Parking(int id, String city, String address) {
		super();
		this.id = id;
		this.city = city;
		this.address = address;
	}
	
	
	public Parking() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
