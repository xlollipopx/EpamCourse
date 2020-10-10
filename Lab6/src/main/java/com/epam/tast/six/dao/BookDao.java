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
    private SpecificationFactory specificationFactory = new SpecificationFactory();
    private ComparatorFactory comparatorFactory = new ComparatorFactory();

    public int getSize() {
        return books.size();
    }

    public void addBook(Book book) throws DataException {
       if(!books.contains(book)){
           books.add(book);
       }
       else {
           throw new DataException("Book " + book.toString() + " already exists!");
       }
    }

    public void addBook(List<Book> bookList) {
        books.addAll(bookList);
    }

    public void removeBook(Book book) throws DataException {
        if(books.contains(book)) {
            books.remove(book);
        }
        else{
            throw new DataException("Book " + book.toString() + " does not exist!");
        }
    }

    public<T> List<Book> findByTeg(BookFieldType bookFieldType, T teg) throws DataException {
        Specification specification = specificationFactory.create(bookFieldType);
        return specification.find(books, teg);
    }

    public List<Book> sortByTeg(BookFieldType bookFieldType) throws DataException {
        Comparator<Book> comparator = comparatorFactory.create(bookFieldType);
        List<Book> sortedList = new LinkedList<>(books);
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

    public String toString() {
        return books.toString();
    }

}
