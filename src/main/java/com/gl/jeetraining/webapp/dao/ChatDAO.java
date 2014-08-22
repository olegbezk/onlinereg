package com.gl.jeetraining.webapp.dao;

import org.hibernate.SessionFactory;
/**
 *  data access object for
 */
import org.springframework.beans.factory.annotation.Autowired;

import com.gl.jeetraining.webapp.model.Chat;

public class ChatDAO implements IChatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Chat getChats(int id) {
		Chat chat = (Chat) getSessionFactory().getCurrentSession().get(
				Chat.class, id);
		return chat;
	}

	public void deletChat(Chat chat) {
		getSessionFactory().getCurrentSession().delete(chat);

	}

	public void addChat(Chat chat) {
		getSessionFactory().getCurrentSession().persist(chat);
		
	}
}
