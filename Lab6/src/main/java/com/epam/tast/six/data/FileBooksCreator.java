package com.epam.tast.six.data;

import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.logic.BookParser;
import com.epam.tast.six.model.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileBooksCreator implements BooksCreator{
    private final String fileName;

    public FileBooksCreator(String fileName) {
        this.fileName = fileName;
    }

    public List<Book> create() throws DataException {
        String result = "";
        BookParser bookParser = new BookParser();
        List<Book> bookList = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                bookList.add(bookParser.parse(line));
            }
        } catch (IOException e) {
            throw new DataException("File not found! ", e);
        }
        return bookList;
    }

}


