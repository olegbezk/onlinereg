package com.gl.jeetraining.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.jeetraining.webapp.model.Role;
import com.gl.jeetraining.webapp.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		getSessionFactory().getCurrentSession().persist(user);
	}

	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	public User getUserById(int id) {
		List<?> list = getSessionFactory().getCurrentSession()
				.createQuery("from User where id=?").setParameter(0, id).list();
		return (User) list.get(0);
	}

	public List<User> getUsers() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
		return list;
	}

	public User getUserByRegInf(String login, String password) {
		List listRegInf = getSessionFactory().getCurrentSession()
				.createQuery("from User where login = ? and password = ?")
				.setParameter(0, login).setParameter(1, password).list();
		if (listRegInf.isEmpty()) {
			return null;
		}
		return (User) listRegInf.get(0);
	}

	public Role getRole(int id) {
		Role role = (Role) getSessionFactory().getCurrentSession().get(
				Role.class, id);
		return role;
	}

	public User getUserByLogin(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	public Role setRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
		return role;
	}

	public Role addRole(Role role) {
		getSessionFactory().getCurrentSession().persist(role);
		return role;
	}

	public Role deleteRole(Role role) {
		getSessionFactory().getCurrentSession().delete(role);
		return role;
	}

	@Override
	public List<Role> getRoles() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Role").list();
		return list;
	}

}
