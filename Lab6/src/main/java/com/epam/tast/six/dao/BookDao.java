package com.epam.tast.six.dao;

import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.logic.comparator.factory.ComparatorFactory;
import com.epam.tast.six.model.Book;
import com.epam.tast.six.logic.specification.Specification;
import com.epam.tast.six.logic.specification.factory.SpecificationFactory;

import java.util.*;

public class BookDao implements Dao{
    private LinkedHashSet<Book> books = new LinkedHashSet<>();

    public void addBook(Book book)  {
       if(!books.contains(book)){
           books.add(book);
       }
       else {
           throw new DataException("Book " + book.toString() + " already exists!");
       }
    }

    public void removeBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
        }
        else{
            throw new DataException("Book " + book.toString() + " does not exist!");
        }
    }

    public<T> List<Book> findByTeg(BookFieldType bookFieldType, T teg) {
        SpecificationFactory factory = new SpecificationFactory();
        Specification specification = factory.create(bookFieldType);
        return specification.find(books, teg);
    }

    public List<Book> sortByTeg(BookFieldType bookFieldType) {
        ComparatorFactory factory = new ComparatorFactory();
        Comparator<Book> comparator = factory.create(bookFieldType);
        List<Book> sortedList = new LinkedList<>(books);
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

}
