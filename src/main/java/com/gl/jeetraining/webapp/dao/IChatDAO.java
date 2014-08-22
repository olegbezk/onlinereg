package com.gl.jeetraining.webapp.dao;

import com.gl.jeetraining.webapp.model.Chat;

public interface IChatDAO {
	
	public void addChat(Chat chat);
	
	public void deletChat(Chat chat);
	
	public Chat getChats(int id);

}
