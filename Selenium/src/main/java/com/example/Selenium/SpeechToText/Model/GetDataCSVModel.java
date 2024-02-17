package com.example.Selenium.SpeechToText.Model;

import com.example.Selenium.SpeechToText.Controller.EnumController;

import java.util.concurrent.CountDownLatch;

public class GetDataCSVModel {

    CSVStoreModel voiceCSVStoreModel;
    CSVStoreModel fileNameCSVStoreModel;

    DataStoreModel dataStoreModel;


    public GetDataCSVModel(CSVStoreModel voiceCSVStoreModel, CSVStoreModel fileNameCSVStoreModel, DataStoreModel dataStoreModel) {
        this.voiceCSVStoreModel = voiceCSVStoreModel;
        this.fileNameCSVStoreModel = fileNameCSVStoreModel;
        this.dataStoreModel = dataStoreModel;
    }

    public void getDataFromColumn(String columnName1, String columnName2, String columnName3) {
        CountDownLatch latchCSV = new CountDownLatch(3);

        CSVStoreModel textCSVStoreModel = new CSVStoreModel();
        voiceCSVStoreModel = new CSVStoreModel();
        fileNameCSVStoreModel = new CSVStoreModel();
        DataStoreModel fileNameDataStoreModel = new DataStoreModel();

        Thread threadReadTextColumnCSV = new Thread(new TextCSVModel(textCSVStoreModel, latchCSV, columnName1));
        Thread threadReadVoiceColumnnCSV = new Thread(new VoiceCSVModel(voiceCSVStoreModel, latchCSV, columnName2));
        Thread threadReadFileNameColumnCSV = new Thread(new FileNameCSVModel(fileNameCSVStoreModel, fileNameDataStoreModel, latchCSV, columnName3));

        threadReadTextColumnCSV.start();
        threadReadVoiceColumnnCSV.start();
        threadReadFileNameColumnCSV.start();

        try {
            latchCSV.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getNotificationErrorCSV() {
        if (fileNameCSVStoreModel.getFlag() == false || voiceCSVStoreModel.getFlag() == false) {
            dataStoreModel.setNotification(null);
            dataStoreModel.setStatus(null);
            if (voiceCSVStoreModel.getNotification() != null && fileNameCSVStoreModel.getNotification() != null) {
                dataStoreModel.setNotification(voiceCSVStoreModel.getNotification() + "\n" + fileNameCSVStoreModel.getNotification());
                dataStoreModel.setStatus(EnumController.ERROR_IN_CSV);
            } else if (voiceCSVStoreModel.getNotification() != null) {
                dataStoreModel.setNotification(voiceCSVStoreModel.getNotification());
                dataStoreModel.setStatus(EnumController.ERROR_IN_CSV);
            } else if (fileNameCSVStoreModel.getNotification() != null) {
                dataStoreModel.setNotification(fileNameCSVStoreModel.getNotification());
                dataStoreModel.setStatus(EnumController.ERROR_IN_CSV);
            }
        }
    }
}
