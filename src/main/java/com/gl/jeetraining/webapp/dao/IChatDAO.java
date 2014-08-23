package com.gl.jeetraining.webapp.dao;

import java.util.List;

import com.gl.jeetraining.webapp.model.Chat;

public interface IChatDAO {
	
	public void addChat(Chat chat);
	
	public void deletChat(Chat chat);
	
	public Chat getChat(int id);
	
	public List<Chat> getChats();

}
