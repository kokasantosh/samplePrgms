package com.santosh.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2, message="Name should have atleast 2 characters")
    private String name;
    @Past
    private Date DOB;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {

    }

    public User(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name, @Past Date DOB, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.posts = posts;
    }

    public User(Integer id, String name, Date DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                ", posts=" + posts +
                '}';
    }
}
