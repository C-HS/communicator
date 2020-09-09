package com.iaito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long Id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean enabled;
	private boolean locked;
	private boolean active;
}
