package com.springbootmongodb.SpringBootMongoDB.repository;

import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
