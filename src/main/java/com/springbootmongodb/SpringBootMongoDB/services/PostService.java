package com.springbootmongodb.SpringBootMongoDB.services;

import com.springbootmongodb.SpringBootMongoDB.DTO.UserDTO;
import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.repository.PostRepository;
import com.springbootmongodb.SpringBootMongoDB.repository.UserRepository;
import com.springbootmongodb.SpringBootMongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired //Ingeção de dependencia
    private PostRepository repo;

      public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !"));
    }

    public List<Post> findByTitle(String text){
          return repo.searchTitle(text);
    }

    public List<Post>fullSearch(String text, Date minDate,Date maxDate){
          maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
            return repo.fullSearch(text,minDate,maxDate);
      }

}
