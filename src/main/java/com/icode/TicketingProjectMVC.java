package com.icode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class TicketingProjectMVC {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectMVC.class, args);
    }

    @Bean
    public ModelMap model() {
        return new ModelMap();
    }

}
