package LBMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private int Id ;
    private String name;
    List<BookItem> bookList=new ArrayList<>();

    public User(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookItem> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookItem> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
