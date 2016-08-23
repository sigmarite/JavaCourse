package lecture2;

/**
 * Created by mpividori on 11/08/16.
 */
public class Book {
    String title;
    String author;
    int numOfPages;
    String[] topics;
    String ISBN;

    public Book(String title, String author, int numOfPages, String[] topics, String ISBN) {
        this.title = title;
        this.author = author;
        this.numOfPages = numOfPages;
        this.topics = topics;
        this.ISBN = ISBN;
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

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
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
