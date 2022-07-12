package com.springbootmongodb.SpringBootMongoDB.resources;

import com.springbootmongodb.SpringBootMongoDB.DTO.UserDTO;
import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.resources.util.URL;
import com.springbootmongodb.SpringBootMongoDB.services.PostService;
import com.springbootmongodb.SpringBootMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @RequestMapping(value = "/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text",defaultValue = "")  String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullseach(
            @RequestParam(value = "text",defaultValue = "")  String text,
            @RequestParam(value = "minDate",defaultValue = "")  String minDate,
            @RequestParam(value = "maxDate",defaultValue = "")  String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(maxDate,new Date());
        List<Post> list = postService.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }

}
