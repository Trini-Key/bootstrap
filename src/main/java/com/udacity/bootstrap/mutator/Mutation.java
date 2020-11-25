package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.service.BreedNotFoundException;
import com.udacity.bootstrap.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed){
        Dog dog = new Dog(name, breed);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        //loop through all dogs to check their breed
        for(Dog d: allDogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed not found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            //Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
