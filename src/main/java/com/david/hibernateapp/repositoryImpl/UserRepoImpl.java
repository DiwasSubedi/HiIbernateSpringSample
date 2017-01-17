package com.david.hibernateapp.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.david.hibernateapp.domain.User;
import com.david.hibernateapp.repository.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public void save(User u) {
		Session sess = sf.getCurrentSession();
		sess.persist(u);
	}

	@Override
	public void modify(User u) {
		Session sess = sf.getCurrentSession();
		sess.update(u);
	}

	@Override
	public void delete(User u) {
		Session sess = sf.getCurrentSession();
		sess.delete(u);
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<User> getAll() {
		Session sess = sf.getCurrentSession();
		List<User> personsList = (List<User>) sess.createQuery("from User").list();
		return personsList;
	}

	@Override
	public User searchByName(String name) {
		Session sess = sf.getCurrentSession();
		Criteria ctr = sess.createCriteria(User.class);
        ctr.add(Restrictions.eq("firstName",name));
        return (User) ctr.uniqueResult();
	}

}
