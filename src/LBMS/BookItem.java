package LBMS;

import java.util.List;
import java.util.Objects;

public class BookItem extends Book{
    int barcode;
    Rack location;
    BookStatus status;
    User owner;

    public BookItem(Book book) {
        super(book.getBookId(), book.getBookName(), book.getAuthors(), book.getPublication(),book.getNoOfCopies());
    }

    public int getBarcode() {
        return barcode;
    }

    public BookItem(int bookId, String bookName, List<Author> authors, String publication, int copies,int barcode, Rack location, BookStatus status, User owner) {
        super(bookId, bookName, authors, publication,copies);
        this.barcode = barcode;
        this.location = location;
        this.status = status;
        this.owner = owner;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public Rack getLocation() {
        return location;
    }

    public void setLocation(Rack location) {
        this.location = location;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookItem)) return false;
        if (!super.equals(o)) return false;
        BookItem bookItem = (BookItem) o;
        return getBarcode() == bookItem.getBarcode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBarcode());
    }
}
