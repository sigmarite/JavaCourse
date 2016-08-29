package lecture2;

import java.util.Arrays;

/**
 * Created by mpividori on 11/08/16.
 */
public class Book implements Comparable<Book> {
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

    public static boolean equals(Object o1, Object o2) {
        if (o1 == o2) return true;
        if (!(o1 instanceof Book) || !(o2 instanceof Book) ) return false;

        Book b1 = (Book) o1; Book b2 = (Book) o2;

        if (b1.getNumOfPages() != b2.getNumOfPages()) return false;
        if (!b1.getTitle().equals(b2.getTitle())) return false;
        if (!b1.getAuthor().equals(b2.getAuthor())) return false;
        return b1.getISBN().equals(b2.getISBN());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return Book.equals(this, o);
    }

    public boolean parentEquals(Book o){
        Class c1 = this.getClass(); Class c2 = o.getClass();
        if (c1.isAssignableFrom(c2)) return this.equals(this, o);
        if (c2.isAssignableFrom(c1)) return o.equals(this, o);
        return false;
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

    @Override
    public int compareTo(Book other) {
        int result;
        result = title.compareTo(other.title);
        if (result==0) {
            result = author.compareTo(other.author);
            if (result==0) {
                result = numOfPages - other.numOfPages;
            }
        }
        return result;
    }
}
