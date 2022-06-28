package com.fis.IzposojaAvto.Car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>{
	public List<Car> findByPId(Integer p);
	public List<Car> findByBrand(String brand);
}