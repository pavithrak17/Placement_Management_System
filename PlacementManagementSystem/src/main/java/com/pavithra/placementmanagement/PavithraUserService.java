package com.pavithra.placementmanagement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
	public class PavithraUserService implements PavithraIUserService {
	
		
		@Autowired
		private PavithraUserRepository repo;
		
		//to retrieve all the data of student class
		public List<PavithraUser> listAll()
		{
			return repo.findAll();
		}
		//insert/create/update a data
		public void create(PavithraUser s)
		{
			 repo.save(s);
		}
		//to retrieve a single record
		public PavithraUser retrieve(Integer id)
		{
			return repo.findById(id).get();
			
		}
		//to delete a data
		public void delete(Integer id)
		{
			repo.deleteById(id);
		}
		@Override
		public List<PavithraUser> getAllUsers() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PavithraUser getUserById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void addUser(PavithraUser u) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteUser(Long id) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void updateUser(Long id, PavithraUser u) {
			// TODO Auto-generated method stub
			
		}

	}