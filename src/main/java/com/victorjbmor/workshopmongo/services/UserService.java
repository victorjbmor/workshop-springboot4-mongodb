package com.victorjbmor.workshopmongo.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.victorjbmor.workshopmongo.domain.User;
import com.victorjbmor.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repo;

	UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
