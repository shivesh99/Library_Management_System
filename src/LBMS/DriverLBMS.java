package LBMS;

import java.util.ArrayList;
import java.util.List;

public class DriverLBMS {
    public static void main(String[] args) {
        LibraryService libraryService=LibraryService.getInstance();

        System.out.println("Library Service started!!");

        libraryService.createLibrary(1,5);

        List<Author> authors=new ArrayList<>();
        Author ram=new Author(1,"ram");

        ram.getBookList().add(new Book(1,"Geeta",authors,"swamijee",2));
        authors.add(ram);
        List<Integer> barcodes=new ArrayList<>();
        barcodes.add(11);
        barcodes.add(12);
        barcodes.add(13);
        barcodes.add(14);
        barcodes.add(15);
        barcodes.add(16);
        barcodes.add(17);


        libraryService.addBookItem(1,"Geeta",authors,"swamijee",barcodes);
        List<Integer> ramayanBarcodes=new ArrayList<>();
        ramayanBarcodes.add(21);
        ramayanBarcodes.add(22);
        ramayanBarcodes.add(23);
        ramayanBarcodes.add(24);
        ramayanBarcodes.add(25);
        libraryService.addBookItem(2,"Ramayan",authors,"swamijee",ramayanBarcodes);

        User ramu =new User(111,"Ramu");
        libraryService.addUser(ramu);
        libraryService.borrowBookItem(11,111);
        libraryService.borrowBookItem(21,111);
        libraryService.borrowBookItem(12,111);
        libraryService.borrowBookItem(31,111);
        libraryService.borrowBookItem(23,111);
        libraryService.borrowBookItem(25,111);




        libraryService.printBorrowed(111);

        libraryService.returnBook(31);
        libraryService.printBorrowed(111);
        libraryService.returnBook(23);
        libraryService.printBorrowed(111);




    }
}
