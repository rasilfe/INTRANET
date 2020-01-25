package br.com.capsule.FTP.mvc.controller;

import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.User;
import br.com.capsule.FTP.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("isAdmin()")
public class UserController {


    @Autowired
    private UserServiceImpl service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        service.save(user);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public User find(@PathVariable("id") String id) {
        return service.find(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public User update(@PathVariable("id") String id, @RequestBody User user) {
        return service.update(id, user);
    }


    @PutMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void save(@PathVariable("userId") String s, @RequestBody Contact contact) {
        service.save(s, contact);
    }
}
