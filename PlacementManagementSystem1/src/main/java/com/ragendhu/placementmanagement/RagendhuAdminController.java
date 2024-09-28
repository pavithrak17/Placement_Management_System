package com.ragendhu.placementmanagement;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagendhuAdminController {
	
	@Autowired
	private RagendhuAdminService service;
	
	//RESTful API
	//creation
	@PostMapping("/admin")
	public void add(@RequestBody RagendhuAdmin s)
	{
		service.create(s);
	}
	//deletion
	@DeleteMapping("/admin/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/admin")
	public List<RagendhuAdmin>list()
	{
		return service.listAll();
		
	}
	//Retrieve with specific id
	@GetMapping("/admin/{id}")
	public ResponseEntity<RagendhuAdmin> get(@PathVariable Integer id)
	{
		try {
			RagendhuAdmin s=service.retrieve(id);
			return new ResponseEntity<RagendhuAdmin>(s,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<RagendhuAdmin>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	//updation
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<RagendhuAdmin> update(@RequestBody RagendhuAdmin s, @PathVariable Integer id)
	{
		try {
			@SuppressWarnings("unused")
			RagendhuAdmin s1=service.retrieve(id);
			service.create(s);
			return new ResponseEntity<RagendhuAdmin>(s,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<RagendhuAdmin>(HttpStatus.NOT_FOUND);
		}	
	}
}