package com.springbootmongodb.SpringBootMongoDB.services;

import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //Ingeção de dependencia
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
