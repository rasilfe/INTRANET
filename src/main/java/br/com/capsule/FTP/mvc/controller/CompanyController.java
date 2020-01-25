package br.com.capsule.FTP.mvc.controller;

import br.com.capsule.FTP.mvc.model.Company;
import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.Report;
import br.com.capsule.FTP.mvc.model.StorageFiles;
import br.com.capsule.FTP.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@PreAuthorize("isAdmin() || isColaborador()")
public class CompanyController {


    @Autowired
    private CompanyServiceImpl service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@RequestBody Company company) {
        service.save(company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Company find(@PathVariable("id") String id) {
        return service.find(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Company> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Company update(@PathVariable("id") String id, @RequestBody Company company) {
        return service.update(id, company);
    }


    @PostMapping("/{companyId}/contacts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveContact(@PathVariable("companyId") String s, @RequestBody List<Contact> contact) {
        service.saveContact(s, contact);
    }

    @PostMapping("/{companyId}/report")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveReport(@PathVariable("companyId") String s, @RequestBody List<Report> reports) {
        service.saveReport(s, reports);
    }

    @PostMapping("/{companyId}/store")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveStore(@PathVariable("companyId") String s, @RequestBody List<StorageFiles> store) {
        service.saveStore(s, store);
    }
}
