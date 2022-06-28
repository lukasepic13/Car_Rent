package com.fis.IzposojaAvto.Parking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

	@Autowired
	ParkingRepository parkingRepo;
	
	public ParkingService() {
		super();
	}
	public List<Parking> getAllParkings(){
		return parkingRepo.findAll();	
	}
	
	
	public Optional<Parking> getParkingByID(int i){
		return parkingRepo.findById(Integer.valueOf(i));
	}
	
	public String deleteParking(int i){
		try {
			parkingRepo.deleteById(Integer.valueOf(i));;
		} catch (Exception e) {			
			e.printStackTrace();
			return "That Id does not exist";
		}
		return "deleted";
	}
	
	public String updateParking(Parking p,int i){
		try {
			parkingRepo.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			return "update failed";
		}
		return "updated";
	}
	public String createParking(Parking p) {
		try {
			if(parkingRepo.findById(Integer.valueOf(p.getId())).equals(Optional.empty())) {
				return "That id already exists";
			}
			parkingRepo.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			return "creation failed";
		}
		return "created";
	}
}
