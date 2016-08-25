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

    public boolean equals(NovelBook other) {
        return super.equals(other) &&
                topics.equals(other.topics);
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}
