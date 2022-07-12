package com.springbootmongodb.SpringBootMongoDB.services;

import com.springbootmongodb.SpringBootMongoDB.DTO.UserDTO;
import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.repository.PostRepository;
import com.springbootmongodb.SpringBootMongoDB.repository.UserRepository;
import com.springbootmongodb.SpringBootMongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired //Ingeção de dependencia
    private PostRepository postRepository;

      public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !"));
    }


}
