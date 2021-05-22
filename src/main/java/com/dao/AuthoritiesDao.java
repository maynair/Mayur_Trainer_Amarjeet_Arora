package com.dao;

import com.model.Authorities;

public interface AuthoritiesDao {

	 void addAuthorities(Authorities authorities);
	 Authorities findAuthoritiesByusername(String username);
}
