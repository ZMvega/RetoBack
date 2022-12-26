package com.Reto.RetoBackend.Services;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Entities.Appoinments;
import com.Reto.RetoBackend.Repository.AppoinmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppoinmentsService {

    @Autowired
    private AppoinmentsRepository appoinmentsRepository;

    public List<Appoinments> getlist(){
        return appoinmentsRepository.getlist();
    }

    public Optional<Appoinments> getbyid(int id){
        return appoinmentsRepository.getbyid(id);
    }

    public Appoinments post(Appoinments appoinments){
        if (appoinments.getId()==null){
            return appoinmentsRepository.post(appoinments);
        }else{
            Optional<Appoinments> paux = appoinmentsRepository.getbyid(appoinments.getId());
            if (paux.isEmpty()){
                return appoinmentsRepository.post(appoinments);
            }else{
                return appoinments;
            }
        }
    }

    public Appoinments put(Appoinments appoinments) {
        if (appoinments.getId() != null) {
            Optional<Appoinments> appo = appoinmentsRepository.getbyid(appoinments.getId());

            if(!appo.isEmpty()) {
                if (appoinments.getDate() != null) {
                    appo.get().setDate(appoinments.getDate());
                }
                if (appoinments.getHour() != null) {
                    appo.get().setHour(appoinments.getHour());
                }
                appoinmentsRepository.post(appo.get());
                return appo.get();
            }else{
                return appoinments;
            }
        }else{
            return appoinments;
        }
    }

    public boolean delete(int id){
        Boolean status = getbyid(id).map(appoinment -> {
            appoinmentsRepository.delete(appoinment);
            return true;
        }).orElse(false);
        return status;
    }

    public List<Appoinments> getbydate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return appoinmentsRepository.getbydate(localDate);
    }

    /*public List<Reservations> getReservationsBetweenDates(String dateA,String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException error){
            error.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a, b);
        }else{
            return new ArrayList<>();
        }
    }*/


    public List<Appoinments> getbyaffiliate(Affiliates idAffiliate){
        return appoinmentsRepository.getbyaffliate(idAffiliate);
    }

}
