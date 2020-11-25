package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllBreed(){
        List<String> list = dogService.retrieveAllBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllName(){
        List<String> list = dogService.retrieveAllName();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/origin")
    public ResponseEntity<List<String>> getAllOrigin(){
        List<String> list = dogService.retrieveAllOrigin();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        String breed = dogService.retrieveBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
