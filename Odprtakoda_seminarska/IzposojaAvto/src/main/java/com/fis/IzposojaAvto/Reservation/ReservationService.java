package com.fis.IzposojaAvto.Reservation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepo;
	
	public ReservationService() {
		super();
		/*owners = new ArrayList<Owner>();
		owners.add(new Owner(1, "Luka", "Sepic"));
		owners.add(new Owner(2, "Ziga", "Spiler"));
		owners.add(new Owner(3, "Matic", "Kramzar"));*/
		
	}
	public List<Reservation> getAllReservations(){
		return reservationRepo.findAll();	
	}
	public Optional <Reservation> getReservationByID(int i){
		return reservationRepo.findById(Integer.valueOf(i));
	}
	public String deleteReservation(int i){	
		try {
			reservationRepo.deleteById(Integer.valueOf(i));;
		} catch (Exception e) {			
			e.printStackTrace();
			return "That Id does not exist";
		}
		return "deleted";
	}
		
	public String createReservation(Reservation r) {
		try {
			if(reservationRepo.findById(Integer.valueOf(r.getId())).equals(Optional.empty())) {
				return "That id already exists";
			}
			reservationRepo.save(r);
		} catch (Exception e) {
			e.printStackTrace();
			return "creation failed";
		}
		return "created";
	}
	public String UpdateReservation(Reservation r) {
		try {
			reservationRepo.save(r);
		} catch (Exception e) {
			e.printStackTrace();
			return "update failed";
		}
		return "updated";
	}
}

