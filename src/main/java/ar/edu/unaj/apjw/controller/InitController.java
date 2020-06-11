package ar.edu.unaj.apjw.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ar.edu.unaj.apjw.telegramApi.MyBot;
import ar.edu.unaj.apwj.constants.Constant;

@Controller
public class InitController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping("/TelegramBot")
	public String telegramBot(Model model) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
 
		try {
			telegramBotsApi.registerBot(new MyBot());
		} 
		catch (TelegramApiException e) {
			logger.warning("Error :" + e.getCause());
		}
		model.addAttribute(Constant.NAME, Constant.NAME_BOT);
		return "init";
	}
}
