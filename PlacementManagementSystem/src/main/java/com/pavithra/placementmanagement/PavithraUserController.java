package com.pavithra.placementmanagement;
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
public class PavithraUserController {
	
	@Autowired
	private PavithraUserService service;
	
	//RESTful API
	//creation
	@PostMapping("/user")
	public void add(@RequestBody PavithraUser u)
	{
		service.create(u);
	}
	//deletion
	@DeleteMapping("/user/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/user")
	public List<PavithraUser>list()
	{
		return service.listAll();
		
	}
	//Retrieve with specific id
	@GetMapping("/user/{id}")
	public ResponseEntity<PavithraUser> get(@PathVariable Integer id)
	{
		try {
			PavithraUser u=service.retrieve(id);
			return new ResponseEntity<PavithraUser>(u,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<PavithraUser>(HttpStatus.NOT_FOUND);
		}
		
	}
	//updation
	@PutMapping("/user/{id}")
	public ResponseEntity<PavithraUser> update(@RequestBody PavithraUser u, @PathVariable Integer id)
	{
		try {
			@SuppressWarnings("unused")
			PavithraUser u1=service.retrieve(id);
			service.create(u);
			return new ResponseEntity<PavithraUser>(u,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<PavithraUser>(HttpStatus.NOT_FOUND);
		}
		
		
	}
		

}