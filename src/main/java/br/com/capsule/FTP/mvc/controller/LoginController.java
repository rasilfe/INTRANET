package br.com.capsule.FTP.mvc.controller;

import br.com.capsule.FTP.component.TokenUtil;
import br.com.capsule.FTP.mvc.model.User;
import br.com.capsule.FTP.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil token;

    @Autowired
    private LoginServiceImpl service;


    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
        authenticate(user.getUsername(), user.getPassword());
        final UserDetails userDetails = service.loadUserByUsername(user.getUsername());
        final String token = TokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
