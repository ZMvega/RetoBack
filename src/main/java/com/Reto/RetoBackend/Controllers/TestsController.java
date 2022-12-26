package com.Reto.RetoBackend.Controllers;

import com.Reto.RetoBackend.Entities.Tests;
import com.Reto.RetoBackend.Services.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TestsController {

    @Autowired
    private TestsService testsService;

    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Tests> getlist(){
        return testsService.getlist();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Tests> getbyid(@PathVariable("id") int id){
        return testsService.getbyid(id);
    }

    @RequestMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Tests post(@RequestBody Tests tests){
        return testsService.post(tests);
    }

    @RequestMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tests put(@RequestBody Tests tests){
        return testsService.put(tests);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int id){
        return testsService.delete(id);
    }


}
