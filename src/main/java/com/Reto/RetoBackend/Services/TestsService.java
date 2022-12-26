package com.Reto.RetoBackend.Services;

import com.Reto.RetoBackend.Entities.Tests;
import com.Reto.RetoBackend.Repository.TestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestsService {

    @Autowired
    private TestsRepository testsRepository;

    public List<Tests> getlist(){
        return testsRepository.getlist();
    }

    public Optional<Tests> getbyid(int id){
        return testsRepository.getbyid(id);
    }

    public Tests post(Tests tests){
        if (tests.getId()==null){
            return testsRepository.post(tests);
        }else{
            Optional<Tests> paux = testsRepository.getbyid(tests.getId());
            if (paux.isEmpty()){
                return testsRepository.post(tests);
            }else{
                return tests;
            }
        }
    }

    public Tests put(Tests tests) {
        if (tests.getId() != null) {
            Optional<Tests> tst = testsRepository.getbyid(tests.getId());
            if(!tst.isEmpty()) {
                if (tests.getName() != null) {
                    tst.get().setName(tests.getName());
                }
                if (tests.getDescription() != null) {
                    tst.get().setDescription(tests.getDescription());
                }
                testsRepository.post(tst.get());
                return tst.get();
            }else{
                return tests;
            }
        }else{
            return tests;
        }
    }

    public boolean delete(int id){
        Boolean status = getbyid(id).map(tests -> {
            testsRepository.delete(tests);
            return true;
        }).orElse(false);
        return status;
    }

}
