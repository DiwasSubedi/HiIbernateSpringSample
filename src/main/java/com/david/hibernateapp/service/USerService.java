package com.david.hibernateapp.service;

import java.util.List;

import com.david.hibernateapp.domain.User;

public interface USerService {
	
	public void save(User u);
	public void modify(User u);
	public void delete(User u);
	public List<User> getAll();
	public User searchByName(String name);

}
