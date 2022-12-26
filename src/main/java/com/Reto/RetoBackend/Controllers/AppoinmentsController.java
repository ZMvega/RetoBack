package com.Reto.RetoBackend.Controllers;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Entities.Appoinments;
import com.Reto.RetoBackend.Services.AppoinmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appoinments")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AppoinmentsController {

    @Autowired
    private AppoinmentsService appoinmentsService;

    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Appoinments> getlist(){
        return appoinmentsService.getlist();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Appoinments> getbyid(@PathVariable("id") int id){
        return appoinmentsService.getbyid(id);
    }

    @RequestMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Appoinments post(@RequestBody Appoinments appoinments){
        return appoinmentsService.post(appoinments);
    }

    @RequestMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Appoinments put(@RequestBody Appoinments appoinments){
        return appoinmentsService.put(appoinments);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int id){
        return appoinmentsService.delete(id);
    }

    @RequestMapping("/date/{date}")
    public List<Appoinments> getbydate(@PathVariable("date") String date){
        List<Appoinments> listAppo = appoinmentsService.getbydate(date);
        if(listAppo.isEmpty()){
            return new ArrayList<>();
        }else{
            return listAppo;
        }
    }

    @RequestMapping("/affiliates/{id}")
    public List<Appoinments> getbyaffiliate(@PathVariable("id") Affiliates id){
        return appoinmentsService.getbyaffiliate(id);
    }


}
