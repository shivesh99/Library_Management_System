package LBMS;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private int rackId;
    private int rackSize=10;
    List<BookItem> bookItems=new ArrayList<>();

    public int getRackId() {
        return rackId;
    }

    public void setRackId(int rackId) {
        this.rackId = rackId;
    }

    public int getRackSize() {
        return rackSize;
    }

    public void setRackSize(int rackSize) {
        this.rackSize = rackSize;
    }

    public List<BookItem> getBookItems() {
        return bookItems;
    }

    public void setBookItems(List<BookItem> books) {
        this.bookItems = books;
    }
}
