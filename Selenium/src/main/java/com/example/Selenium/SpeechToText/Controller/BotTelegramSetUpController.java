package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.SpeechToText.Model.TelegramDataStoreModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;

public class BotTelegramSetUpController extends TelegramLongPollingBot {
    TelegramDataStoreModel telegramDataStoreModel;

    public BotTelegramSetUpController() {
        telegramDataStoreModel = new TelegramDataStoreModel();
    }

    @Override
    public void onUpdateReceived(Update update) {
        telegramDataStoreModel.setText(update.getMessage().getText());
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return telegramDataStoreModel.getBotUserName();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return telegramDataStoreModel.getBotToken();
    }


    @RequestMapping("/photo")
    public void SendPhoto() throws InterruptedException {
        Thread.sleep(2000);
        SendPhoto photo = new SendPhoto();
        photo.setChatId(telegramDataStoreModel.message.getChatId());
        photo.setPhoto(new InputFile(new File(String.valueOf(telegramDataStoreModel.filePathSaveCaptchaImage))));
        try {
            this.execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

