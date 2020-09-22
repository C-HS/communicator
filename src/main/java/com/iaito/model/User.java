package com.iaito.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String userName;
	private String password;
//	private Date createdAt;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	private Set<Authority> authorities = new HashSet<>();
	public User(String  username, String password, Set<Authority> authoritySet){
		this.userName = username;
		this.password = password;
		this.authorities = authoritySet;

	}
}
