package com.gl.jeetraining.webapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.jeetraining.webapp.model.Role;

@Repository
public class RoleDAO implements IRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Role> getRoles() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Role").list();
		return list;
	}

	public void addRole(Role role) {
		getSessionFactory().getCurrentSession().persist(role);

	}

	public void delete(Role role) {
		getSessionFactory().getCurrentSession().delete(role);

	}

	public Role getRole(int id) {
		Role role = (Role) getSessionFactory().getCurrentSession().get(
				Role.class, id);
		return role;
	}

}
