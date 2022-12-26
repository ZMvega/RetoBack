package com.Reto.RetoBackend.Repository.CrudRepository;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Entities.Appoinments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppoinmentsCrudRepository extends CrudRepository<Appoinments, Integer> {

    List<Appoinments> findAllByDateOrderByIdAffiliate(LocalDate date);

    List<Appoinments> findAllByIdAffiliate(Affiliates idAffiliate);
}
