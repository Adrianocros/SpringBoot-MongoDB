package com.springbootmongodb.SpringBootMongoDB.domain;

import com.springbootmongodb.SpringBootMongoDB.DTO.AuthoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document
public class Post  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String id;
    private Date data;
    private String title;
    private String body;
    private AuthoDTO author;

    public Post(){}

    public Post(String id, Date data, String title, String body, AuthoDTO author) {
        this.id = id;
        this.data = data;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthoDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthoDTO author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId().equals(post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}