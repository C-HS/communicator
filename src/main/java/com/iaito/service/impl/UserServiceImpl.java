package com.iaito.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.UserDTO;
import com.iaito.model.User;
import com.iaito.repository.UserRepository;
import com.iaito.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired UserRepository userRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public UserDTO findUserById(long userId) {
		return modelMapper.map(userRepository.findById(userId), UserDTO.class);
	}

	@Override
	public UserDTO findUserByUsername(String username) {
		return modelMapper.map(userRepository.findUserByUsername(username), UserDTO.class);
	}

	@Override
	public UserDTO updateUser(User user) {
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public boolean userLogin(String username, String password) {
		User dummyUser = userRepository.findUserByUsername(username);
		if(dummyUser.getUserName().equalsIgnoreCase(username) && dummyUser.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}

}
