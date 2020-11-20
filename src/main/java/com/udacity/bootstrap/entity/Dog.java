package com.udacity.bootstrap.entity;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String breed;
    private String origin;

    public Dog(Long id, String name, String breed, String origin){
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed, String origin){
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(Long id, String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public Dog(){}

    public Long getId(Long id){
        return id;
    }

    public String getName(String name){
        return name;
    }

    public String getBreed(String breed){
        return breed;
    }

    public String getOrigin(String origin){
        return origin;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(){
        this.name = name;
    }

    public void setBreed(){
        this.breed = breed;
    }

    public void setOrigin(){
        this.origin = origin;
    }
}
