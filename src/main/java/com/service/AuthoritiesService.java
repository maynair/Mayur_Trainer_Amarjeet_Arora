package com.service;

import com.model.Authorities;

public interface AuthoritiesService {

	 void addAuthorities(Authorities authorities);
	 Authorities findAuthoritiesByusername(String username);
}
