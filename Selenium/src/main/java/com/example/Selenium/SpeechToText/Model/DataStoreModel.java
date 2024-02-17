package com.example.Selenium.SpeechToText.Model;

import com.example.Selenium.SpeechToText.Controller.EnumController;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class DataStoreModel {

    public String text, text_constructor,notification,userName,userPassword = null;
    public CountDownLatch latch = new CountDownLatch(1);
    public CountDownLatch countDownLatch;
    public final int limitChar = 2000;
    public ArrayList<String> arrayList_Char = new ArrayList<>();
    public int count = 0;
    public Map<String, String> params;
    public String DownloadsFilePath = "E:\\New folder\\";
    public WebElement webElement;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor javascriptExecutor;
    public List<WebElement> webElementList = null;

    public EnumController status;

    public DataStoreModel() {
    }

    public EnumController getStatus() {
        return status;
    }

    public void setStatus(EnumController status) {
        this.status = status;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void setWebDriverWait(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor;
    }

    public void setJavascriptExecutor(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<WebElement> getWebElementList() {
        return webElementList;
    }

    public void setWebElementList(List<WebElement> webElementList) {
        this.webElementList = webElementList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_constructor() {
        return text_constructor;
    }

    public void setText_constructor(String text_constructor) {
        this.text_constructor = text_constructor;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public int getLimitChar() {
        return limitChar;
    }

    public ArrayList<String> getArrayList_Char() {
        return arrayList_Char;
    }

    public void setArrayList_Char(ArrayList<String> arrayList_Char) {
        this.arrayList_Char = arrayList_Char;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getDownloadsFilePath() {
        return DownloadsFilePath;
    }

    public void setDownloadsFilePath(String downloadsFilePath) {
        DownloadsFilePath = downloadsFilePath;
    }
}

