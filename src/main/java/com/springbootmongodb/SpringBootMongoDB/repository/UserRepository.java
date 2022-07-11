package com.springbootmongodb.SpringBootMongoDB.repository;

import com.springbootmongodb.SpringBootMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
