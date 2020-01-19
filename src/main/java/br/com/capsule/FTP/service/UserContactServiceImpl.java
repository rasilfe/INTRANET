package br.com.capsule.FTP.service;

import br.com.capsule.FTP.exceptions.UserNotFoundException;
import br.com.capsule.FTP.mvc.model.Contact;
import br.com.capsule.FTP.mvc.model.User;
import br.com.capsule.FTP.mvc.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactServiceImpl implements BasicSubrud<Contact, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @SneakyThrows
    public void save(String id, Contact contact){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setInfo(contact);
        userRepository.save(user);
    }

    @Override
    @SneakyThrows
    public void delete(String s) {
        User user = userRepository.findById(s).orElseThrow(() -> new UserNotFoundException());
        user.setInfo(null);
        userRepository.save(user);
    }

    @Override
    @SneakyThrows
    public Contact find(String s){
        return userRepository.findById(s).orElseThrow(() -> new UserNotFoundException()).getInfo();
    }

    @Override
    @SneakyThrows
    public List<Contact> findAll(String s){
        return null;
    }

    @Override
    public Contact update(String s, Contact contact) {
        return null;
    }
}
