package com.fis.IzposojaAvto.Parking;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ParkingController {
		@Autowired
		ParkingService ParkingService;


		public ParkingController() {
			super();
		}
		
		@RequestMapping("/Parking/getAllParkings")
		public List<Parking> getAllParkings(){
			return ParkingService.getAllParkings();	
		}
		@GetMapping ("/Parking/getParkingByID/{i}")
		public Optional<Parking> getParkingByID(@PathVariable int i){
			return ParkingService.getParkingByID(i);
		}
		@DeleteMapping ("/Parking/deleteParking/{i}")
		public String deleteParking(@PathVariable int i){
			return ParkingService.deleteParking(i);
		}
		@PutMapping ("/Parking/UpdateParking/{i}")
		public String updateParking(@RequestBody Parking p,@PathVariable int i){
			return ParkingService.updateParking(p, i);
		}	
		@RequestMapping(value = "/Parking/createParking" , method = RequestMethod.POST)
		public String createParking(@RequestBody Parking p) {
			return ParkingService.createParking(p);
		}
}
