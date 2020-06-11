package ar.edu.unaj.apjw.service;

import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ar.edu.unaj.apwj.constants.Constant;

@Service
public class BotService {
	
	public SendMessage responseMessage(SendMessage message) {
		if(message.getText().equalsIgnoreCase(Constant.HELLO))
			message.setText(Constant.GREET);
		
		return message;
	}
}
