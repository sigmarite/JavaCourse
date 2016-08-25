package lecture4;

import lecture2.Book;

import java.util.Arrays;

/**
 * Created by mpividori on 25/08/16.
 */

public class NovelBook extends Book {

    private String[] topics;

    public NovelBook(String title, String author, int numOfPages, String ISBN, String[] topics) {
        super(title, author, numOfPages, ISBN);
        this.topics = topics;
    }

    public NovelBook(Book other, String[] topics) {
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
                Arrays.equals(topics, other.topics);
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }
}
