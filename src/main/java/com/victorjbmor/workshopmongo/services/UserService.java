package com.victorjbmor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victorjbmor.workshopmongo.domain.User;
import com.victorjbmor.workshopmongo.dto.UserDTO;
import com.victorjbmor.workshopmongo.repository.UserRepository;
import com.victorjbmor.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	private final UserRepository repo;

	UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {

	    Optional<User> user = repo.findById(id);
	    if (user.isEmpty()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return user.get();
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
