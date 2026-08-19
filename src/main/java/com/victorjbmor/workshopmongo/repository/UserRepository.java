package com.victorjbmor.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.victorjbmor.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
