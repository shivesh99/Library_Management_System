package LBMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private int bookId;
    private String bookName;

    private List<Author> authors =new ArrayList<>();
    private String publication;
    private int noOfCopies;

    public Book(int bookId, String bookName, List<Author> authors, String publication,int copies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authors = authors;
        this.publication = publication;
        this.noOfCopies = copies;
    }


    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        authors = authors;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId());
    }
}
