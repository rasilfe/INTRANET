package br.com.capsule.FTP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class CORS implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE",
                "CONNECT").allowCredentials(true);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        List<String> ao = new ArrayList<String>();
        ao.add("*");
        configuration.setAllowedOrigins(ao);
        List<String> am = new ArrayList<String>();
        am.add("HEAD");
        am.add("GET");
        am.add("POST");
        am.add("PUT");
        am.add("DELETE");
        am.add("PATCH");
        configuration.setAllowedMethods(am);
        configuration.setAllowCredentials(true);
        List<String> ah = new ArrayList<String>();
        ah.add("Authorization");
        ah.add("Cache-Control");
        ah.add("Content-Type");
        configuration.setAllowedHeaders(ah);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}