package com.epam.task.five.data;

import com.epam.task.five.exception.DataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStringAcquirer implements StringAcquirer{

    public String readString() throws DataException {

        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            do {
                line = bufferedReader.readLine();
            } while(bufferedReader.ready());
            stringBuilder.append(line);
        } catch (IOException e) {
          throw new DataException("DataException", e);
        }
        return stringBuilder.toString();
    }

}
