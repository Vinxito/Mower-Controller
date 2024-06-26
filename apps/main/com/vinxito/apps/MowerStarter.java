package com.vinxito.apps;

import com.vinxito.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        value = {"com.vinxito.*", "com.vinxito.controller.*", "com.vinxito.shared.*"}
)
public class MowerStarter {
    public static void main(String[] args) {
        SpringApplication.run(MowerStarter.class, args);
    }
}
