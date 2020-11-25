package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveAllBreed();
    List<String> retrieveAllName();
    List<String> retrieveAllOrigin();
    String retrieveBreedById(Long id);
}
