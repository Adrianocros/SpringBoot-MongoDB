package com.springbootmongodb.SpringBootMongoDB.DTO;

import com.springbootmongodb.SpringBootMongoDB.domain.User;

import java.io.Serializable;

public class AuthoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthoDTO(){}

    public AuthoDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
