package com.Reto.RetoBackend.Repository;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Repository.CrudRepository.AffiliatesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AffiliatesRepository {

    @Autowired
    private AffiliatesCrudRepository affiliatesCrudRepo;

    public List<Affiliates> getlist(){
        return (List<Affiliates>) affiliatesCrudRepo.findAll();
    }

    public Optional<Affiliates> getbyid(Integer id){
        return affiliatesCrudRepo.findById(id);
    }

    public Affiliates post(Affiliates affiliate){
        return affiliatesCrudRepo.save(affiliate);
    }

    public void delete(Affiliates affiliate){
        affiliatesCrudRepo.delete(affiliate);
    }
}
