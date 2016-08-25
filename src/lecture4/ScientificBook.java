package lecture4;

import lecture2.Book;

/**
 * Created by mpividori on 24/08/16.
 */
public class ScientificBook extends Book {

    private String area;
    private boolean proceedings = false;

    public ScientificBook(String title, String author, int numOfPages, String[] topics, String ISBN, String area) {
        super(title, author, numOfPages, ISBN);
        this.area = area;
    }

    public ScientificBook(Book book, String area) {
        super(book);
        this.area = area;
    }

    @Override
    public String toString() {
        return "Scientific" +
                super.toString().substring(0, super.toString().length() - 1) +
                ", area='" + area + '\'' +
                ", proceedings=" + proceedings + '\'' +
                '}';
    }

    //    @Override                                                 !!SBAGLIATO
    public boolean equals(ScientificBook other) {
        return super.equals(other) &&
                area.equals(other.area) &&
                proceedings == other.proceedings;
    }

    public boolean superEquals(Book other) {
        return super.equals(other);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setProceedings() {
        this.proceedings = true;
    }

    public boolean isProceedings() {
        return proceedings;
    }
}
