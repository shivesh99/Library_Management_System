package LBMS;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public int id;
    public int rackSize;
    public static Library library =null;

    private Library() {

    }
    public static Library getInstance(){
        if(library==null){
            library=new Library();
        }
        return library;
    }
}
