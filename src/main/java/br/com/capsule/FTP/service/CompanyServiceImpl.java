package br.com.capsule.FTP.service;

import br.com.capsule.FTP.exceptions.CompanyNotFound;
import br.com.capsule.FTP.mvc.model.Company;
import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.Report;
import br.com.capsule.FTP.mvc.model.StorageFiles;
import br.com.capsule.FTP.mvc.repository.CompanyRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements BasicCrud<Company> {

    @Autowired
    private CompanyRepository repository;


    @Override
    public void save(Company company) {
        repository.save(company);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public Company find(String id) {
        return repository.findById(id).orElseThrow(() -> new CompanyNotFound());
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company update(String id, Company company) {
        company.setId(id);
        return repository.save(company);
    }

    @SneakyThrows
    public void saveContact(String s, List<Contact> contact) {
        Company company = repository.findById(s).orElseThrow(() -> new CompanyNotFound());
        company.setContacts(contact);
        repository.save(company);
    }

    @SneakyThrows
    public void saveReport(String s, List<Report> reports) {
        Company company = repository.findById(s).orElseThrow(() -> new CompanyNotFound());
        company.setReports(reports);
        repository.save(company);
    }

    @SneakyThrows
    public void saveStore(String s, List<StorageFiles> store) {
        Company company = repository.findById(s).orElseThrow(() -> new CompanyNotFound());
        company.setStorageFiles(store);
        repository.save(company);
    }
}
