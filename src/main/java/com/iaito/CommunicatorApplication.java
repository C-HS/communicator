package com.iaito;

import java.util.Arrays;
import java.util.HashSet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iaito.model.Authority;
import com.iaito.model.AuthorityType;
import com.iaito.model.User;
import com.iaito.repository.ContainerRepository;
import com.iaito.repository.UserRepository;

@SpringBootApplication
public class CommunicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicatorApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository){
		return args -> {
			userRepository.saveAll(
					Arrays.asList(
					new User(
							"Zafar",
							"Parvez",
							"nomey",
							"$2y$10$eyY1JSkj5vIRO9Iy/2RYy.LtBTk63QaTSutHRbuRZugk9fAEJ4ZrS", //nomey
							new HashSet<Authority>(
									Arrays.asList(
											new Authority(AuthorityType.ROLE_USER),
											new Authority(AuthorityType.ROLE_ADMIN)
									)
							)
					),
					new User(
							"Faisal",
							"Habib",
							"habib",
							"$2y$10$hjtDkOjj2AfAtLFnGd7tYu7pq5Ga1yhlXvavdNFIKQxtbf8wYq8KS",  //habib
							new HashSet<Authority>(
									Arrays.asList(
											new Authority(AuthorityType.ROLE_USER)
									)
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
