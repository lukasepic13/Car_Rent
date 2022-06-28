package com.fis.IzposojaAvto.Car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

	/*ArrayList<Car> cars = null;
	
	public CarService() {
		super();
		cars = new ArrayList<Car>();
		cars.add(new Car(1, "Ford", "Mustang", "NM-JK-123"));
		cars.add(new Car(2, "Renault", "Clio", "NM-BK-123"));
		cars.add(new Car(3, "Opel", "Astra", "NM-KL-123"));}*/
		
	
	@Autowired
	CarRepository carRepo;
	
	public CarService() {
		super();
	}
	public List<Car> getAllCars(){
		return carRepo.findAll();	
	}
	
	
	public Optional<Car> getCarByID(int i){
		return carRepo.findById(Integer.valueOf(i));
	}
	public List<Car> getCarByPId(int p){
		return carRepo.findByPId(Integer.valueOf(p));
	}
	public List<Car> getCarByBrand(String brand){
		return carRepo.findByBrand(brand);
	}
	
	public String deleteCar(int i){
		try {
			carRepo.deleteById(Integer.valueOf(i));;
		} catch (Exception e) {			
			e.printStackTrace();
			return "That Id does not exist";
		}
		return "deleted";
	}
	
	public String updateCar(Car c,int i){
		try {
			carRepo.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			return "update failed";
		}
		return "updated";
	}
	public String createCar(Car c) {
		try {
			if(carRepo.findById(Integer.valueOf(c.getId())).equals(Optional.empty())) {
				return "That id already exists";
			}
			carRepo.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			return "creation failed";
		}
		return "created";
	}
}
