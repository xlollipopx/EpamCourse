package com.epam.task.seven.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileDataReader implements DataReader{

    private final String fileName;

    public FileDataReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> read() throws DataException {
        String result = "";

        List<String> strings = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = bufferedReader.readLine()) != null) {
               strings.add(line);
            }
        } catch (IOException e) {
            throw new DataException("File not found! ", e);
        }
        return strings;
    }
}
