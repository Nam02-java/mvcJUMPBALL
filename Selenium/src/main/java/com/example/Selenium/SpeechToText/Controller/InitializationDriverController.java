package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.SpeechToText.Model.DataStoreModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;

public class InitializationDriverController {

    DataStoreModel dataStoreModel;

    public InitializationDriverController(DataStoreModel dataStoreModel) {
        this.dataStoreModel = dataStoreModel;
    }

    public void initializationDriver() {
        System.out.println("Params text : " + dataStoreModel.getParams().get("Text") + "\n"
                + "Params voice : " + dataStoreModel.getParams().get("Voice") + "\n"
                + "Params file name : " + dataStoreModel.getParams().get("FileName"));

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "D:\\New folder\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false); // disable chrome running as automation
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); // disable chrome running as automation

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // số giây mà 1 driver chờ để load 1 phần tử nếu không có thiết lập của wait
        driver.manage().window().maximize();
    }
}

class tes2t{
    public static void main(String[] args) {
        DataStoreModel dataStoreModel = new DataStoreModel();
        InitializationDriverController initializationDriverController  = new InitializationDriverController(dataStoreModel);
        initializationDriverController.initializationDriver();
    }
}