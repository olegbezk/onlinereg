package com.gl.jeetraining.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jeetraining.webapp.dao.IRoleDAO;
import com.gl.jeetraining.webapp.model.Role;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class RoleService implements IRoleService{
	
	@Autowired
    private IRoleDAO roleDAO;

	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}



}
