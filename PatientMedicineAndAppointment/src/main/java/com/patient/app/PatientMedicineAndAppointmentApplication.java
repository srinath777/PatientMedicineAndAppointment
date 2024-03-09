package com.patient.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class PatientMedicineAndAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMedicineAndAppointmentApplication.class, args);
	}
	
	@EnableWebMvc
	@Configuration
	public class WebConfig implements WebMvcConfigurer {      
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**")
	        .addResourceLocations("classpath:/static/","classpath:/img/")
	        .setCachePeriod(0);
	    }
	}


}
