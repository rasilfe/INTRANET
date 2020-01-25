package br.com.capsule.FTP.service;

import br.com.capsule.FTP.mvc.model.User;
import br.com.capsule.FTP.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.isEnable(), true, true, true, getAuthorities(user));
        return userDetails;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(User u) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(u.getProfile()));
        //   permissao.getFornecedor().stream()
        //         .map(p -> new SimpleGrantedAuthority(p.getCnpj()))
        //       .forEach(authorities::add);
        return authorities;
    }

}
