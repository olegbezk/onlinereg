package com.gl.jeetraining.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jeetraining.webapp.dao.IUserDAO;
import com.gl.jeetraining.webapp.model.Role;
import com.gl.jeetraining.webapp.model.User;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class UserService implements IUserService {

    @Autowired
	private IUserDAO userDAO;

    @Transactional(readOnly = false)
	public void addUser(User user) {
	    userDAO.addUser(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}
	
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}
	
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}
	
	public User getUserByRegInf(String login,String password) {
		return getUserDAO().getUserByRegInf(login, password);
	}
	
	public User getUserByLogin(String login) {
		return getUserDAO().getUserByLogin(login);
	}

	public List<User> getUsers() {	
		return getUserDAO().getUsers();
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Role getRole(int id) {
			return userDAO.getRole(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Role addRole(Role role) {
				return userDAO.addRole(role);
	}

	@Override
	@Transactional(readOnly = false)
	public Role deleteRole(Role role) {
		return userDAO.deleteRole(role);
	}

	@Override
	@Transactional(readOnly = false)
	public Role setRole(Role role) {
		return userDAO.setRole(role);
	}

}
