package com.epam.tast.six.specification.factory;

import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.specification.*;

public class SpecificationFactory {

    public Specification create(BookFieldType bookFieldType) {
        switch (bookFieldType){
            case AUTHOR_NAME:
                return new AuthorNameSpecification();
            case BOOK_NAME:
                return new BookNameSpecification();
            case COST:
                return new CostSpecification();
            case PUBLICATION_YEAR:
                return new PublicationYearSpecification();
            default:
                throw new DataException("Wrong field value! - " + bookFieldType);
        }
    }
}
