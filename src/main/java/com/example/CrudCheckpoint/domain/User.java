package com.example.CrudCheckpoint.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{

    //@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;

    //@Entity needs a public non-argument constructor
    public User(){
    }

    public User(String email, String password){

        this.email = email;
        this.password = password;

    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "User [id=" + id + ", email="
                + email + ", password=" + password + "]";
    }

}