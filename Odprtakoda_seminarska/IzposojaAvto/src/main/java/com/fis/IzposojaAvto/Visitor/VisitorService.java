package com.fis.IzposojaAvto.Visitor;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VisitorService {

	@Autowired
	VisitorRepository visitorRepo;

	public VisitorService() {
		super();
	}
	public List<Visitor> getAllVisitors(){
		return visitorRepo.findAll();	
	}
	public Optional<Visitor> getVisitorByID(int i){
		return visitorRepo.findById(Integer.valueOf(i));
	}	
public String deleteVisitor(int i){
	try {
		visitorRepo.deleteById(Integer.valueOf(i));;
	} catch (Exception e) {			
		e.printStackTrace();
		return "That Id does not exist";
	}
	return "deleted";
}

public String updateVisitor(Visitor v,int i){
	try {
		visitorRepo.save(v);
	} catch (Exception e) {
		e.printStackTrace();
		return "update failed";
	}
	return "updated";
}
public String createVisitor(Visitor v) {
	try {
		if(visitorRepo.findById(Integer.valueOf(v.getId())).equals(Optional.empty())) {
			return "That id already exists";
		}
		visitorRepo.save(v);
	} catch (Exception e) {
		e.printStackTrace();
		return "creation failed";
	}
	return "created";
}
}