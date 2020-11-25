package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs(){
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveAllBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveAllName() {
        return (List<String>) dogRepository.findAllName();
    }

    @Override
    public List<String> retrieveAllOrigin() {
        return (List<String>) dogRepository.findAllOrigin();
    }

    @Override
    public String retrieveBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
        //return (String) dogRepository.findBreedById(id);
    }
}
