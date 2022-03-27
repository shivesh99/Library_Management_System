package LBMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private static LibraryService libraryService= null;
    public Map<Integer,Book> bookMap =new HashMap<>();
    public Map<Integer,BookItem> bookItemMap =new HashMap<>();

    public Map<Integer,User> userMap=new HashMap<>();
    public List<Rack>rackList=new ArrayList<>();

    public  Library library=Library.getInstance();



    private LibraryService() {
    }
    public static LibraryService getInstance(){
        if(libraryService==null){
            libraryService=new LibraryService();
            //return libraryService;
        }
        return libraryService;
    }

    public Library createLibrary(int libId,int rackSize){

        Library lib=Library.getInstance();
        lib.id=libId;
        lib.rackSize=rackSize;
        for(int i=0;i<rackSize;i++){
            Rack rack=new Rack();
            rack.setRackId(i);
            List<BookItem> bookItems= new ArrayList<>();
            rack.setBookItems(bookItems);
            rackList.add(rack);
        }
        System.out.println("Created Library with size "+rackSize);
        return lib;
    }

    public void addBookItem(int bookId, String name, List<Author>authors,String publisher,List<Integer>bookItemBarcodes){
        int size=0;
        if(bookMap.containsKey(bookId)){size=bookMap.get(bookId).getNoOfCopies();}

        Book book=new Book(bookId,name,authors,publisher,size+bookItemBarcodes.size());

        bookMap.put(bookId,book);

        for(Integer i: bookItemBarcodes){
            BookItem bookItem=new BookItem(book);
            bookItem.setBarcode(i);
            Library lib =Library.getInstance();
            for(int j=0;j<lib.rackSize;j++){
                if(rackList.get(j).getBookItems().size()<10){
                    bookItem.setLocation(rackList.get(j));
                    bookItem.setStatus(BookStatus.AVAILABLE);
                    rackList.get(j).getBookItems().add(bookItem);
                    bookItemMap.put(i,bookItem);
                    System.out.println("Book with barcode "+i +" added in Rack with rackId"+(j+1) );
                break;
                }
            }

        }

    }

    public void removeBookItem(int barcode){

        BookItem bookItem=bookItemMap.get(barcode);
        if (bookItem!=null && bookItem.getStatus()==BookStatus.AVAILABLE){
            Library lib =Library.getInstance();
            for(int j=0;j<lib.rackSize;j++){
                if(rackList.get(j).getBookItems().contains(bookItem)){
                    rackList.get(j).getBookItems().remove(bookItem);
                    //bookItemMap.put(i,bookItem);
                    System.out.println("Book with barcode "+barcode+" removed from "+(j+1)+" th Rack " );
                    break;
                }
            }

        }else{
            System.out.println("Book with barcode "+barcode+" issued to "+ bookItem.getOwner().getName() +" So cant remove now!!");
        }

    }
    public void addUser(User user){
        if(!userMap.containsValue(user)) {
            userMap.put(user.getId(), user);
            System.out.println("User with usedID " + user.getId() + " added in user database");
        }else {
            System.out.println("User is already present in user database!! ");
        }
    }

    public void borrowBookItem(int barcode,int userId){
        if(bookItemMap.containsKey(barcode)){
            if(userMap.containsKey(userId)){
                BookItem bookItem=bookItemMap.get(barcode);
                if(userMap.get(userId).getBookList().size()<5){
                    Rack rack =bookItem.getLocation();
                    rack.getBookItems().remove(bookItem);
                    bookItem.setStatus(BookStatus.ISSUED);
                    bookItem.setOwner(userMap.get(userId));
                    int bookId =bookItem.getBookId();
                    Book book =bookMap.get(bookId);
                    int k=book.getNoOfCopies();
                    book.setNoOfCopies(k-1);
                    userMap.get(userId).getBookList().add(bookItem);
                    System.out.println("book item with barcode "+barcode+"  issued to user with  "+userId);
                }else {
                    System.out.println("User already have issued 5 books");
                }


            }else {
                System.out.println("Invalid UserId");
            }


        }else {
            System.out.println("Invalid barcode!!");
        }
    }

    public void returnBook(int barcode){
        if (bookItemMap.containsKey(barcode)) {
            BookItem bookItem = bookItemMap.get(barcode);
            Book book = bookMap.get(bookItem.getBookId());
            User user = bookItem.getOwner();
            user.getBookList().remove(bookItem);
            book.setNoOfCopies(book.getNoOfCopies() + 1);
            bookItem.setOwner(null);
            bookItem.setStatus(BookStatus.AVAILABLE);


            Library lib = Library.getInstance();
            for (int j = 0; j < lib.rackSize; j++) {
                if (rackList.get(j).getBookItems().size() <= 10) {
                    bookItem.setLocation(rackList.get(j));
                    bookItem.setStatus(BookStatus.AVAILABLE);
                    rackList.get(j).getBookItems().add(bookItem);
                    //bookItemMap.put(i,bookItem);
                    System.out.println("Book with barcode " + barcode + " added in " + (j + 1) + "th Rack after getting returned by user with userID " + user.getId());
                    break;
                }
            }
        }else{
            System.out.println("No book is present with barcode "+barcode+" in Library!!");
        }



    }
    public void printBorrowed(int userId){
        User user =userMap.get(userId);
        if(user.getBookList().size()>0) {
            System.out.print("Books issued for userId "+user.getId()+" are :");
            for (BookItem bk : user.getBookList()) {
                System.out.print(" " + bk.getBarcode());

            }
            System.out.println("");
        }else {
            System.out.println("No Books are issued for userId :"+user.getId());
        }

    }
//    public void borrowBook(int bookId,int userId){
//        if(bookMap.containsKey(bookId)){
//            if(userMap.containsKey(userId)){
//                if(bookMap.get(bookId).getNoOfCopies()>0){
//
//
//                }else {
//                    System.out.println("book copies not available!!");
//                }
//
//            }else {
//                System.out.println("Invalid UserId");
//            }
//
//
//        }else {
//            System.out.println("Invalid bookId");
//        }
//    }
}
