package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.UserDTO;
import edu.m2i.api_gestion_bibliotheque.entity.User;

public interface UserService {
	
	UserDTO save(User user);
	UserDTO findById(Integer id);
	List<User> findAll();
	void delete(Integer id);

}
