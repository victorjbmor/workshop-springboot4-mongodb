package com.victorjbmor.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victorjbmor.workshopmongo.domain.User;
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
}
