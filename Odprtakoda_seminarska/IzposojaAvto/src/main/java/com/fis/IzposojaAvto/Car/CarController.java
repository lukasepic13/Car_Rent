package com.fis.IzposojaAvto.Car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	
	@Autowired
	CarService CarService;


	public CarController() {
		super();
	}
	
	@RequestMapping("/Cars/getAllCars")
	public List<Car> getAllCars(){
		return CarService.getAllCars();	
	}
	@GetMapping ("/Cars/getCarByID/{i}")
	public Optional<Car> getCarByID(@PathVariable int i){
		return CarService.getCarByID(i);
	}
	@GetMapping ("/Cars/getCarByParkingID/{i}")
	public List<Car> getCarByPId(@PathVariable int p){
		return CarService.getCarByPId(p);
	}
	@GetMapping ("/Cars/getCarByName/{s}")
	public List<Car> getCarByBrand(@PathVariable String brand){
		return CarService.getCarByBrand(brand);
	}
	@GetMapping ("/Cars/deleteCar/{i}")
	public String deleteCar(@PathVariable int i){
		return CarService.deleteCar(i);
	}
	@PutMapping ("/Cars/UpdateCar/{i}")
	public String updateCar(@RequestBody Car c,@PathVariable int i){
		return CarService.updateCar(c, i);
	}	
	@RequestMapping(value = "/Cars/createCar" , method = RequestMethod.POST)
	public String createCar(@RequestBody Car c) {
		return CarService.createCar(c);
	}
}
