package br.com.capsule.FTP.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String username;
        try {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException e) {
            username = "KONOHA";
        }

        return Optional.of(username);
    }
}