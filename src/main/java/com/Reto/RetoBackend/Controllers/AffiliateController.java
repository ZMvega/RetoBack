package com.Reto.RetoBackend.Controllers;

import com.Reto.RetoBackend.Entities.Affiliates;
import com.Reto.RetoBackend.Services.AffiliatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/affiliates")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AffiliateController {

    @Autowired
    private AffiliatesService affiliatesService;

    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Affiliates> getlist(){
        return affiliatesService.getlist();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Affiliates> getbyid(@PathVariable("id") int id){
        return affiliatesService.getbyid(id);
    }

    @RequestMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Affiliates post(@RequestBody Affiliates affiliates){
        return affiliatesService.post(affiliates);
    }

    @RequestMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Affiliates put(@RequestBody Affiliates affiliates){
        return affiliatesService.put(affiliates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int id){
        return affiliatesService.delete(id);
    }


}
