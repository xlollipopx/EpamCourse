package com.epam.tast.six.logic.comparator.factory;

import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.logic.comparator.AuthorNameComparator;
import com.epam.tast.six.logic.comparator.BookNameComparator;
import com.epam.tast.six.logic.comparator.CostComparator;
import com.epam.tast.six.logic.comparator.PublishingYearComparator;
import com.epam.tast.six.model.Book;

import java.util.Comparator;

public class ComparatorFactory {

   public Comparator<Book> create(BookFieldType bookFieldType) throws DataException {
        switch (bookFieldType) {
            case BOOK_NAME:
                return new BookNameComparator();
            case AUTHOR_NAME:
                return new AuthorNameComparator();
            case COST:
                return new CostComparator();
            case PUBLICATION_YEAR:
                return new PublishingYearComparator();
            default:
                throw new DataException("Wrong field value! - " + bookFieldType);
        }
    }
}

