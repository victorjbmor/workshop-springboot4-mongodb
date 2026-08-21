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
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
	public User update(User obj) {

	    User newObj = repo.findById(obj.getId())
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    updateData(newObj, obj);

	    return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {

	    newObj.setName(obj.getName());
	    newObj.setEmail(obj.getEmail());
	}
}
