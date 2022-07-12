package com.springbootmongodb.SpringBootMongoDB.config;

import com.springbootmongodb.SpringBootMongoDB.DTO.AuthorDTO;
import com.springbootmongodb.SpringBootMongoDB.DTO.CommentDTO;
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

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para São Paulo !",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("13/06/2021"),"Bom dia","Acordei feliz !",new AuthorDTO(alex));
        Post post3 = new Post(null,sdf.parse("11/02/2021"),"Que dia","Adoro o frio !",new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!",sdf.parse("21/03/2018"),new AuthorDTO(alex));//post1
        CommentDTO comment2 = new CommentDTO("Lindo diaaaa!",sdf.parse("13/06/2021"),new AuthorDTO(maria));//post2
        CommentDTO comment3 = new CommentDTO("Bora tomar uma ? ",sdf.parse("13/06/2021"),new AuthorDTO(alex));//post2
        CommentDTO comment4 = new CommentDTO("São Paulo Tooopp !",sdf.parse("21/03/2018"),new AuthorDTO(joao));//post1
        CommentDTO comment5 = new CommentDTO("Frio muito bomm ",sdf.parse("11/02/2021"),new AuthorDTO(joao));//post3

        post1.getComments().addAll(Arrays.asList(comment1,comment4));
        post2.getComments().addAll(Arrays.asList(comment2,comment3));
        post3.getComments().addAll(Arrays.asList(comment5));

        postRepository.saveAll(Arrays.asList(post1,post2,post3));

        maria.getPosts().addAll(Arrays.asList(post1,post3));
        userRepository.save(maria);

        maria.getPosts().addAll(Arrays.asList(post2));
        userRepository.save(alex);

    }
}
