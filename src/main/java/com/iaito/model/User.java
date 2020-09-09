package com.iaito.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	private Long Id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean enabled;
	private boolean locked;
	private boolean active;
	private Date createdAt;
	private Date updatedAt;
}
