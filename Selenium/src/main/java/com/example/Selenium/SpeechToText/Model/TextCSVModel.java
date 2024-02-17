package com.example.Selenium.SpeechToText.Model;


import com.example.Selenium.SpeechToText.Controller.ExceptionController;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TextCSVModel extends ReadCSVModel {


    public TextCSVModel(CSVStoreModel csvStoreModel, CountDownLatch latchCSV, String columnName) {
        super(csvStoreModel, latchCSV, columnName);
    }

    @Override
    public void dataHandle(int columnIndex, CSVReader csvReader, CSVStoreModel csvStoreModel) throws IOException, CsvException {
        // Đọc dữ liệu từ cột và hiển thị nó
        List<String[]> allData = csvReader.readAll();
        for (String[] row : allData) {
            csvStoreModel.setReadTextOfColumn(row[columnIndex]);

            //check length
            if (csvStoreModel.getReadTextOfColumn().length() >= 4001) {
                System.out.println("TextCSV : " + csvStoreModel.getReadTextOfColumn());
                csvStoreModel.setFlag(false);
            } else if (csvStoreModel.getReadTextOfColumn().length() <= 4000) {
                System.out.println("TextCSV : " + csvStoreModel.getReadTextOfColumn());
                csvStoreModel.setFlag(true);
            }
        }
    }
}

class runtest {
    public static void main(String[] args) {
        CountDownLatch latchCSV = new CountDownLatch(3);

        CSVStoreModel textCSVStoreModel = new CSVStoreModel();
        CSVStoreModel voiceCSVStoreModel = new CSVStoreModel();
        CSVStoreModel fileNameCSVStoreModel = new CSVStoreModel();
        DataStoreModel fileNameDataStoreModel = new DataStoreModel();

        Thread t1 = new Thread(new TextCSVModel(textCSVStoreModel, latchCSV, "Text"));
        Thread t2 = new Thread(new VoiceCSVModel(voiceCSVStoreModel, latchCSV, "Voice"));
        Thread t3 = new Thread(new FileNameCSVModel(fileNameCSVStoreModel, fileNameDataStoreModel, latchCSV, "FileName"));

        t1.start();
        t2.start();
        t3.start();

        try {
            latchCSV.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(textCSVStoreModel.getFlag());
        System.out.println(fileNameCSVStoreModel.getFlag());
        System.out.println(voiceCSVStoreModel.getFlag());
    }
}

class tenko extends RuntimeException {
    public tenko(String thongdiep) {
        super(thongdiep);
    }
}

class main {
    public static void main(String[] args) throws FileNotFoundException {
        // dodai(null);
        docFile("asd");
    }

    public static void docFile(String fileten) throws FileNotFoundException {
        FileReader reader = new FileReader(fileten);
    }

    public static void dodai(String string)
            throws tenko, NullPointerException {
        if (string == null) {
            try {
                throw new Exception("ASd");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("go");
        System.out.println(string.length());
    }
}