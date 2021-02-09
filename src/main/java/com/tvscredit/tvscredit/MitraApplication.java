package com.tvscredit.tvscredit;

import com.tvscredit.tvscredit.config.BeanNotNullCopy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MitraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitraApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public BeanNotNullCopy createBeanNotNullCopy(){
		return new BeanNotNullCopy();
	}

}

