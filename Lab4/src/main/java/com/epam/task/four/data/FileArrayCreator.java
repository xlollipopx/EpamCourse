package com.epam.task.four.data;

import com.epam.task.four.model.Array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileArrayCreator implements ArrayCreator {

    private String fileName;

    public FileArrayCreator(String fileName) {
        this.fileName = fileName;
    }

    public Array create() {
        BufferedReader bufferedReader = null;
        StringToArrayParser stringToArrayParser = new StringToArrayParser();
        String result = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                result+= line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Array(stringToArrayParser.parse(result));
    }

    public String readString(String fileName) {
        BufferedReader bufferedReader = null;
        String result = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                result+= line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
