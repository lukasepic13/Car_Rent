package com.fis.IzposojaAvto.Owner;

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
public class OwnerController {

	@Autowired
	OwnerService OwnerService;

	public OwnerController() {
		super();	
	}
	
	@RequestMapping("/Owner/getAllOwners")
	public List<Owner> getAllOwners(){
		return OwnerService.getAllOwners();	
	}
	@GetMapping ("/Owner/getOwnerByID/{i}")
	public Optional <Owner> getCarByID(@PathVariable int i){
		return OwnerService.getOwnerByID(i);
	}
	@GetMapping ("/Owner/deleteOwner/{i}")
	public String deleteCar(@PathVariable int i){
		return OwnerService.deleteOwner(i);
	}
		
	@RequestMapping(value = "/Owner/createOwner" , method = RequestMethod.POST)
	public String createOwner(@RequestBody Owner o) {
		return OwnerService.createOwner(o);
	}
	@PutMapping ("/Owner/UpdateOwner/{i}")
	public String UpdateOwner(@RequestBody Owner o) {
		return OwnerService.UpdateOwner(o);
	}

}

