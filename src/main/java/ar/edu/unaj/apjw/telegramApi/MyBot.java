package ar.edu.unaj.apjw.telegramApi;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ar.edu.unaj.apwj.constants.Constant;

public class MyBot extends TelegramLongPollingBot {
 
	@Override
	public void onUpdateReceived(final Update update) {
		String messageTextReceived = update.getMessage().getText();
		Long chatId = update.getMessage().getChatId();
		SendMessage message = new SendMessage().setChatId(chatId).setText(messageTextReceived);
		
		try {
			if(message.getText().equalsIgnoreCase(Constant.HELLO))
				message.setText(Constant.GREET);
			
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public String getBotUsername() {
		return Constant.NAME_BOT;
	}
 
	@Override
	public String getBotToken() {
		return Constant.TOKEN;
	}
}
