package com.springbootmongodb.SpringBootMongoDB.config;

import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;



    //Instanciar os objetos e salvar no banco de dados
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null,"Maria Silva","maria@silva.com");
        User alex = new User(null,"Joao Silva","joao@silva.com");
        User joao = new User(null,"Ricarso Silva","joao@silva.com");

       userRepository.saveAll(Arrays.asList(maria,alex,joao));
    }



}
