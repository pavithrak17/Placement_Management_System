package com.pavithra.placementmanagement;
import java.util.List;
public interface PavithraIUserService {
	List<PavithraUser> getAllUsers();
	PavithraUser getUserById(Long id);
	void addUser(PavithraUser u);
	void deleteUser(Long id);
	void updateUser(Long id, PavithraUser u);
}

