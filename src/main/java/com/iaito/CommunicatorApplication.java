package com.iaito;

import com.iaito.model.Authority;
import com.iaito.model.AuthorityType;
import com.iaito.model.User;
import com.iaito.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CommunicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicatorApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository){
		return args -> {
			userRepository.save(
					new User(
							"Zafar",
							"Parvez",
							"nomey",
							"$2y$10$eyY1JSkj5vIRO9Iy/2RYy.LtBTk63QaTSutHRbuRZugk9fAEJ4ZrS",
							new HashSet<Authority>(
									Arrays.asList(
											new Authority(AuthorityType.ROLE_USER),
											new Authority(AuthorityType.ROLE_ADMIN)
									)
							)
					)
			);
		};
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
