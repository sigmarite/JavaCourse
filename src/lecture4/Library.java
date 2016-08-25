package lecture4;

import lecture2.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpividori on 25/08/16.
 */
public class Library {
    private List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book b) {
        bookList.add(b);
    }

    public void remove(Book b) {
        bookList.remove(b);
    }

    public int getNumberOfBooks() {
        return bookList.size();
    }

    public boolean containsBook(Book b) {
        return bookList.contains(b);
    }

    public List<Book> searchForTitle(String title){
        List<Book> searchResult = new ArrayList<Book>();
        for (Book b : bookList) {
            if (b.getTitle().equals(title)) searchResult.add(b);
        }
        return searchResult;
    }
}
