package com.fis.IzposojaAvto.Car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fis.IzposojaAvto.Owner.Owner;
import com.fis.IzposojaAvto.Parking.Parking;

@Entity
@Table(name="car",schema="testing")
public class Car{
	
	@Id
	private int id;
	private String brand;
	private String model;
	private String Registration;
	@ManyToOne
	private Owner o;
	@ManyToOne
	private Parking p;
	
	public Car() {
		super();
	}
	public Car(int id, String brand, String model, String registration, Owner o,Parking p) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.Registration = registration;
		this.o = o;
		this.p = p;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistration() {
		return Registration;
	}
	public void setRegistration(String registration) {
		Registration = registration;
	}
	public Owner getO() {
		return o;
	}
	public void setO(Owner o) {
		this.o = o;
	}	
	public Parking getp() {
		return p;
	}
	public void setO(Parking p) {
		this.p = p;
	}	
	
}