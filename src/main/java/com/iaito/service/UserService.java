package com.iaito.service;

import com.iaito.dto.UserDTO;
import com.iaito.model.User;

public interface UserService {
	public void addUser(User user);
	public UserDTO findUserById(long userId);
	public UserDTO findUserByUsername(String username);
	public UserDTO updateUser(User user);
	public void deleteUser(User user);
	public boolean userLogin(String username, String password);
}
