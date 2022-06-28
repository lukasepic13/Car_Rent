package com.fis.IzposojaAvto.Reservation;

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
public class ReservationController {

	@Autowired
	ReservationService ReservationService;

	public ReservationController() {
		super();	
	}
	
	@RequestMapping("/Reservation/getAllReservation")
	public List<Reservation> getAllReservations(){
		return ReservationService.getAllReservations();	
	}
	@GetMapping ("/Reservation/getReservationByID/{i}")
	public Optional<Reservation> getReservationByID(@PathVariable int i){
		return ReservationService.getReservationByID(i);
	}
	@GetMapping ("/Reservation/deleteReservation/{i}")
	public String deleteReservation(@PathVariable int i){
		return ReservationService.deleteReservation(i);
	}
		
	@RequestMapping(value = "/Reservation/createReservation" , method = RequestMethod.POST)
	public String createReservation(@RequestBody Reservation r) {
		return ReservationService.createReservation(r);
	}
	@PutMapping ("/Reservation/UpdateReservation/{i}")
	public String UpdateReservation(@RequestBody Reservation r) {
		return ReservationService.UpdateReservation(r);
	}

}