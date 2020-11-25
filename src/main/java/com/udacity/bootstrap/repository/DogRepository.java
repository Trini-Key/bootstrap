package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.repository.CrudRepository;


public interface DogRepository extends CrudRepository<Dog, Long> {


    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();

    @Query("select d.id, d.origin from Dog d")
    List<String> findAllOrigin();

}
