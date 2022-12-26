package com.Reto.RetoBackend.Repository;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Entities.Tests;
import com.Reto.RetoBackend.Repository.CrudRepository.TestsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TestsRepository {

    @Autowired
    private TestsCrudRepository testsCrudRepository;

    public List<Tests> getlist(){
        return (List<Tests>) testsCrudRepository.findAll();
    }

    public Optional<Tests> getbyid(Integer id){
        return testsCrudRepository.findById(id);
    }

    public Tests post(Tests tests){
        return testsCrudRepository.save(tests);
    }

    public void delete(Tests tests){
        testsCrudRepository.delete(tests);
    }
}
