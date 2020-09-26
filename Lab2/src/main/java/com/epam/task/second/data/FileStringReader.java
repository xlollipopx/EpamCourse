package com.epam.task.second.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStringReader {

    public static String readString(String fileName)  {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String string = "";
        String result = "";

        try {
            while ((string = bufferedReader.readLine()) != null) {
                result += string;
                result += '\n';
            }
            result = result.substring(0,result.length() - 1);
        }
        catch(IOException ex ){
            System.out.println(ex.getMessage());
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
