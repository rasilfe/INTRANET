package br.com.capsule.FTP.service;

import br.com.capsule.FTP.exceptions.CompanyNotFound;
import br.com.capsule.FTP.mvc.model.Company;
import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.repository.CompanyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyContactsServiceImpl implements BasicSubrud<Contact, String> {


    @Autowired
    private CompanyRepository repository;

    @Override
    public void save(String s, Contact contact) {

    }

    @SneakyThrows
    public void save(String s, List<Contact> contact) {
        Company company = repository.findById(s).orElseThrow(() -> new CompanyNotFound());
        company.setContacts(contact);
        repository.save(company);
    }

    @Override
    @SneakyThrows
    public void delete(String s) {
    }

    @Override
    public Contact find(String s) {
        return null;
    }

    @Override
    public List<Contact> findAll(String s) {
        return null;
    }

    @Override
    public Contact update(String s, Contact contact) {
        return null;
    }
}
