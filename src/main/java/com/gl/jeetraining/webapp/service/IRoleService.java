package com.gl.jeetraining.webapp.service;

import java.util.List;

import com.gl.jeetraining.webapp.model.Role;

public interface IRoleService {
	
	public Role getRole(int id);
	
	public List<Role> getRoles();

}
