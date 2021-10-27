package com.seat_code.apps;

import com.seat_code.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        value = {"com.seat_code.*", "com.seat_code.controller.*", "com.seat_code.shared.*"}
)
public class MowerBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MowerBackendApplication.class, args);
    }
}
