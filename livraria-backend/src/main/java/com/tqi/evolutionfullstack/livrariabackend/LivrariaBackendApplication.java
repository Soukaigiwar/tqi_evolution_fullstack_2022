package com.tqi.evolutionfullstack.livrariabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableWebMvc
//public class LivrariaBackendApplication implements WebMvcConfigurer {
public class LivrariaBackendApplication {

//	@Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//    }


	public static void main(String[] args) {
		SpringApplication.run(LivrariaBackendApplication.class, args);
	}

}
