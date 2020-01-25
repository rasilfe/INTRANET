package br.com.capsule.FTP.mvc.controller;

import br.com.capsule.FTP.mvc.model.Company;
import br.com.capsule.FTP.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissao/{userId}")
@PreAuthorize("isAdmin()")
public class PermissaoController {

    @Autowired
    private UserServiceImpl service;


    @PostMapping
    public void saveCompany(@PathVariable("userId") String id, @RequestBody List<Company> companies) {
        service.saveCompany(id, companies);
    }


}
