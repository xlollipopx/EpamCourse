package data;

import data.exception.DataException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader implements Reader{

    private final static Logger LOGGER = LogManager.getLogger(TextReader.class);

    public String read(String fileName) throws DataException {
        LOGGER.info("Trying to read file: " + fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            throw new DataException("File not found! ", e);
        }
        return stringBuilder.toString();
    }
}
