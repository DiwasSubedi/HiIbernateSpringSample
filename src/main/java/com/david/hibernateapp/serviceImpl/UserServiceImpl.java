package com.david.hibernateapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.hibernateapp.domain.User;
import com.david.hibernateapp.repository.UserRepo;
import com.david.hibernateapp.repositoryImpl.UserRepoImpl;
import com.david.hibernateapp.service.USerService;

@Service
@Transactional
public class UserServiceImpl implements USerService{
	@Autowired
	UserRepo userRepo;

	@Override
	public void save(User u) {
	userRepo.save(u);
		
	}

	@Override
	public void modify(User u) {
		userRepo.modify(u);
		
	}

	@Override
	public void delete(User u) {
		userRepo.delete(u);
		
	}

	@Override
	public List<User> getAll() {
		List<User> userList = userRepo.getAll();
		return userList;
		
	}

	@Override
	public User searchByName(String name) {
		// TODO Auto-generated method stub
		return userRepo.searchByName(name);
	}

}
