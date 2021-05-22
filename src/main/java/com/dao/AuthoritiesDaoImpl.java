package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Authorities;

@Repository
@Transactional
public class AuthoritiesDaoImpl implements AuthoritiesDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addAuthorities(Authorities authorities) {		
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(authorities);
		session.flush();
		session.close();
	}

	@Override
	public Authorities findAuthoritiesByusername(String username) {
		Session session = sessionFactory.openSession();
		Authorities authorities = (Authorities) session.get(Authorities.class, username);
		System.out.println(authorities);
		session.close();
		return authorities;
	}
	
}
