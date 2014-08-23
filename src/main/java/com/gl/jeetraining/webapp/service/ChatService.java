package com.gl.jeetraining.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jeetraining.webapp.dao.IChatDAO;
import com.gl.jeetraining.webapp.model.Chat;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class ChatService implements IChatService {

	@Autowired
	private IChatDAO chatDAO;

	public IChatDAO getChatDAO() {
		return chatDAO;
	}

	public void setChatDAO(IChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@Override
	public Chat getChat(int id) {
		return chatDAO.getChat(id);
	}

	@Override
	public List<Chat> getChats() {
		return getChatDAO().getChats();
	}

}
