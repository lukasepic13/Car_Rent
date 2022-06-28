package com.fis.IzposojaAvto.Reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fis.IzposojaAvto.Car.Car;
import com.fis.IzposojaAvto.Visitor.Visitor;

@Entity
@Table(name="reservation",schema="testing")
public class Reservation {

	@Id
	private int id;
	@ManyToOne
	private Car c;
	@ManyToOne
	private Visitor v;
	
	public Reservation() {
		super();
	}
	public Reservation(int id, Car c, Visitor v) {
		super();
		this.id = id;
		this.c = c;
		this.v = v;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car getC() {
		return c;
	}
	public void setC(Car c) {
		this.c = c;
	}
	public Visitor getV() {
		return v;
	}
	public void setV(Visitor v) {
		this.v = v;
	}
	
}
