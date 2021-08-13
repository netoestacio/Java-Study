package br.com.multiDatabases.controller;

import br.com.multiDatabases.repository.postgres.entity.User;
import br.com.multiDatabases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity getAllUser(){
        return service.findAll();
    }

    @GetMapping("/find")
    public ResponseEntity getOneUser(@RequestParam("id") Long id){
        return service.findOne(id);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user){
        return service.save(user);
    }

}
