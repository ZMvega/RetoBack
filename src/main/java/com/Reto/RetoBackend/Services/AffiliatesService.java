package com.Reto.RetoBackend.Services;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Repository.AffiliatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliatesService {

    @Autowired
    private AffiliatesRepository affiliatesRepository;

    public List<Affiliates> getlist(){
        return affiliatesRepository.getlist();
    }

    public Optional<Affiliates> getbyid(int id){
        return affiliatesRepository.getbyid(id);
    }

    public Affiliates post(Affiliates affiliates){
        if (affiliates.getId()==null){
            return affiliatesRepository.post(affiliates);
        }else{
            Optional<Affiliates> paux = affiliatesRepository.getbyid(affiliates.getId());
            if (paux.isEmpty()){
                return affiliatesRepository.post(affiliates);
            }else{
                return affiliates;
            }
        }
    }

    public Affiliates put(Affiliates affiliates) {
        if (affiliates.getId() != null) {
            Optional<Affiliates> affi = affiliatesRepository.getbyid(affiliates.getId());

            if(!affi.isEmpty()) {
                if (affiliates.getName() != null) {
                    affi.get().setName(affiliates.getName());
                }
                if (affiliates.getEmail() != null) {
                    affi.get().setEmail(affiliates.getEmail());
                }
                if (affiliates.getAge() != null) {
                    affi.get().setAge(affiliates.getAge());
                }
                affiliatesRepository.post(affi.get());
                return affi.get();
            }else{
                return affiliates;
            }
        }else{
            return affiliates;
        }
    }

    public boolean delete(int id){
        Boolean status = getbyid(id).map(affiliates -> {
            affiliatesRepository.delete(affiliates);
            return true;
        }).orElse(false);
        return status;
    }

}
