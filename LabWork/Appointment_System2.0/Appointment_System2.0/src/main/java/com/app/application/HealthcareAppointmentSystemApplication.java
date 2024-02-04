package com.app.application;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.app.entity"})
public class HealthcareAppointmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareAppointmentSystemApplication.class, args);
    }
	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
					.setMatchingStrategy(MatchingStrategies.STRICT)
					.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
}

