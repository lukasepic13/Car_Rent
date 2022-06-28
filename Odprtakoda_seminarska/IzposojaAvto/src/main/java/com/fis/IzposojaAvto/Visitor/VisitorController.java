package com.fis.IzposojaAvto.Visitor;

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
public class VisitorController {
	@Autowired
	VisitorService VisitorService;

	public VisitorController() {
		super();		
	}
	
	@RequestMapping("/Visitor/getAllVisitors")
	public List<Visitor> getAllVisitors(){
		return VisitorService.getAllVisitors();	
	}
	@GetMapping ("/Visitors/getVisitorByID/{i}")
	public Optional<Visitor> getVisitorByID(@PathVariable int i){		
		return VisitorService.getVisitorByID(i);
	}
	@GetMapping ("/Visitor/deleteVisitor/{i}")
	public String deleteVisitor(@PathVariable int i){
		return VisitorService.deleteVisitor(i);
	}
	@PutMapping ("/Visitor/UpdateVisitor/{i}")
	public String updateVisitor(@RequestBody Visitor v,@PathVariable int i){
		return VisitorService.updateVisitor(v, i);
	}	
	@RequestMapping(value = "/Visitor/createVisitor" , method = RequestMethod.POST)
	public String createVisitor(@RequestBody Visitor v) {
		return VisitorService.createVisitor(v);
	}
}
