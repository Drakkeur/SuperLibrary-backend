package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.UserDTO;
import edu.m2i.api_gestion_bibliotheque.entity.User;
import edu.m2i.api_gestion_bibliotheque.repository.UserRepository;
import edu.m2i.api_gestion_bibliotheque.service.ManagementUserService;

@Service
public class ManagementUserServiceImp implements ManagementUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO save(User user) {
		user = userRepository.save(user);
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(user.getAddress());
		userDTO.setComment(user.getComment());
		userDTO.setCreationDate(user.getCreationDate());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLogin(user.getLogin());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setTypeUser(user.getTypeUser());
		return userDTO;
	}

	@Override
	public User findById(Integer id) {
		return userRepository.getReferenceById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

}
