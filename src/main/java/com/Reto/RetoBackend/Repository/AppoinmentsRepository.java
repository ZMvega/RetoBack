package com.Reto.RetoBackend.Repository;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Entities.Appoinments;
import com.Reto.RetoBackend.Repository.CrudRepository.AppoinmentsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class AppoinmentsRepository {

    @Autowired
    private AppoinmentsCrudRepository appoinmentsCrudRepo;

    public List<Appoinments> getlist(){
        return (List<Appoinments>) appoinmentsCrudRepo.findAll();
    }

    public Optional<Appoinments> getbyid(Integer id){
        return appoinmentsCrudRepo.findById(id);
    }

    public Appoinments post(Appoinments appoinment){
        return appoinmentsCrudRepo.save(appoinment);
    }

    public void delete(Appoinments appoinment){
        appoinmentsCrudRepo.delete(appoinment);
    }
    public List<Appoinments> getbydate(LocalDate date){
        return appoinmentsCrudRepo.findAllByDateOrderByIdAffiliate(date);
    }
    public List<Appoinments> getbyaffliate(Affiliates idAffiliate){
        return appoinmentsCrudRepo.findAllByIdAffiliate(idAffiliate);
    }
}
