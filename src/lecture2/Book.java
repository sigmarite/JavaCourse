package lecture2;

import java.util.Arrays;

/**
 * Created by mpividori on 11/08/16.
 */
public class Book {
    private String title;
    private String author;
    private int numOfPages;
    private String ISBN;

    public Book(String title, String author, int numOfPages, String ISBN) {
        this.title = title;
        this.author = author;
        this.numOfPages = numOfPages;
        this.ISBN = ISBN;
    }

    public Book(Book other) {
        this(other.title, other.author, other.numOfPages, other.ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numOfPages=" + numOfPages +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public boolean equals(Book other) {
        return title.equals(other.title) &&
                author.equals(other.author) &&
                numOfPages == other.numOfPages &&
                ISBN.equals(other.ISBN);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getInitials(){
        String initials= "";
        for (int i=0; i<author.length(); i++) {
            char currentChar = author.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z')
                initials = initials + currentChar + '.';
        }
        return initials;
    }
}
