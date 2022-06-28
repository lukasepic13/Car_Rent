package com.fis.IzposojaAvto.Owner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	
	@Autowired
	OwnerRepository ownerRepo;
	
	public OwnerService() {
		super();
		/*owners = new ArrayList<Owner>();
		owners.add(new Owner(1, "Luka", "Sepic"));
		owners.add(new Owner(2, "Ziga", "Spiler"));
		owners.add(new Owner(3, "Matic", "Kramzar"));*/
		
	}
	public List<Owner> getAllOwners(){
		return ownerRepo.findAll();	
	}
	public Optional <Owner> getOwnerByID(int i){
		return ownerRepo.findById(Integer.valueOf(i));
	}
	public String deleteOwner(int i){	
		try {
			ownerRepo.deleteById(Integer.valueOf(i));;
		} catch (Exception e) {			
			e.printStackTrace();
			return "That Id does not exist";
		}
		return "deleted";
	}
		
	public String createOwner(Owner o) {
		try {
			if(ownerRepo.findById(Integer.valueOf(o.getId())).equals(Optional.empty())) {
				return "That id already exists";
			}
			ownerRepo.save(o);
		} catch (Exception e) {
			e.printStackTrace();
			return "creation failed";
		}
		return "created";
	}
	public String UpdateOwner(Owner o) {
		try {
			ownerRepo.save(o);
		} catch (Exception e) {
			e.printStackTrace();
			return "update failed";
		}
		return "updated";
	}
}

