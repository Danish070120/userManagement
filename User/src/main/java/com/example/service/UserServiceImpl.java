package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Qualification;
import com.example.entity.User;
import com.example.repository.CategoryRepository;
import com.example.repository.QualificationRepository;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	QualificationRepository qualificationRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public User saveUser(User user) {
		log.info("user {}", user);
		userRepository.save(user);
		qualificationRepository.saveAll(user.getQualification());
		Qualification qualification = new Qualification();

		// categoryRepository.save(qualification.getCategory());
		return user;
	}

	@Override
	public List<User> fetchUserList() {

		return (List<User>) userRepository.findAll();

	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
}
