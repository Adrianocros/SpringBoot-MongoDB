package com.springbootmongodb.SpringBootMongoDB.resources;

import com.springbootmongodb.SpringBootMongoDB.DTO.UserDTO;
import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.services.PostService;
import com.springbootmongodb.SpringBootMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findId(@PathVariable  String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
