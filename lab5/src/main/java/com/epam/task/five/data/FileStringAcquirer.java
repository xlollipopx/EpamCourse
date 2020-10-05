package com.epam.task.five.data;

import com.epam.task.five.exception.DataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStringAcquirer implements StringAcquirer {
    private String fileName;

    public FileStringAcquirer(String fileName) {
        this.fileName = fileName;
    }

    public String readString() throws DataException {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new DataException("File not found! ", e);
        }
        return stringBuilder.toString();
    }

}
