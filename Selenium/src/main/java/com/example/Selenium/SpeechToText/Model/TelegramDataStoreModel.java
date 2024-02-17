package com.example.Selenium.SpeechToText.Model;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TelegramDataStoreModel {

    public String text = null;
    public String botUserName = "CaptchaSlove_bot";
    public String botToken = "6928830332:AAGmv3fN_k8YdITzJeOyjqtsDQfWuviF308";
    public String filePathSaveCaptchaImage = "E:\\CongViecHocTap\\Captcha\\captcha.png";
    public SendMessage message = new SendMessage("1159534870", "");



    public TelegramDataStoreModel() {
    }

    public TelegramDataStoreModel(String text, String botUserName, String botToken, String filePathSaveCaptchaImage, SendMessage message) {
        this.text = text;
        this.botUserName = botUserName;
        this.botToken = botToken;
        this.filePathSaveCaptchaImage = filePathSaveCaptchaImage;
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBotUserName() {
        return botUserName;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getFilePathSaveCaptchaImage() {
        return filePathSaveCaptchaImage;
    }

    public void setFilePathSaveCaptchaImage(String filePathSaveCaptchaImage) {
        this.filePathSaveCaptchaImage = filePathSaveCaptchaImage;
    }

    public SendMessage getMessage() {
        return message;
    }

    public void setMessage(SendMessage message) {
        this.message = message;
    }
}
