package com.ragendhu.placementmanagement;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class RagendhuAdminService {
	
	@Autowired
	private RagendhuAdminRepository repo;
	
	//to retrieve all the data of student class
	public List<RagendhuAdmin> listAll()
	{
		return repo.findAll();
	}
	//insert/create/update a data
	public void create(RagendhuAdmin s)
	{
		 repo.save(s);
	}
	//to retrieve a single record
	public RagendhuAdmin retrieve(Integer id)
	{
		return repo.findById(id).get();
		
	}
	//to delete a data
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}

}