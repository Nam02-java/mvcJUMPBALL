package com.example.Selenium.SpeechToText.Controller;

import com.example.Selenium.SpeechToText.Model.*;
import com.example.Selenium.SpeechToText.View.Response;
import org.springframework.http.ResponseEntity;

public class AllProcessController {

    DataStoreModel dataStoreModel;
    CSVStoreModel voiceCSVModel;

    CSVStoreModel fileNameCSVModel;

    CSVStoreModel textCSVModel;

    public void work() {

        GetDataCSVModel getDataCSVModel = new GetDataCSVModel(voiceCSVModel, fileNameCSVModel, dataStoreModel);
        getDataCSVModel.getDataFromColumn("Text", "Voice", "FileName");

        getDataCSVModel.getNotificationErrorCSV();
        if (dataStoreModel.getStatus().equals(EnumController.ERROR_IN_CSV)) {
            Response response = new Response();
            response.SpeechToText(dataStoreModel.getNotification());
        }

        if (textCSVModel.getFlag() == true) {

        }
        if(textCSVModel.getFlag()== false){

        }
    }
}
