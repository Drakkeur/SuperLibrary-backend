package edu.m2i.api_gestion_bibliotheque;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api-superlibrary/user/all") // Définissez le chemin de votre API
                .allowedOrigins("http://localhost:4200") // Autorisez votre frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes autorisées
                .allowedHeaders("*"); // Autorisez tous les en-têtes
    }
}
