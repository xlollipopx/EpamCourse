package com.epam.tast.six.model;

import java.util.Objects;

public class Book implements Comparable{
    private String bookName;
    private String authorName;
    private int publicationYear;
    private int cost;

    public Book(String bookName, String authorName, int publicationYear, int cost) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.cost = cost;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getCost() {
        return cost;
    }

    public int compareTo(Object o) {
        Book book = (Book)o;
        if(this.authorName.equals(book.authorName) && this.bookName.equals(book.bookName) &&
        this.cost == book.cost && this.publicationYear == book.publicationYear) {
            return 0;
        }
        else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publicationYear=" + publicationYear +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                cost == book.cost &&
                bookName.equals(book.bookName) &&
                authorName.equals(book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authorName, publicationYear, cost);
    }
}

