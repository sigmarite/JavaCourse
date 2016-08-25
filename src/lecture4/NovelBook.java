package lecture4;

import lecture2.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mpividori on 25/08/16.
 */

public class NovelBook extends Book {

    private List<String> topics;

    public NovelBook(String title, String author, int numOfPages, String ISBN, List<String> topics) {
        super(title, author, numOfPages, ISBN);
        this.topics = topics;
    }

    public NovelBook(Book other, List<String> topics) {
        super(other);
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Novel" +
                super.toString().substring(0, super.toString().length() - 1) +
                ", topics='" + topics + '\'' +
                '}';
    }

    public static boolean equals(Object o1, Object o2) {
        if (!Book.equals(o1, o2)) return false;
        if (!(o1 instanceof NovelBook) || !(o2 instanceof NovelBook) ) return false;

        NovelBook nb1 = (NovelBook) o1; NovelBook nb2 = (NovelBook) o2;
        return nb1.getTopics().equals(nb2.getTopics());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return NovelBook.equals(this, o);
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}
