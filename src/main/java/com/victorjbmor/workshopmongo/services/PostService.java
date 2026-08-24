package com.victorjbmor.workshopmongo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.victorjbmor.workshopmongo.domain.Post;
import com.victorjbmor.workshopmongo.repository.PostRepository;
import com.victorjbmor.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	private final PostRepository repo;

	public PostService(PostRepository repo) {
		this.repo = repo;
	}

	
	public Post findById(String id) {

	    Optional<Post> post = repo.findById(id);
	    if (post.isEmpty()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return post.get();
	}
	

}
