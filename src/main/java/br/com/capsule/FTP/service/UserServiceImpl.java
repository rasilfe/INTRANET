package br.com.capsule.FTP.service;

import br.com.capsule.FTP.exceptions.UserNotFoundException;
import br.com.capsule.FTP.mvc.model.Company;
import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.User;
import br.com.capsule.FTP.mvc.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements BasicCrud<User> {

    @Autowired
    private UserRepository repository;


    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public User find(String id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    @SneakyThrows
    public User update(String id, User user) {
        user.setId(id);
        return repository.save(user);
    }

    @SneakyThrows
    public void save(String s, Contact contact) {
        User user = repository.findById(s).orElseThrow(() -> new UserNotFoundException());
        user.setInfo(contact);
        repository.save(user);

    }

    @SneakyThrows
    public void saveCompany(String id, List<Company> companies) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setCompanies(companies);
        repository.save(user);
    }
}
