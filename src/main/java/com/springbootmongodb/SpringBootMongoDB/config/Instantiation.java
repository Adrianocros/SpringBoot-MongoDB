package com.springbootmongodb.SpringBootMongoDB.config;

import com.springbootmongodb.SpringBootMongoDB.DTO.AuthoDTO;
import com.springbootmongodb.SpringBootMongoDB.domain.Post;
import com.springbootmongodb.SpringBootMongoDB.domain.User;
import com.springbootmongodb.SpringBootMongoDB.repository.PostRepository;
import com.springbootmongodb.SpringBootMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    //Instanciar os objetos e salvar no banco de dados
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null,"Maria Silva","maria@silva.com");
        User alex = new User(null,"Joao Silva","joao@silva.com");
        User joao = new User(null,"Ricarso Silva","joao@silva.com");

        userRepository.saveAll(Arrays.asList(maria,alex,joao));

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para São Paulo !",new AuthoDTO(maria));
        Post post2 = new Post(null,sdf.parse("13/06/2021"),"Bom dia","Acordei feliz !",new AuthoDTO(alex));

        postRepository.saveAll(Arrays.asList(post1,post2));

    }
}
