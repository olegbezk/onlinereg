package com.gl.jeetraining.webapp.service;

import java.util.List;

import com.gl.jeetraining.webapp.model.Chat;

public interface IChatService {
	
	public Chat getChat(int id);
	
	public List<Chat> getChats();
	
	

}
